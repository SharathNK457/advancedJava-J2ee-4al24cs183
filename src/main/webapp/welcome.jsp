<%@ page import="java.util.*" %>
<%
    String name = request.getParameter("username");
    String timeStr = request.getParameter("time");

    int time = Integer.parseInt(timeStr);

    // Set session expiry time
    session.setMaxInactiveInterval(time);

    // Store name in session
    session.setAttribute("username", name);
%>

<html>
<body>

<h2>Welcome Page</h2>

<p><b>Hello <%= name %>!</b></p>

<p>Session will expire in <%= time %> seconds.</p>

<a href="check.jsp">Click here to check session</a>

</body>
</html>