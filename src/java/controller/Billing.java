package controller;

import daos.BillingDAO;
import daos.ScheduleDAO;
import dtos.ListSchedulesDTO;
import dtos.UserDTO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class Billing extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession(true);
        int schedule_id = (int) session.getAttribute("schedule_id");

        ScheduleDAO scheduleDAO = new ScheduleDAO();
        ListSchedulesDTO schedule = scheduleDAO.getScheduleById(schedule_id);

        request.setAttribute("SCHEDULE", schedule);
        request.getRequestDispatcher("ticketAmount.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession(true);
        int amount = Integer.parseInt(request.getParameter("amount"));

        int schedule_id = (int) session.getAttribute("schedule_id");
        session.removeAttribute("schedule_id");

        UserDTO user = (UserDTO) session.getAttribute("USER");
        String username = user.getUsername();

        int rate = 50;
        int price = amount * rate;

        BillingDAO billingDAO = new BillingDAO();
        billingDAO.addBill(schedule_id, username, amount, price);

        ScheduleDAO scheduleDAO = new ScheduleDAO();
        ListSchedulesDTO schedule = scheduleDAO.getScheduleById(schedule_id);
        int oldQuantity = schedule.getQuantity();
        int remainQuantity = oldQuantity - amount;
        scheduleDAO.updateQuantity(remainQuantity, schedule_id);

        response.sendRedirect("home");
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
