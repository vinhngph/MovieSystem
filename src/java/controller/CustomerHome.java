package controller;

import daos.CinemaDAO;
import daos.MovieDAO;
import daos.ScheduleDAO;
import dtos.CinemaDTO;
import dtos.ListMoviesDTO;
import dtos.ListSchedulesDTO;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.List;

public class CustomerHome extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        MovieDAO movieDAO = new MovieDAO();
        List<ListMoviesDTO> movies = movieDAO.getAll();
        if (movies != null) {
            request.setAttribute("MOVIES", movies);
        }

        request.getRequestDispatcher("home.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();

        String movie_raw = request.getParameter("movie_id");
        if (movie_raw != null) {
            int movie_id = Integer.parseInt(movie_raw);
            session.setAttribute("movie_id", movie_id);

            try {
                CinemaDAO cinemaDAO = new CinemaDAO();
                List<CinemaDTO> cinemas = cinemaDAO.getCinemasByMovieId(movie_id);

                if (cinemas != null) {
                    request.setAttribute("CINEMAS", cinemas);
                }
            } catch (Exception e) {
            } finally {
                request.getRequestDispatcher("home.jsp").forward(request, response);
            }
        }

        String cine_raw = request.getParameter("cinema_id");
        if (cine_raw != null) {
            int movie_id = (int) session.getAttribute("movie_id");
            int cinema_id = Integer.parseInt(cine_raw);
            session.setAttribute("cinema_id", cinema_id);

            try {
                ScheduleDAO scheduleDAO = new ScheduleDAO();
                List<ListSchedulesDTO> schedules = scheduleDAO.getSchedules(movie_id, cinema_id);

                if (schedules != null) {
                    request.setAttribute("SCHEDULES", schedules);
                }
            } catch (Exception e) {
            } finally {
                request.getRequestDispatcher("home.jsp").forward(request, response);
            }
        }

        String schedule_raw = request.getParameter("schedule_id");
        if (schedule_raw != null) {
            session.removeAttribute("cinema_id");
            session.removeAttribute("movie_id");

            int schedule_id = Integer.parseInt(schedule_raw);
            session.setAttribute("schedule_id", schedule_id);
            response.sendRedirect("billing");
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
