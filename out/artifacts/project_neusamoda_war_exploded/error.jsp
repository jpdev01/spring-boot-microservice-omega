<%@ page import="java.io.StringWriter" %>
<%@ page import="java.io.PrintWriter" %><%--
  Created by IntelliJ IDEA.
  User: jptru
  Date: 23/01/2021
  Time: 11:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isErrorPage="true" %>
<html>
<head>
    <title>Erro encontrado</title>
</head>
<body>
<h3>Erro interno da aplicação!</h3>
<h4>Mensagem: <%= exception.getMessage()%></h4>
<%
    //exception.printStackTrace(); imprime no console
    StringWriter sw = new StringWriter();
    exception.printStackTrace(new PrintWriter(sw)); // escrita para o sw, que é uma string
%>
<h4>Stack trace: <%= sw.toString() %></h4>
<!-- isErrorPage=true disponibiliza um objeto implicito java que diz qual é a exception lançada! -->
</body>
</html>
