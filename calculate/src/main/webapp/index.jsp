<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<form method="post" action="/calculate">
    <input name="firstNum" type="text">
    <select name="operator">
        <option value="+">add</option>
        <option value="-">sub</option>
        <option value="*">mul</option>
        <option value="/">div</option>
    </select>
    <input name="secondNum" type="text">
    <button type="submit">Submit</button>
</form>
</body>
</html>