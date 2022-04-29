<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 4/29/2022
  Time: 3:16 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body style="table-border-color-light: aquamarine" >
<form action="/convert" method="post">
    <div>
        Usd :
        <input type="text" name="usd">
    </div>
    <div>
        Rate :
        <input type="text" name="rate">
    </div>
    <div>
        <input type="submit" value="convert">
    </div>

</form>
</body>
</html>
