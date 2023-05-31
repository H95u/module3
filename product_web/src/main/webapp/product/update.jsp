<%--
  Created by IntelliJ IDEA.
  User: Hieu's PC
  Date: 5/31/2023
  Time: 7:20 PM
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
    <p>Quantity</p>
    <input type="text" name="quantity" value="${product.quantity}">
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
