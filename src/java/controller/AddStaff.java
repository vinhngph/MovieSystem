package controller;

import daos.StaffDAO;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import dtos.UserDTO;
import daos.UserDAO;
import dtos.StaffDTO;

public class AddStaff extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("addStaff.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        UserDTO user = new UserDTO(username, password);

        String name = request.getParameter("name");
        String department = request.getParameter("department");
        String salary_raw = request.getParameter("salary");
        int salary = Integer.parseInt(salary_raw);
        StaffDTO staff = new StaffDTO(username, name, department, salary);

        HttpSession session = request.getSession(true);
        try {
            StaffDAO staffDAO = new StaffDAO();
            UserDAO userDAO = new UserDAO();
            UserDTO checkUser = userDAO.getUserByUsername(username);
            //null == there is no user account
            if (checkUser == null) {
                userDAO.addUser(user);
                staffDAO.addStaff(staff);

                response.sendRedirect("home");
            } else {
                session.setAttribute("ExistedUser", "This username is already in use");
                response.sendRedirect("add_staff");
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
