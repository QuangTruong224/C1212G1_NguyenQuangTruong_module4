<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 5/5/2022
  Time: 2:49 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h3>${message}</h3>
<table border="1">
<c:forEach var="music" items="${musicList}">
    <tr>
        <td>Tên bài hát: ${music.tenBaiHat}</td>
    </tr>
    <tr>
        <td>Nghệ sĩ thể hiện : ${music.ngheSi}</td>
    </tr>
    <tr>
        <td>Thể loại nhạc: ${music.theLoaiNhac}</td>
    </tr>
    <tr>
        <td><a href="<c:out value="${music.file}"/>"></a></td>

    </tr>
</c:forEach>
</table>
</body>
</html>
