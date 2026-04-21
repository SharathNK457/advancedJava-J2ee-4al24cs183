<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Welcome Page</title>
</head>
<body>

<%
    // Set session expiry time to 1 minute (60 seconds)
    session.setMaxInactiveInterval(60);

    String name = request.getParameter("username");

    if (name != null) {
        // Store name in session
        session.setAttribute("user", name);
    }

    String user = (String) session.getAttribute("user");
%>

<h2>
<%
    if (user != null) {
        out.println("Hello " + user + "!");
    } else {
        out.println("Session expired! Please enter your name again.");
    }
%>
</h2>

<br>
<a href="index.jsp">Go Back</a>

</body>
</html>