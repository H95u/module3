<%--
  Created by IntelliJ IDEA.
  User: Hieu's PC
  Date: 5/25/2023
  Time: 10:54 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create</title>
</head>
<body>
<form action="/create" method="get">
    <h2>Create customer</h2>
    <input type="text" placeholder="id" name="id"><br>
    <input type="text" placeholder="name" name="name"><br>
    <input type="text" placeholder="phone" name="phone"><br>
    <input type="text" placeholder="email" name="email"><br>
    <button type="submit">Submit</button>
</form>

</body>
</html>
