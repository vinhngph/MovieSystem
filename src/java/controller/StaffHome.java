/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import daos.ActorDAO;
import daos.MovieDAO;
import dtos.ActorDTO;
import dtos.ListMoviesDTO;

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
        List<ListMoviesDTO> movies = movieDAO.getAll();
        if (movies != null) {
            request.setAttribute("MOVIES", movies);
        }

        ActorDAO actorDAO = new ActorDAO();
        List<ActorDTO> actors = actorDAO.getAll();
        if (actors != null) {
            request.setAttribute("ACTORS", actors);
        }
        request.getRequestDispatcher("home.jsp").forward(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
