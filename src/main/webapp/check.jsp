<%
    String name = (String) session.getAttribute("username");
%>

<html>
<body>

<h2>Session Check</h2>

<%
    if (name != null) {
%>
        <p><b>Hello <%= name %>!</b></p>
        <p>Session is still active.</p>
<%
    } else {
%>
        <p style="color:red;"><b>Session Expired!</b></p>
        <a href="index.jsp">Enter details again</a>
<%
    }
%>

</body>
</html>