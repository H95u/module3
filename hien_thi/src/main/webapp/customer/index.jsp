<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Hello</title>
    <link rel="stylesheet" href="css.css">
</head>
<body>
<h1 style="text-align: center">Danh sách khách hàng</h1>
<table border="1" style="margin: auto;width: 500px">
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Phone</th>
        <th>Email</th>
        <th>Action</th>
    </tr>
    <c:forEach var="customer" items="${listCustomer}">
        <tr>
            <td>${customer.getId()}</td>
            <td>${customer.getName()}</td>
            <td>${customer.getPhone()}</td>
            <td>${customer.getEmail()}</td>
            <td>
                <button><a href="edit?id=${customer.getId()}">Edit</a></button>
                <button><a href="delete?id=${customer.getId()}">Delete</a></button>
            </td>
        </tr>
    </c:forEach>
</table>
<button style="margin-left: 600px"><a href="/new">add</a></button>
</body>
</html>