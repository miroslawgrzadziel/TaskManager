<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Tasks</title>
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS" crossorigin="anonymous">
    <style>
        input, select, a {
            display: block;
            margin: 15px 0;
            width: 100%;
        }
    </style>
</head>
<body>
<form:form method="post" action="${pageContext.request.contextPath}/task/add" modelAttribute="task"
           cssClass="container col-6">
    <%--<form:errors path="*"/>--%>

    <form:hidden path="id"/>
    <form:hidden path="dateReceived"/>

    <form:input path="subject" placeholder="temat/przedmiot zlecenia" cssClass="form-input"/>
    <form:errors path="subject" cssClass="alert alert-danger" element="div"/>

    <form:input path="cilent" placeholder="klient" cssClass="form-input"/>
    <form:errors path="cilent" cssClass="alert alert-danger" element="div"/>

    <input type="submit" class="btn btn-outline-success"/>
    <a class="btn btn-outline-primary float-left" href="http://localhost:8080/home">Powrót</a>
</form:form>

</body>
<%@include file="/WEB-INF/views/footer.jsp" %>
</html>