package controller;

import daos.ActorDAO;
import dtos.MovieActor;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class RemoveActor extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession(true);

        int actor_id = Integer.parseInt(request.getParameter("actor_id"));
        ActorDAO actorDAO = new ActorDAO();
        MovieActor actor = actorDAO.getMovie(actor_id);
        if (actor == null) {
            actorDAO.removeActor(actor_id);
            response.sendRedirect("home");
        } else {
            session.setAttribute("InMovie", "This actor still in some movies");
            response.sendRedirect("home");
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
