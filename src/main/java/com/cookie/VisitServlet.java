package com.cookie;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/visit")
public class VisitServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String name = request.getParameter("username");
        int count = 1;

        Cookie[] cookies = request.getCookies();

        // Check existing cookies
        if (cookies != null) {
            for (Cookie c : cookies) {
                if (c.getName().equals("visitCount")) {
                    count = Integer.parseInt(c.getValue());
                    count++;
                }
                if (c.getName().equals("username")) {
                    name = c.getValue();
                }
            }
        }

        // Create cookies
        Cookie nameCookie = new Cookie("username", name);
        Cookie countCookie = new Cookie("visitCount", String.valueOf(count));

        // Set expiry (30 seconds for demo)
        nameCookie.setMaxAge(30);
        countCookie.setMaxAge(30);

        response.addCookie(nameCookie);
        response.addCookie(countCookie);

        // HTML Output
        out.println("<html><body>");
        out.println("<h2>Welcome back " + name + "!</h2>");
        out.println("<p>You have visited this page " + count + " times.</p>");
        out.println("<p><i>(Cookie expires in 30 seconds)</i></p>");

        // Display all cookies with values
        out.println("<h3>Cookie List (Name & Value):</h3>");

        Cookie[] updatedCookies = request.getCookies();

        if (updatedCookies != null) {
            for (Cookie c : updatedCookies) {
                out.println("<p>");
                out.println("Cookie Name: " + c.getName() + "<br>");
                out.println("Cookie Value: " + c.getValue() + "<br>");
                out.println("</p><hr>");
            }
        } else {
            out.println("<p>No cookies available</p>");
        }

        out.println("<a href='index.html'>Go Back</a>");
        out.println("</body></html>");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.sendRedirect("index.html");
    }
}