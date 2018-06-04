<%-- 
    Document   : resultadoCadastro
    Created on : 03/06/2018, 18:09:07
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
    <jsp:include page="menu.jsp"/>
        <h1>Carro <c:out value="${departamentoCadastrado.nome}" /> cadastrado com sucesso</h1>
        <p>
             <a href= "${pageContext.request.contextPath}/DepartamentoHome" > Voltar </a>
    </body>
</html>
