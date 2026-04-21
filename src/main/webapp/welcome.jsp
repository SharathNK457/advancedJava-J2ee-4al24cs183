<%@ page import="java.util.*" %>
<%
    // Set session expiry to 1 minute (60 seconds)
    session.setMaxInactiveInterval(60);

    String name = request.getParameter("username");

    // Check if session already has name
    if (session.getAttribute("username") == null) {
        session.setAttribute("username", name);
    } else {
        name = (String) session.getAttribute("username");
    }

    // Get session times
    Date creationTime = new Date(session.getCreationTime());
    Date lastAccessTime = new Date(session.getLastAccessedTime());
%>

<html>
<body>

<h2>Session Information</h2>

<p><b>Hello <%= name %>!</b></p>

<p>Session ID: <%= session.getId() %></p>
<p>Session Creation Time: <%= creationTime %></p>
<p>Last Access Time: <%= lastAccessTime %></p>

<p><i>(Session expires in 1 minute)</i></p>

<a href="welcome.jsp">Refresh</a>

</body>
</html>