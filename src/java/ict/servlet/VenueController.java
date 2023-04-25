package ict.servlet;

import ict.bean.Venue;
import ict.db.VenueDB;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "VenueController", urlPatterns = {"/VenueController"})
public class VenueController extends HttpServlet {

    private VenueDB vDB;

    @Override
    public void init() throws ServletException {
        vDB = new VenueDB();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        // get all record about venue for showing

        if (action != null && action.equals("list")) {
            ArrayList<Venue> venueList = vDB.getAllRecords();
            request.setAttribute("venueList", venueList);
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/venueList.jsp");
            rd.forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

}
