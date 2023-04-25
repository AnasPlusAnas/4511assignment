/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ict.servlet;

import ict.bean.Booking;
import ict.bean.User;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 *
 * @author a1397
 */
import ict.db.BookingDB;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpSession;

@WebServlet(name = "BookingController", urlPatterns = {"/BookingController"})

public class BookingController extends HttpServlet {

    private static final long serialVersionUID = 1L;

    private BookingDB bkDB;

    @Override
    public void init() {
        bkDB = new BookingDB();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        User bookUser = (User) session.getAttribute("userInfo");
        String bookingUser = bookUser.getUsername();

        String action = request.getParameter("action");
        if (action.equals("list")) {
            ArrayList<Booking> bookings = bkDB.getAllBookings(bookingUser);
            if (bookings != null) {
                request.setAttribute("bookingList", bookings);
                RequestDispatcher rd = getServletContext().getRequestDispatcher("/memberBookingList.jsp");
                rd.forward(request, response);
            }
            return;
        }

        String username = request.getParameter("yourname");
        String venue = request.getParameter("vname");
        String booking_date = request.getParameter("bkdate");
        String booking_time = request.getParameter("bkTime");
        int fee = Integer.parseInt(request.getParameter("fee"));
        String guest1 = request.getParameter("guest1");
        String guest2 = request.getParameter("guest2");
        String guest3 = request.getParameter("guest3");
        String guest4 = request.getParameter("guest4");
        String guest5 = request.getParameter("guest5");
        String guest6 = request.getParameter("guest6");
        String guest7 = request.getParameter("guest7");
        String guest8 = request.getParameter("guest8");
        String guest9 = request.getParameter("guest9");
        String guest10 = request.getParameter("guest10");

        String time1 = "null", time2 = "null", time3 = "null", time4 = "null";

        if (booking_time.equalsIgnoreCase("12:00AM - 6:00AM")) {
            time1 = booking_time;
        } else if (booking_time.equalsIgnoreCase("6:00AM - 12:00PM")) {
            time2 = booking_time;
        } else if (booking_time.equalsIgnoreCase("12:00PM - 18:00PM")) {
            time3 = booking_time;
        } else if (booking_time.equalsIgnoreCase("18:00PM - 24:00PM")) {
            time4 = booking_time;
        }

        // 將預訂添加到數據庫
        boolean success = bkDB.addBooking(venue, username, booking_date, time1, time2, time3, time4, fee, guest1, guest2, guest3, guest4, guest5, guest6, guest7, guest8, guest9, guest10);

        // 檢查預訂是否成功
        if (success) {
            // 重定向到 successful.jsp
            response.sendRedirect("successfullBooking.jsp");
        } else {
            // 转发给JSP页面
            request.getRequestDispatcher("failureBk.jsp").forward(request, response);
        }
    }
}
