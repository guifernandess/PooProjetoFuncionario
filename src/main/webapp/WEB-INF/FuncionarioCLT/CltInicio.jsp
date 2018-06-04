<%-- 
    Document   : CltInicio
    Created on : 03/06/2018, 20:17:22
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
        <h1>Funcionarios CLT</h1>
        <ul>
            <li><h3><a href="${pageContext.request.contextPath}/cadastro-funcionarioclt"> Cadastro </a></h3></li>
            <li><h3><a href="${pageContext.request.contextPath}/FuncionarioCLTListar"> Listar Departamentos </a></h3></li>
        </ul>
    </body>
</html>
