<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Users List</title>
    <%@include file="/WEB-INF/views/header.jsp"%>
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
            <th>Imię</th>
            <th>Nazwisko</th>
            <th>E-mail</th>
            <th>Stanowisko</th>
        </tr>
        <c:forEach items="${users}" var="user">
            <c:if test="${currentUser.email != user.email}">
                <tr>
                    <td>${user.firstName}</td>
                    <td>${user.lastName}</td>
                    <td>${user.email}</td>
                    <td>${user.position}</td>

                    <%--<td><a class="btn btn-dark" href="http://localhost:8080/meow/list/${user.id}">${user.meows.size()}</a></td>--%>
                    <%--<td><a class="btn btn-dark" href="http://localhost:8080/home">Send message</a></td>--%>
                </tr>
            </c:if>
        </c:forEach>
    </table>
<%--</c:if>--%>

</body>
<%@include file="/WEB-INF/views/footer.jsp"%>
</html>