package controller;

import daos.StaffDAO;
import daos.UserDAO;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class RemoveStaff extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = request.getParameter("username");
        try {
            UserDAO userDAO = new UserDAO();
            StaffDAO staffDAO = new StaffDAO();

            staffDAO.removeStaff(username);
            userDAO.removeUser(username);
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            response.sendRedirect("home");
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
