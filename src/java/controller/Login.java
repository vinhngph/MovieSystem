package controller;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import daos.RoleDAO;
import daos.UserDAO;
import dtos.UserDTO;

public class Login extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("login.jsp").forward(request, response);
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession(true);
        try {
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            
            UserDAO dao = new UserDAO();
            UserDTO user = dao.checkLogin(username, password);
            String name = dao.getNameByUsername(username);
            if (user != null) {
                session.setAttribute("USER", user);
                session.setAttribute("NAME", name);
                
                response.sendRedirect("Main");
            } else {
                session.setAttribute("InvalidUser", "Invalid username or password");
                response.sendRedirect("login");
            }
        } catch (IOException e) {
            System.out.println(e);
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
