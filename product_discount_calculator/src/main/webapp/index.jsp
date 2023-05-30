<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <title>JSP - Hello World</title>
</head>
<body>
<form action="/display-discount" method="post">
<p> product description</p>
  <input type="text" name="description" placeholder="enter description">
<p> list price</p>
  <input type="text" name="inputPrice" placeholder="enter price">
<p> discount percent (percent)</p>
  <input type="text" name="discountPercent" placeholder="Enter discount percent"><br>
  <button type="submit">Submit</button><br>
  <c:forEach var = "i" begin = "1" end = "5"> Item
  <c:out value = "${i}"/><p>
  </c:forEach>
</form>
</body>
</html>