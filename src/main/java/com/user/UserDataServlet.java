package com.user;

import java.io.IOException;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/UserDataServlet")
public class UserDataServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String username = request.getParameter("username");
        String email = request.getParameter("email");
        String designation = request.getParameter("designation");

        // Server-side validation
        if (username == null || username.isEmpty() ||
            email == null || email.isEmpty() ||
            designation == null || designation.isEmpty()) {

            request.setAttribute("error", "All fields are required");
            RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
            rd.forward(request, response);
            return;
        }

        if (!email.matches("^[^ ]+@[^ ]+\\.[a-z]{2,3}$")) {
            request.setAttribute("error", "Invalid Email Format");
            RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
            rd.forward(request, response);
            return;
        }

        // Pass data to JSP
        request.setAttribute("username", username);
        request.setAttribute("email", email);
        request.setAttribute("designation", designation);

        RequestDispatcher rd = request.getRequestDispatcher("result.jsp");
        rd.forward(request, response);
    }
}