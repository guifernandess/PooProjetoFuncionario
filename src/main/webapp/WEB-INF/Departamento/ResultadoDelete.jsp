<%-- 
    Document   : ResultadoDelete
    Created on : 03/06/2018, 18:09:22
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
        <h1>Departamento <c:out value="${departamentoUpdate.nome}" /> atualizado com sucesso!</h1>
        <p>
            <a href= "${pageContext.request.contextPath}/DepartamentoHome" > Voltar </a>
    </body>
</html>
