<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Tasks List</title>
    <%@include file="/WEB-INF/views/header.jsp" %>
<body class="p-3 mb-2 bg-white text-dark">

<table class="table table-striped">
    <tr>
        <th>Temat/Przedmiot zlecenia</th>
        <th>Data utworzenia</th>
        <th>Klient</th>
        <th>Wykonane działania</th>
    </tr>
    <c:forEach items="${tasks}" var="task">
        <tr>
            <td>${task.subject}</td>
            <td>${task.dateReceived}</td>
            <td>${task.cilent}</td>

        <td><table class="table table-striped">
            <c:if test="${not empty task.getTaskOperations()}">
                <tr>
                    <th>Opis działania</th>
                    <th>Czas pracy [min]</th>
                    <th>Osoba</th>
                </tr>
            </c:if>
        <c:forEach items="${task.getTaskOperations()}" var="taskOperation">
        <tr>
            <td>${taskOperation.description}</td>
            <td>${taskOperation.time}</td>
            <td>${taskOperation.user}</td>
            <c:if test="${user.id==taskOperation.user.id}">
            <td><a class="btn btn-outline-danger float-right" href="http://localhost:8080/taskoperations/delete/${taskOperation.id}">Usuń</a></td>
            </c:if>
        </tr>
        </c:forEach>
            </table></td>
            <td>
            <c:if test="${empty task.getTaskOperations()}">
            <a class="btn btn-outline-danger float-right" href="http://localhost:8080/task/delete/${task.id}">Usuń</a>
            </c:if>
                <a class="btn btn-outline-warning float-right" href="http://localhost:8080/task/edit/${task.id}">Edytuj</a>
                <a class="btn btn-outline-success float-right" href="http://localhost:8080/taskoperations/add/${task.id}">Dodaj</a>
            </td>
        </tr>
    </c:forEach>
</table>
<a class="btn btn-outline-primary float-left" href="http://localhost:8080/home">Powrót</a>
<%--</c:if>--%>

</body>
<%@include file="/WEB-INF/views/footer.jsp" %>
</html>