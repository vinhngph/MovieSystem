package controller;

import daos.CustomerDAO;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import daos.UserDAO;
import dtos.UserDTO;
import dtos.CustomerDTO;

public class CustomerInformation extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("information.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession(true);

        String name = request.getParameter("name");
        session.setAttribute("NAME", name);

        String phoneNumber_raw = request.getParameter("phone_number");
        int phoneNumber = Integer.parseInt(phoneNumber_raw);

        String age_raw = request.getParameter("age");
        int age = Integer.parseInt(age_raw);

        try {
            UserDTO user = (UserDTO) session.getAttribute("USER");
            CustomerDTO customer = new CustomerDTO(user.getUsername(), name, phoneNumber, age);

            UserDAO userDAO = new UserDAO();
            userDAO.addUser(user);

            CustomerDAO customerDAO = new CustomerDAO();
            customerDAO.addCustomer(customer);
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            response.sendRedirect("home");
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
