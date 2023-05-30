<%--
  Created by IntelliJ IDEA.
  User: Hieu's PC
  Date: 5/29/2023
  Time: 4:56 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form method="post">
    <p>ID</p>
    <input type="text" name="id">
    <p>name</p>
    <input type="text" name="name">
    <p>price</p>
    <input type="text" name="price">
    <p>expire time</p>
    <input type="datetime-local" name="time">
    <p>category</p>
    <select name="categoryId">
        <c:forEach var="c" items="${category}">
            <option value="${c.id}">${c.name}</option>
        </c:forEach>
    </select><br>
    <button type="submit">Submit</button>
    <button><a href="/products">Back to home</a></button>
</form>
</body>
</html>
