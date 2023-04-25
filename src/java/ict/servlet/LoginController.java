/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ict.servlet;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import ict.bean.User;
import ict.db.UserDB;
import ict.db.DB;

/**
 *
 * @author
 */
@WebServlet(name = "LoginController", urlPatterns = {"/main"})
public class LoginController extends HttpServlet {

    private UserDB userDB;
    private DB db;

    @Override
    public void init() {
        userDB = new UserDB();
    }

    protected void doGet(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (!isAuthenticated(request)
                && !("authenticate".equals(action)) && !("register".equals(action))) {
            doLogin(request, response);
            return;
        }
        if ("authenticate".equals(action)) {
            doAuthenticate(request, response);
        } else if ("logout".equals(action)) {
            doLogout(request, response);
        } else if ("register".equals(action)) {
            doRegister(request, response);
        } else {
            response.sendError(HttpServletResponse.SC_NOT_IMPLEMENTED);
        }
    }

    private void doAuthenticate(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String targetURL;
        boolean isValid = userDB.isValidUser(username, password);
        if (isValid) {
            String userRole = userDB.getUserRole(username);
            HttpSession session = request.getSession(true);
            User bean = new User();
            bean.setUsername(username);
            bean.setPassword(password);

            session.setAttribute("userInfo", bean);
            switch (userRole) {
                case "staff":
                    targetURL = "/staff.jsp";
                    break;
                case "manager":
                    targetURL = "/seniorManagement.jsp";
                    break;
                default:
                    targetURL = "/welcome.jsp";
                    break;
            }
        } else {
            targetURL = "/loginError.jsp";
        }
        RequestDispatcher rd = getServletContext().getRequestDispatcher(targetURL);
        rd.forward(request, response);
    }

    private boolean isAuthenticated(HttpServletRequest request) {
        boolean result = false;
        HttpSession session = request.getSession();
        // get the user info from the session
        if (session.getAttribute("userInfo") != null) {
            result = true;
        }
        return result;
    }

    private void doLogin(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String targetURL = "login.jsp";
        RequestDispatcher rd = getServletContext().getRequestDispatcher("/" + targetURL);
        rd.forward(request, response);
    }

    private void doLogout(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        HttpSession session = request.getSession(false);
        if (session != null) {
            session.removeAttribute("userInfo");
            session.invalidate();
        }
        doLogin(request, response);
    }

    private void doRegister(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        String targetURL;
        boolean isSuccess = userDB.addRecord(username, password, email);
        if (isSuccess) {
            // If the account is created successfully, set a success message and redirect to register.jsp
            targetURL = "/login.jsp";
        } else {
            targetURL = "/register.jsp";
        }
        RequestDispatcher rd = getServletContext().getRequestDispatcher(targetURL);
        rd.forward(request, response);
    }
}
