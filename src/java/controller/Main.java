package controller;

import dtos.UserDTO;
import daos.RoleDAO;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class Main extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession(true);
        UserDTO user = (UserDTO) session.getAttribute("USER");

        if (user != null) {
            String username = user.getUsername();
            RoleDAO dao = new RoleDAO();
            int role = dao.getRoleByUserName(username);

            switch (role) {
                case 1 ->
                    response.sendRedirect("/admin/home");
                case 2 ->
                    response.sendRedirect("/staff/home");
                case 3 ->
                    response.sendRedirect("/customer/home");
                default ->
                    throw new AssertionError();
            }
        } else {
            response.sendRedirect("login");
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
