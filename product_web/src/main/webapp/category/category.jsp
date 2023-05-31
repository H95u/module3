<%--
  Created by IntelliJ IDEA.
  User: Hieu's PC
  Date: 5/31/2023
  Time: 2:15 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1 style="text-align: center">Category Home</h1>
<table border="1" style="width: 700px">
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th colspan="2">Action</th>
    </tr>
    <c:forEach var="c" items="${category}">
        <tr>
            <td>${c.id}</td>
            <td>${c.name}</td>
            <td>
                <button><a href="/categories?action=update&id=${c.id}">Update</a></button>
            </td>
            <td>
                <button onclick=deleteC(${c.id})>Delete</button>
            </td>
        </tr>
    </c:forEach>
</table>
<button><a href="/categories?action=create">ADD</a></button>
<button><a href="/products">Back to product Home</a></button>
</body>
<script>
    function deleteC(id) {
        if (confirm("Xóa?")) {
            window.location.href = "/categories?action=delete&id=" + id
        }
    }
</script>
</html>
