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
<c:forEach var="mail" items="${mailList}">
    <tr>
        <td>Language: ${mail.language}</td>
    </tr>
    <tr>
        <td>Page Size: ${mail.pageSize}</td>
    </tr>
    <tr>
        <td>Spam: ${mail.spamFillter}</td>
    </tr>
    <tr>
        <td>Signature: ${mail.signatuure}</td>
    </tr>
</c:forEach>
</table>
</body>
</html>
