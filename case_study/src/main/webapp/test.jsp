<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.Base64" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>${account.id}</h1>
<img width="100" height="100" src="data:image/jpeg;base64,${Base64.getEncoder().encodeToString(account.image)}" />
</body>
</html>
