package controller;

import daos.ScheduleDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class RemoveSchedule extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int schedule_id = Integer.parseInt(request.getParameter("schedule_id"));
        try {
            ScheduleDAO scheduleDAO = new ScheduleDAO();
            scheduleDAO.removeSchedule(schedule_id);
        } catch (Exception e) {
            System.out.println(e);
        } finally{
            response.sendRedirect("home");
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
