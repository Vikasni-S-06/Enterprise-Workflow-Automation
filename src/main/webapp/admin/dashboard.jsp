<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html>

<head>

    <title>Admin Dashboard</title>

</head>

<body>

<h1>Admin Dashboard</h1>

<h3>
    Welcome,
    <%= session.getAttribute("userName") %>
</h3>

<p>
    Role :
    <%= session.getAttribute("role") %>
</p>

<br>

<a href="<%=request.getContextPath()%>/logout">
    Logout
</a>

</body>

</html>