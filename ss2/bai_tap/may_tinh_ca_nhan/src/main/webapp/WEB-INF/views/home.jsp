<%--
  Created by IntelliJ IDEA.
  User: MyPC
  Date: 01/03/2022
  Time: 4:28 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Calculator</title>
</head>
<body>
<h2>Calculator</h2>
<form action="/caculator" method="post">
<table>
    <tr>
        <td colspan="2">
            <input type="text" placeholder="Enter first number" name="first">
        </td>
        <td colspan="2">
            <input type="text" placeholder="Enter second number" name="second">
        </td>
    </tr>
    <tr>
        <input type="submit" value="Addition(+)" name="calculate">
    </tr>

    <tr>
        <input type="submit" value="Subtraction(-)" name="calculate">
    </tr>
    <tr>
        <input type="submit" value="Multiplication(x)" name="calculate">
    </tr>
    <tr>
            <input type="submit" value="Division(/)" name="calculate">
    </tr>
</table>
</form>
<h3>Result ${result}</h3>
</body>
</html>
