<%-- 
    Document   : DepartamentoInicio
    Created on : 02/06/2018, 12:12:36
    Author     : Guilherme
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Departamentos</h1>
         <ul>
            <li><h3><a href="${pageContext.request.contextPath}/cadastro-departamento"> Cadastro </a></h3></li>
            <li><h3><a href="${pageContext.request.contextPath}/DepartamentoListar"> Listar Departamentos </a></h3></li>
        </ul>
    </body>
</html>
