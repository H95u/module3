<%--
  Created by IntelliJ IDEA.
  User: Hieu's PC
  Date: 5/31/2023
  Time: 9:20 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1 style="text-align: center">Cart Home</h1>
<table border="1" style="width: 500px;margin-left: 500px">
    <tr>
        <td>ID</td>
        <td>Product name</td>
        <td>Price</td>
        <td>Quantity</td>
        <td>Action</td>
    </tr>
    <c:forEach var="c" items="${cart}">
        <tr>
            <td>${c.id}</td>
            <td>${c.product.name}</td>
            <td>${c.product.price}</td>
            <td>${c.quantity}
                <button style="float: right" onclick="changeQuantity(${c.quantity},${c.id})">Change quantity</button>
            </td>
            <td>
                <button><a
                        href="/cart?action=delete&id=${c.id}&quantity=${c.quantity}&productId=${c.product.id}">Cancel</a>
                </button>
            </td>
        </tr>
    </c:forEach>
    <tr>
        <td colspan="5">Total price : ${total}</td>
    </tr>
</table>
<a href="/products">Back to home</a>
</body>
<script>
    function changeQuantity(quantity, id) {
        let newQuantity = prompt("Enter quantity !!");
        if (newQuantity <= 0) {
            alert("Invalid quantity !!")
        } else {
            let editQuantity = newQuantity - quantity;
            window.location.href = "/cart?action=updateQuantity&quantity=" + editQuantity + "&id=" + id;
        }
    }
</script>
</html>
