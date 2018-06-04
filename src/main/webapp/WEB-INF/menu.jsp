<%-- 
    Document   : menu
    Created on : 19/05/2018, 21:29:45
    Author     : victor.galvao
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    </head>
    <body>
        <nav class="navbar navbar-inverse">
            <div class="container-fluid">
                <div class="navbar-header">
                    <a class="navbar-brand" href="#"><font color = "green">  PagamentoCenter</font></a>
                </div>
                <ul class="nav navbar-nav">
                    <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">Departamento<span class="caret"></span></a>
                        <ul class="dropdown-menu">
                            <li><a href="${pageContext.request.contextPath}/cadastro-departamento"> Cadastrar Departamento </a></li>
                            <li><a href="${pageContext.request.contextPath}/DepartamentoListar"> Listar Departamento </a></li>
                        </ul>
                    </li>
                    <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">Funcionario CLT<span class="caret"></span></a>
                        <ul class="dropdown-menu">
                            <li><a href="${pageContext.request.contextPath}/cadastro-funcionario-clt"> Cadastrar Funcionarios </a></li>
                            <li><a href="${pageContext.request.contextPath}/FuncionarioCltListar"> Listar Funcionarios </a></li>
                        </ul>
                    </li>
                    <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">Funcionario Diarista<span class="caret"></span></a>
                        <ul class="dropdown-menu">
                            <li><a href="${pageContext.request.contextPath}/cadastro-funcionario-diarista"> Cadastrar Funcionarios </a></li>
                            <li><a href="${pageContext.request.contextPath}/FuncionarioDiaristaListar"> Listar Funcionarios </a></li>
                        </ul>
                    </li>
                    <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">Funcionario PJ<span class="caret"></span></a>
                        <ul class="dropdown-menu">
                            <li><a href="${pageContext.request.contextPath}/cadastro-funcionario-pj"> Cadastrar Funcionarios </a></li>
                            <li><a href="${pageContext.request.contextPath}/FuncionarioPJListar"> Listar Funcionarios </a></li>
                        </ul>
                    </li>
                    <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">Pagamentos<span class="caret"></span></a>
                        <ul class="dropdown-menu">
                            <li><a href="${pageContext.request.contextPath}/cadastro-pagamento"> Cadastrar Pagamento </a></li>
                            <li><a href="${pageContext.request.contextPath}/PagamentoListar"> Listar Pagamento </a></li>
                        </ul>
                    </li>
                   
                </ul>
                <ul class="nav navbar-nav navbar-right">
                    <li><a href="${pageContext.request.contextPath}/Sair"><span class="glyphicon glyphicon-log-out"></span> Logoff </a></li>
                </ul>
            </div>
        </nav>                 
    </body>
</html>
