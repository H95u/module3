<%--
  Created by IntelliJ IDEA.
  User: Hieu's PC
  Date: 5/27/2023
  Time: 4:35 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form method="post">
    <table border="1" cellpadding="5">
        <caption><h2>Add new Users</h2></caption>
        <tr>
            <th>Name</th>
            <td><input name="name"></td>
        </tr>
        <tr>
            <th>Email</th>
            <td><input name="email"></td>
        </tr>
        <tr>
            <th>Country</th>
            <td><input name="country"></td>
        </tr>
        <tr>
            <th colspan="2">
                <button type="submit"> Create</button>
                <a href="/users">Back to home</a>
            </th>
        </tr>
    </table>
</form>
</body>
</html>
