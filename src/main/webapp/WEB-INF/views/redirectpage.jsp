<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
<%
    String sessionUrl = (String) request.getAttribute("sessionUrl");
    response.sendRedirect(sessionUrl);
%>

</head>
</html>
