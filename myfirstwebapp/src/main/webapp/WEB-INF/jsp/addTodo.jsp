<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


<html>
<head>
    <link href="webjars/bootstrap/5.3.3/css/bootstrap.min.css" rel="stylesheet">
    <title>Add a new TODO</title>
</head>
<body>
<div class="container">
    <h1>Enter todo Details </h1>
        <form:form method="post" modelAttribute="todoObject">
        Description: <form:input type="text" path="description" name = "description" required = "required"/>
        <form:errors path="description" cssClass="text-warning"/>
        <form:input type="hidden" path="id"/>
        <form:input type="hidden" path="done"/>
        <input type="submit" class="btn btn-success" />
    </form:form>
</div>
<script src="webjars/bootstrap/5.3.3/js/bootstrap.min.js"></script>
</body>
</html>
