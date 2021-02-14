
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Editar contato</title>
</head>
<body>
<form action="agenda-save" method="post">
    <c:if test="${contato.id != null}">
        <input type="hidden" name="id" value="${contato.id}">
    </c:if>
    <table>
        <tr>
            <td>Nome:</td>
            <td><input type="text" name="name" value="${contato.name}"></td>
        </tr>
        <tr>
            <td>Telefone:</td>
            <td><input type="text" name="telephone" value="${contato.telephone}"></td>
        </tr>
        <tr>
            <td colspan="2" align="right">
                <input type="submit" value="Salvar">
            </td>
        </tr>
    </table>
</form>
</body>
</html>
