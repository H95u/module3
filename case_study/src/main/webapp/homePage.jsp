<%--
  Created by IntelliJ IDEA.
  User: Hieu's PC
  Date: 6/2/2023
  Time: 9:07 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Lover web</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Poppins">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-geWF76RCwLtnZ8qwWowPQNguL3RmwHVBC9FhGdlKrxdiJJigb/j/68SIy3Te4Bkz"
            crossorigin="anonymous"></script>
    <style>
        body, h1, h2, h3, h4, h5 {
            font-family: "Poppins", sans-serif
        }

        body {
            font-size: 16px;
        }

    </style>
</head>
<body>

<!-- Sidebar/menu -->
<nav class="w3-sidebar w3-red w3-collapse w3-top w3-large w3-padding" style="z-index:3;width:300px;font-weight:bold;"
     id="mySidebar"><br>

    <div class="w3-container">
        <h3 class="w3-padding-64"><b>Home</b></h3>
    </div>
    <div class="w3-bar-block">
        <a href="#" class="w3-bar-item w3-button w3-hover-white">Trang chủ</a>
        <a href="#showcase" class="w3-bar-item w3-button w3-hover-white">Danh mục</a>
        <a href="#services" class="w3-bar-item w3-button w3-hover-white">Services</a>
        <a href="#designers" class="w3-bar-item w3-button w3-hover-white">Designers</a>
        <a href="#packages" class="w3-bar-item w3-button w3-hover-white">Packages</a>
        <a href="#contact" class="w3-bar-item w3-button w3-hover-white">Contact</a>
    </div>
</nav>

<div class="body-content" style="margin-left: 300px">

    <div class="row">
        <c:forEach var="a" items="${accountList}">
            <div class="col-lg-3">
                <img width="100" height="100"
                     src="data:image/jpeg;base64,${Base64.getEncoder().encodeToString(a.image)}"/>
            </div>
        </c:forEach>
    </div>

</div>
<!-- Footer-->
<div class="w3-light-grey w3-container w3-padding-32" style="margin-top:75px;padding-right:58px"><p class="w3-right">
    WEB THUÊ NGƯỜI YÊU</p></div>
</body>
</html>
