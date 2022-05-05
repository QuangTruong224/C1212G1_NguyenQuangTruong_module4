<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 5/5/2022
  Time: 1:45 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
<form:form action="/add" modelAttribute="music">
    <fieldset>
        <legend><h3>Add new music</h3></legend>
        <table>
            <tr>
                <td><form:input path="tenBaiHat"/>Tên bài hát</td>

            </tr>
            <tr>
                <td><form:input path="ngheSi"/>Nghệ sĩ thể hiện:</td>

            </tr>
            <tr>
                <td>
                    <form:select path="theLoaiNhac">
                        <form:option value="US-UK">US-UK</form:option>
                        <form:option value="Bolero">Bolero</form:option>
                        <form:option value="Balab">Balab</form:option>
                        <form:option value="NoMusic">Khơi lòng</form:option>

                    </form:select>
                </td>
            </tr>
            <tr>
                <td><form:input path="file"/>Đường dẫn</td>            </tr>
            <tr>
                <td><input type="submit" value="Update"></td>
                <td><input type="reset" value="Cancel"></td>
            </tr>
        </table>
    </fieldset>
</form:form>
</body>
</html>
