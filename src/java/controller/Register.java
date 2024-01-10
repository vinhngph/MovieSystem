package controller;

import daos.UserDAO;
import dtos.UserDTO;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class Register extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("register.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession(true);

        try {
            String username = request.getParameter("username");
            String password = request.getParameter("password");

            UserDAO dao = new UserDAO();
            UserDTO user = dao.getUserByUsername(username);
            if (user == null) {
                UserDTO addUser = new UserDTO(username, password);
                session.setAttribute("USER", addUser);

                response.sendRedirect("customer/information");
            } else {
                session.setAttribute("ExistedUser", "This username is already in use");
                response.sendRedirect("register");
            }
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
