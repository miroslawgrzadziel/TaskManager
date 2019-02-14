<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Task Operation</title>
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS" crossorigin="anonymous">
    <style>
        input, select, a, textarea {
            display: block;
            margin: 15px 0;
            width: 100%;
        }
    </style>
</head>
<body>
<form:form method="post" action="${pageContext.request.contextPath}/taskoperations/add/${taskId}"
           modelAttribute="taskOperations" cssClass="container col-6">
    <%--<form:errors path="*"/>--%>

    <form:hidden path="id"/>
    <form:hidden path="user.id" value="${user.id}"/>
    <form:hidden path="task.id" value="${taskId}"/>

    <form:textarea path="description" placeholder="opis działania" cssClass="form-input"/>
    <form:errors path="description" cssClass="alert alert-danger" element="div"/>

    <form:input path="time" placeholder="czas pracy [min]" cssClass="form-input"/>
    <form:errors path="time" cssClass="alert alert-danger" element="div"/>

    <input type="submit" class="btn btn-outline-success"/>
    <a class="btn btn-outline-primary float-left" href="http://localhost:8080/home">Powrót</a>
</form:form>

</body>
<%@include file="/WEB-INF/views/footer.jsp" %>
</html>