<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Mail Result</title>
</head>
<body>
<c:if test="${not empty success}">
    <h1 style="color: green;">${success}</h1>
</c:if>
<c:if test="${not empty error}">
    <h1 style="color: red;">${error}</h1>
</c:if>
<a href="sendMailForm.jsp">Send another email</a>
</body>
</html>
