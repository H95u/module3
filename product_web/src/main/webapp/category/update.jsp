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
    <p>Name</p>
    <input type="text" name="name" value="${category.name}">
    <br>
    <button><a type="submit">Update</a></button>
    <button><a href="/categories">Back to home</a></button>
</form>
</body>
</html>
