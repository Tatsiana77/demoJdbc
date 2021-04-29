<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8" />
    <title>Book info</title>
</head>
<body>
<ul>
    <c:forEach var="book" items="${book}">
        <li><c:out value="${book}" /></li>
    </c:forEach>
</ul>
</body>
</html>
</body>
</html>