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
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
      integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
        crossorigin="anonymous"></script>
<style>
    a {
        text-decoration: none;
        color: white;
    }

</style>
<body>
<h1 style="text-align: center">Product home</h1>
<a class="btn btn-primary" href="/cart" style="float: right">Cart</a>
<div class="container">
    <table class="table table-bordered border-primary" style="margin: auto;width: 700px">
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
                    <button class="btn btn-success"><a href="/products?action=update&id=${p.id}">Update</a></button>
                    <button class="btn btn-danger" onclick=deleteP(${p.id})>Delete</button>
                    <button class="btn btn-info" onclick="addToCart(${p.id},${p.quantity})">Add to cart</button>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
<div class="row">
    <div class="col-lg-6">
        <a style="float: right" class="btn btn-success" href="/products?action=create">Add new product</a>
    </div>
    <div class="col-lg-6">
        <a class="btn btn-success" href="/categories">Category home</a>
    </div>
</div>
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
