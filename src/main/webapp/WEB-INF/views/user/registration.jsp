<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registration</title>
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS" crossorigin="anonymous">
    <style>
        input, select{
            display: block;
            margin:15px 0;
            width: 100%;
        }
    </style>
</head>
<body>

<form:form method="post" action="${pageContext.request.contextPath}/user/registration" modelAttribute="user" cssClass="container col-6">
    <%--<form:errors path="*"/>--%>

    <form:hidden path="id"/>

    <form:input path="firstName" placeholder="imię" cssClass="form-input"/>
    <form:errors path="firstName" cssClass="alert alert-danger" element="div"/>

    <form:input path="lastName" placeholder="nazwisko" cssClass="form-input"/>
    <form:errors path="lastName" cssClass="alert alert-danger" element="div"/>

    <form:input path="email" placeholder="e-mail" cssClass="form-input"/>
    <form:errors path="email" cssClass="alert alert-danger" element="div"/>
    <c:if test="${userexists}">
        <div cssClass="alert alert-danger">Użytkownik o podanym e-mailu istnieje już w bazie danych.</div>
    </c:if>

    <form:input path="position" placeholder="stanowisko" cssClass="form-input"/>
    <form:errors path="position" cssClass="alert alert-danger" element="div"/>

    <form:input path="rate" placeholder="stawka godzinowa [PLN]" cssClass="form-input"/>
    <form:errors path="rate" cssClass="alert alert-danger" element="div"/>

    <form:password path="password" placeholder="podaj hasło" cssClass="form-input"/>
    <form:errors path="password" cssClass="alert alert-danger" element="div"/>

    <form:input type="password" path="passwordConfirm" cssClass="form-input" placeholder="potwierdź hasło"/>
    <form:errors path="passwordConfirm" cssClass="alert alert-danger" element="div"/>
    <c:if test="${passwordError}">
        <div cssClass="alert alert-danger">Błędne hasło.</div>
    </c:if>

    <input type = "submit" class="btn btn-outline-success"/>
</form:form>

</body>
<%@include file="/WEB-INF/views/footer.jsp" %>
</html>