package com.prime;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/prime")
public class PrimeServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        try {
            int number = Integer.parseInt(request.getParameter("number"));

            boolean isPrime = true;
            String steps = "Checking steps:<br>";

            if (number <= 1) {
                isPrime = false;
                steps += number + " is not prime (numbers ≤ 1 are not prime)";
            } else {
                for (int i = 2; i <= number / 2; i++) {
                    if (number % i == 0) {
                        isPrime = false;
                        steps += number + " is divisible by " + i + "<br>";
                        break;
                    } else {
                        steps += number + " is not divisible by " + i + "<br>";
                    }
                }
            }

            // Output
            out.println("<html><body>");
            out.println("<div style='margin:20px;'>");
            out.println("<h2>Prime Number Result</h2>");

            out.println("<p>Number: " + number + "</p>");

            if (isPrime) {
                out.println("<p><b>" + number + " is a Prime Number</b></p>");
            } else {
                out.println("<p><b>" + number + " is NOT a Prime Number</b></p>");
            }

            out.println("<p>" + steps + "</p>");
            out.println("<a href='index.html'>Check Another</a>");
            out.println("</div>");
            out.println("</body></html>");

        } catch (NumberFormatException e) {
            out.println("<h3>Invalid input! Please enter a valid number.</h3>");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.sendRedirect("index.html");
    }
}