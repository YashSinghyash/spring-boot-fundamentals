<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="webjars/bootstrap/5.3.3/css/bootstrap.min.css" rel="stylesheet">
    <title>Welcome Page</title>
</head>
<body>
    <div class="container">

        <h1>Welcome ${name}</h1>
        <a href="list-todos"> Manage </a> your todos
    </div>
    <form action="/logout" method="post">
        <input type="submit" value="Logout"/>
    </form>
    <script src="webjars/bootstrap/5.3.3/js/bootstrap.min.js"></script>
</body>
</html>
