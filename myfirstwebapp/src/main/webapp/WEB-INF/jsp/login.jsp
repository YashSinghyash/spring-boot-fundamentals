<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login Page</title>
</head>
<body>
    Welcome to the login page!
    <pre>${errorMessage}</pre>
<form method="POST">
    Name: <input type="text" name="name">
    Password: <input type="password" name="password">
    <input type="submit">
</form>
</body>
</html>
