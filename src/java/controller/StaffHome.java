/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import daos.ActorDAO;
import daos.CinemaDAO;
import daos.MovieDAO;
import daos.ScheduleDAO;
import dtos.ActorDTO;
import dtos.CinemaDTO;
import dtos.MovieDetailDTO;
import dtos.ListSchedulesDTO;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;

public class StaffHome extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        MovieDAO movieDAO = new MovieDAO();
        List<MovieDetailDTO> movies = movieDAO.getAll();
        if (movies != null) {
            request.setAttribute("MOVIES", movies);
        }

        ActorDAO actorDAO = new ActorDAO();
        List<ActorDTO> actors = actorDAO.getAll();
        if (actors != null) {
            request.setAttribute("ACTORS", actors);
        }

        CinemaDAO cinemaDAO = new CinemaDAO();
        List<CinemaDTO> cinemas = cinemaDAO.getAll();
        if (cinemas != null) {
            request.setAttribute("CINEMAS", cinemas);
        }

        ScheduleDAO scheduleDAO = new ScheduleDAO();
        List<ListSchedulesDTO> schedules = scheduleDAO.getAll();
        if (schedules != null) {
            request.setAttribute("SCHEDULES", schedules);
        }

        request.getRequestDispatcher("home.jsp").forward(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
