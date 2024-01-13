package controller;

import daos.CinemaDAO;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class RemoveCinema extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("cinema_id"));
        try {
            CinemaDAO cinemaDAO = new CinemaDAO();
            cinemaDAO.removeCinema(id);
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
