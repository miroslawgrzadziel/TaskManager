<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS" crossorigin="anonymous">
    <style>
        input, select, a {
            display: block;
            margin:15px 0;
            width: 100%;
        }
    </style>
</head>
<body>
<form:form method="post" action="${pageContext.request.contextPath}/user/login" modelAttribute="user" cssClass="container col-6">


    <form:input path="email" placeholder="e-mail" cssClass="form-input"/>
    <form:errors path="email" cssClass="alert alert-danger" element="div"/>

    <form:password path="password" placeholder="podaj hasło" cssClass="form-input"/>
    <c:if test="${passwordError}">
        <div cssClass="alert alert-danger">Błędne hasło.</div>
    </c:if>

    <input type = "submit" class="btn btn-outline-success"/>
    <a class="btn btn-outline-primary float-left" href="http://localhost:8080/home">Powrót</a>
</form:form>

</body>
<%@include file="/WEB-INF/views/footer.jsp" %>
</html>