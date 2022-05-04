<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 5/4/2022
  Time: 4:02 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Sandwich Condiments</h1>
<form action="/save" method="get">
    <input type="checkbox" name="condiment" value="Lettuce">
    Lettuce
    <input type="checkbox" name="condiment" value="Tomato">
    Tomato
    <input type="checkbox" name="condiment" value="Mustard">
    Mustard
    <input type="checkbox" name="condiment" value="Sprouts">
    Sprouts
    <br>
    <input type="submit" id="submit" value="Save"/>
    <h2>Result:</h2>
    <c:forEach var="giaVi" items="${tenGiaVi}">
        <h4>${giaVi}</h4>
    </c:forEach>
</form>

</body>
</html>
