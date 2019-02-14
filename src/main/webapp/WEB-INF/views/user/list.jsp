<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Users List</title>
    <%@include file="/WEB-INF/views/header.jsp" %>
<body class="p-3 mb-2 bg-white text-dark">

<table class="table table-striped">
    <tr>
        <th>Imię</th>
        <th>Nazwisko</th>
        <th>E-mail</th>
        <th>Stanowisko</th>
    </tr>
    <c:if test="${user.adminChck == true}">
        <c:forEach items="${users}" var="user">
            <tr>
                <td>${user.firstName}</td>
                <td>${user.lastName}</td>
                <td>${user.email}</td>
                <td>${user.position}</td>
                <td><a class="btn btn-outline-danger float-left" href="http://localhost:8080/user/delete/${user.id}">Usuń</a>
                </td>

            </tr>
        </c:forEach>
    </c:if>
    <c:if test="${user.adminChck != true}">
        <c:forEach items="${users}" var="user">
            <tr>
                <td>${user.firstName}</td>
                <td>${user.lastName}</td>
                <td>${user.email}</td>
                <td>${user.position}</td>
            </tr>
        </c:forEach>
    </c:if>
</table>
<a class="btn btn-outline-primary float-left" href="http://localhost:8080/home">Powrót</a>

</body>
<%@include file="/WEB-INF/views/footer.jsp" %>
</html>