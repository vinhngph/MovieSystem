package controller;

import daos.StaffDAO;
import dtos.StaffDTO;
import java.io.IOException;
import jakarta.servlet.ServletException;
import java.util.List;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class AdminHome extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        StaffDAO dao = new StaffDAO();
        List<StaffDTO> list = dao.getAll();
        request.setAttribute("STAFFS", list);
        request.getRequestDispatcher("home.jsp").forward(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
