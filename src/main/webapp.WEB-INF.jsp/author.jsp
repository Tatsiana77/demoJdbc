<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8" />
    <title>Author Info</title>
</head>
<body>
<div align="left">
    <table border="1" cellpadding="5">
        <caption><h2>List of  Author</h2></caption>
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Surname</th>
            <th>Actions</th>
        </tr>
<ul>
    <c:forEach var="author" items="${author}">
        <li><c:out value="${author}" /></li>
    </c:forEach>

        <tr>
            <td><button>Book</button></td>
            <td><button><a href="authors/books?id=${author.id}"> Book </a></button></td>
            <td><button><a href="authors/edit?id=${author.id}"> Edit </a></button></td>
        </tr>
</div>
</body>
</html>
