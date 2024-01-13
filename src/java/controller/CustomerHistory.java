package controller;

import daos.BillingDAO;
import dtos.BillingDetailDTO;
import dtos.UserDTO;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.List;

public class CustomerHistory extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession(true);
        UserDTO user = (UserDTO) session.getAttribute("USER");
        String username = user.getUsername();

        BillingDAO billingDAO = new BillingDAO();
        List<BillingDetailDTO> bills = billingDAO.getBillByUsername(username);
        if (bills != null) {
            request.setAttribute("BILLS", bills);
        }
        request.getRequestDispatcher("history.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.sendRedirect("home");
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
