<%-- 
    Document   : resultadoCadastro
    Created on : 04/06/2018, 16:00:35
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
        <h1>Funcionario <c:out value="${cltCadastrado.nome}" /> cadastrado com sucesso</h1>
        <p>
             <a href= "${pageContext.request.contextPath}/CLTHome" > Voltar </a>
    </body>
</html>
