<%--
  Created by IntelliJ IDEA.
  User: jptru
  Date: 24/01/2021
  Time: 08:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Usuário</title>
</head>
<body>
<form method="post" action="<%=application.getInitParameter("ApplicationUrl")%>user/save">
    <c:if test="${user.id != null}">
        <input name="id" value="${user.id}" hidden>
    </c:if>
    <tr>
        <td>Login:</td>
        <input type="text" name="login" value="${user.login}">
    </tr>
    <tr>
        <td>Password:</td>
        <input type="password" name="password" value="${user.password}">
    </tr>
    <tr>
        <td>Permissão:</td>
        <select name="permissao">
            <option value="guest" selected>Visitante</option>
            <option value="adm" selected>Administrador</option>
        </select>
    </tr>
    <tr>
        <td colspan="2" align="right">
            <input type="submit" value="Salvar">
        </td>
    </tr>
</form>
</body>
</html>
