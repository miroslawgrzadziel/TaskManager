<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Tasks List</title>
    <%@include file="/WEB-INF/views/header.jsp" %>
<body class="p-3 mb-2 bg-white text-dark">

<%--<c:if test="${currentUser == null}">--%>
<%--<div class="p-3 mb-2 bg-white text-dark">--%>
<%--<h3 class="text-center">You have no access!</h3>--%>
<%--<p class="text-center">You must sign in</p>--%>
<%--</div>--%>
<%--</c:if>--%>

<%--<c:if test="${currentUser != null}">--%>
<%--<table class="table table-striped">--%>
<%--<tr>--%>
<%--<th>Name</th>--%>
<%--<th>Meows</th>--%>
<%--</tr>--%>
<%--<tr>--%>
<%--<td>${currentUser.username}</td>--%>
<%--<td><a class="btn btn-dark" href="http://localhost:8080/meow/list/${currentUser.id}">${currentUser.meows.size()}</a></td>--%>
<%--</tr>--%>
<%--</table>--%>
<%--<p></p>--%>
<table class="table table-striped">
    <tr>
        <th>Temat/Przedmiot zlecenia</th>
        <th>Data utworzenia</th>
        <th>Klient</th>
        <th>Wykonane działania</th>
    </tr>
    <c:forEach items="${tasks}" var="task">
        <tr>
            <td>${tasks.subject}</td>
            <td>${tasks.dateReceived}</td>
            <td>${tasks.cilent}</td>
            <%--<td><table class="table table-striped">--%>
        <%--<c:forEach items="${recipe.getComments()}" var="comment">--%>
        <%--<tr>--%>
            <%--<td>${comment.id}</td>--%>
            <%--<td>${comment.created}</td>--%>
            <%--<td>${comment.text}</td>--%>
            <%--<td>${comment.getUser().getLogin()}</td>--%>
        <%--</tr>--%>
        <%--</c:forEach>--%>
            <%--</table></td>--%>

                <%--<td><a class="btn btn-dark" href="http://localhost:8080/meow/list/${user.id}">${user.meows.size()}</a></td>--%>
                <td><a class="btn btn-outline-secondary" href="http://localhost:8080/home">Edytuj</a></td>
        </tr>
    </c:forEach>
</table>
<a class="btn btn-outline-primary float-left" href="http://localhost:8080/home">Powrót</a>
<%--</c:if>--%>

</body>
<%@include file="/WEB-INF/views/footer.jsp" %>
</html>

<%--<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Tweet</title>
    <%@include file="/WEB-INF/views/header.jsp"%>>
    <style>
        input, select{
            display: block;
            margin:15px 0;
            width: 100%;
        }
    </style>
</head>
<body class="p-3 mb-2 bg-info">
<a href="http://localhost:8080/home">HOME</a><br>

Recipe id : ${recipe.getId()}
Date : ${recipe.dateTime}
Title: ${recipe.recipeName}
User nick : ${recipe.getUser().getLogin()}<br>
materials : ${recipe.materials}<br>
process : ${recipe.process}<br>

<table class="table table-stripped">
<tr>
    <th>id</th>
    <th>created</th>
    <th>text</th>
    <th>login</th>
</tr>
<c:forEach items="${recipe.getComments()}" var="comment">
    <tr>
    <td>${comment.id}</td>
    <td>${comment.created}</td>
    <td>${comment.text}</td>
    <td>${comment.getUser().getLogin()}</td>
    </tr>
</c:forEach>
</table>

<c:if test="${user != null}">

    <form:form method="post"
               action="/recipe/${recipe.getId()}/comment"
               modelAttribute="comment"
               cssClass="container col-6" >
        <form:hidden path="id"/>

        <form:input path="text" placeholder="text" cssClass="form-input"/>
        <form:errors path="text" cssClass="alert alert-danger" element="div"/>

        <form:hidden path="created"/>

        <form:hidden path="recipe" value="${recipe.getId()}"/>
        <form:hidden path="user" value="${user.getId()}"/>

        <input type="submit" class="btn btn-success">

    </form:form>

</c:if>
<%@include file="/WEB-INF/views/footer.jsp"%>--%>