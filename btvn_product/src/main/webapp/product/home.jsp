<%--
  Created by IntelliJ IDEA.
  User: Hieu's PC
  Date: 5/29/2023
  Time: 4:17 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1 style="text-align: center">Product home</h1>
<form action="/products?action=search" method="post">
    <input type="text" name="search">
    <button type="submit">Search</button>
</form>
<table border="1" style="margin: auto;width: 700px">
    <tr>
        <td>ID</td>
        <td>Name</td>
        <td>Price</td>
        <td>Expire Time</td>
        <td>Category</td>
        <td colspan="2">Action</td>
    </tr>
    <c:forEach var="p" items="${products}">
        <tr>
            <td>${p.id}</td>
            <td>${p.name}</td>
            <td>${p.price}</td>
            <td>${p.expireTime}</td>
            <td>${p.category.name}</td>
            <td>
                <button><a href="/products?action=update&id=${p.id}">Update</a></button>
            </td>
            <td>
                <button onclick=deleteP(${p.id})>Delete</button>
            </td>
        </tr>
    </c:forEach>
</table>
<button style="margin-left: 500px"><a href="/products?action=create">Add new product</a></button>
<button style="margin-left: 200px"><a href="/categories">Category home</a></button>
</body>
<script>
    function deleteP(id) {
        if (confirm("Xóa?")) {
            window.location.href = "/products?action=delete&id=" + id
        }
    }
</script>
</html>
