<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <%@include file="/WEB-INF/views/header.jsp" %>
    <body class="p-3 mb-2 bg-white text-dark">
<c:if test="${user != null}">
    <h3 class="text-center">Kontroluj swoje zadania.</h3>

</c:if>
<c:if test="${user == null}">
    <h1 class="text-center">Kontroluj swoje zadania.</h1>

</c:if>
</body>
<%@include file="/WEB-INF/views/footer.jsp" %>
</html>
