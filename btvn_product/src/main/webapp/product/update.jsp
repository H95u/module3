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
    <p>name</p>
    <input type="text" name="name" value="${product.name}">
    <p>price</p>
    <input type="text" name="price" value="${product.price}">
    <p>expire time</p>
    <input type="datetime-local" name="time" value="${product.expireTime}">
    <p>category</p>
    <select name="categoryId">
        <c:forEach var="c" items="${category}">
            <option value="${c.id}" ${c.id == product.category.id ? 'selected' : ''}>${c.name}</option>
        </c:forEach>
    </select><br>
    <button type="submit">Submit</button>
</form>
</body>
</html>
