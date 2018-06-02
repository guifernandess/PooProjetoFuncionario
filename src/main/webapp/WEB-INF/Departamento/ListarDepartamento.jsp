<%-- 
    Document   : ListarDepartamento
    Created on : 02/06/2018, 12:44:20
    Author     : Guilherme
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Carros Disponiveis</title>
        <style>
            hr.style13 {
                height: 10px;
                border: 0;
                box-shadow: 0 10px 10px -10px #8c8b8b inset;
            }  
        </style>    
    </head>
    <body>
        <jsp:include page="menu.jsp"/>
        <h1>Departamentos</h1>
        <p>
        <hr class="style13">
        <div>


            <table class="table table-hover">
                <thead>
                    <tr>
                        <th>Departamento</th>
                    </tr>
                </thead>

                <tbody>
                    <c:forEach items="${lista}" var="p">    
                        <tr>
                            <td><a href='http://localhost:8080/agendaweb-1.0-SNAPSHOT/buscar-carro?idcarro="${p.idDepartamento}"'> <c:out value="${p.nome}" /> </a></td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>

            <p>
                <a href= "${pageContext.request.contextPath}/DepartamentoHome" > Voltar </a> 
        </div>
    </body>
</html>
