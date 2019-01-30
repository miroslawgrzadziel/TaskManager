<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

<title>Home Page</title>
<div class="p-3 mb-2 bg-white text-dark">
    <c:if test="${user != null}">
        <p class="text-right">Zalogowany użytkownik: ${user.getFirstName()}.
        <a class="btn btn-outline-success float-left" href="http://localhost:8080/user/logout">Wyloguj się</a></p>
        <p></p>
        <%--<a class="btn btn-info" href="http://localhost:8080/meow/add">Add New Meow</a>--%>
        <%--<a class="btn btn-info" href="http://localhost:8080/meow/list">Meows List</a>--%>
        <%--<a class="btn btn-info" href="http://localhost:8080/user/list">Users List</a>--%>
        <%--<a class="btn btn-info" href="http://localhost:8080/user/box">Your Meow-box</a>--%>
        <%--<a class="btn btn-info" href="http://localhost:8080/user/account">Your profile</a>--%>
    </c:if>

    <c:if test="${user == null}">
        <a class="btn btn-outline-success float-left" href="http://localhost:8080/user/login">Zaloguj się</a>
        <a class="btn btn-outline-primary float-left" href="http://localhost:8080/user/registration">Zarejestruj się</a>
        <p></p>
    </c:if>
</div>
</head>