<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Training jsp</title>
</head>
<body>
<h1><%= "Bora!!!"%>
</h1>
<%
    boolean isAdm = false;
    HttpServletRequest req = request;
    session.setAttribute("permissao", "guest");
%>
<br/>
<a href="<% application.getInitParameter("ApplicationUrl");%>hello-servlet">Hello Servlet</a>
<br>
<a href="<% application.getInitParameter("ApplicationUrl");%>agenda-edit">Novo contato</a>
<br>
<a href="<% application.getInitParameter("ApplicationUrl");%>agenda-list">Lista de contatos</a>
<br>
<a href="<% application.getInitParameter("ApplicationUrl");%>exception-test">Testar página de erro</a>
<br>
<a href="<% application.getInitParameter("ApplicationUrl");%>sec/adm">Sou adm! Entrar</a>
<br>
<a href="filter-process">Iniciar processamento (filtro)</a>
<c:if test="${message != null}">
    <h4>Mensagem: ${message}</h4>
</c:if>

<h2>Usuários:</h2>
<a href="<%= application.getInitParameter("ApplicationUrl")%>user/edit">Criar novo</a>
</body>
</html>