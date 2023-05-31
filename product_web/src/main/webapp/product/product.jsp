<%--
  Created by IntelliJ IDEA.
  User: Hieu's PC
  Date: 5/31/2023
  Time: 1:42 PM
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
<button style="float: right"><a href="/cart">Cart</a></button>
<table border="1" style="margin: auto;width: 600px">
    <tr>
        <td>ID</td>
        <td>Name</td>
        <td>Price</td>
        <td>Quantity</td>
        <td>Category</td>
        <td colspan="2" style="text-align: center">Action</td>
    </tr>
    <c:forEach var="p" items="${products}">
        <tr>
            <td>${p.id}</td>
            <td>${p.name}</td>
            <td>${p.price}</td>
            <td>${p.quantity}</td>
            <td>${p.category.name}</td>
            <td>
                <button><a href="/products?action=update&id=${p.id}">Update</a></button>
                <button onclick=deleteP(${p.id})>Delete</button>
                <button onclick="addToCart(${p.id},${p.quantity})">Add to cart</button>
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

    function addToCart(id, productQuantity) {
        let quantity = prompt("Enter quantity !!");
        if (quantity > productQuantity) {
            alert("out of stock !!")
        } else if (quantity <= 0) {
            alert("quantity not valid !!")
        } else {
            alert("add success !!");
            window.location.href = "/cart?action=add&id=" + id + "&quantity=" + quantity;
        }
    }
</script>
</html>
