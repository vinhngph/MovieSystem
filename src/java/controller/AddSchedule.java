package controller;

import daos.ActorDAO;
import daos.CinemaDAO;
import daos.MovieDAO;
import daos.ScheduleDAO;
import dtos.ActorDTO;
import dtos.CinemaDTO;
import dtos.MovieDetailDTO;
import dtos.ScheduleDTO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.Date;
import java.util.List;

public class AddSchedule extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        MovieDAO movieDAO = new MovieDAO();
        List<MovieDetailDTO> movies = movieDAO.getAll();
        if (movies != null) {
            request.setAttribute("MOVIES", movies);
        }
        
        CinemaDAO cinemaDAO = new CinemaDAO();
        List<CinemaDTO> cinemas = cinemaDAO.getAll();
        if (cinemas != null) {
            request.setAttribute("CINEMAS", cinemas);
        }
        
        request.getRequestDispatcher("addSchedule.jsp").forward(request, response);
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int movieId = Integer.parseInt(request.getParameter("movie_id"));
        int cinemaId = Integer.parseInt(request.getParameter("cinema_id"));
        Date date = Date.valueOf(request.getParameter("date"));
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        
        ScheduleDAO scheduleDAO = new ScheduleDAO();
        boolean checkAdd = scheduleDAO.addSchedule(movieId, cinemaId, date, quantity);
        if (checkAdd) {
            response.sendRedirect("home");
        }
    }
    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
