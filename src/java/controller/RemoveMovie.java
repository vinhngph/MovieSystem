package controller;

import daos.MovieDAO;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class RemoveMovie extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int movie_id = Integer.parseInt(request.getParameter("movie_id"));
        try {
            MovieDAO movieDAO = new MovieDAO();
            movieDAO.removeMovie(movie_id);
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
