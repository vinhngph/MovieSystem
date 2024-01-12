package controller;

import daos.ActorDAO;
import daos.MovieActorDAO;
import daos.MovieDAO;
import dtos.ActorDTO;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

public class AddMovie extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ActorDAO actorDAO = new ActorDAO();
        List<ActorDTO> actors = actorDAO.getAll();
        request.setAttribute("ACTORS", actors);
        request.getRequestDispatcher("addMovie.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String title = request.getParameter("title");
        String director = request.getParameter("director");
        String category = request.getParameter("category");
        int ageRequire = Integer.parseInt(request.getParameter("ageRequire"));

        String[] actorIds = request.getParameterValues("actors");

        List<Integer> actorIdList = new ArrayList<>();
        for (String actorId : actorIds) {
            actorIdList.add(Integer.valueOf(actorId));
        }

        MovieDAO movieDAO = new MovieDAO();
        int movieId = movieDAO.addMovie(title, director, category, ageRequire);

        MovieActorDAO movieActorDAO = new MovieActorDAO();
        movieActorDAO.addActorsToMovie(movieId, actorIdList);

        response.sendRedirect("home");
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
