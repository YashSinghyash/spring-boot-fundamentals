<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="webjars/bootstrap/5.3.3/css/bootstrap.min.css" rel="stylesheet">
    <title>Login Page</title>
</head>
<body>
    <div class="container">
        <h1>Login</h1>
        <pre>${errorMessage}</pre>
        <form method="POST">
            Name: <input type="text" name="name" />
            Password: <input type="password" name="password"/>
            <input type="submit">
        </form>
    </div>
    <script src="webjars/bootstrap/5.3.3/js/bootstrap.min.js"></script>
</body>
</html>
