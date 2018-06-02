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
                    <a class="navbar-brand" href="#">WebSiteName</a>
                </div>
                <ul class="nav navbar-nav">
                    <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">Carros<span class="caret"></span></a>
                        <ul class="dropdown-menu">
                            <li><a href="${pageContext.request.contextPath}/cadastro-carro"> Cadastrar Carros </a></li>
                            <li><a href="${pageContext.request.contextPath}/ListarCarrosServlet"> Listar Carros </a></li>
                        </ul>
                    </li>
                    <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">Funcionarios<span class="caret"></span></a>
                        <ul class="dropdown-menu">
                            <li><a href="${pageContext.request.contextPath}/cadastro-funcionario"> Cadastrar Funcionarios </a></li>
                            <li><a href="${pageContext.request.contextPath}/ListarFuncionarioServlet"> Listar Funcionarios </a></li>
                        </ul>
                    </li>
                    <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">Clientes<span class="caret"></span></a>
                        <ul class="dropdown-menu">
                            <li><a href="${pageContext.request.contextPath}/cadastro-cliente"> Cadastrar Clientes </a></li>
                            <li><a href="${pageContext.request.contextPath}/ListarClientesServlet"> Listar Clientes </a></li>
                        </ul>
                    </li>
                    <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">Filiais<span class="caret"></span></a>
                        <ul class="dropdown-menu">
                            <li><a href="${pageContext.request.contextPath}/cadastro-filial"> Cadastrar Filiais </a></li>
                            <li><a href="${pageContext.request.contextPath}/ListarFiliaisServlet"> Listar Filiais </a></li>
                        </ul>
                    </li>
                    <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">Planos<span class="caret"></span></a>
                        <ul class="dropdown-menu">
                            <li><a href="${pageContext.request.contextPath}/cadastro-plano"> Cadastrar Planos </a></li>
                            <li><a href="${pageContext.request.contextPath}/ListarPlanosServlet"> Listar Planos </a></li>
                        </ul>
                    </li>
                </ul>
                <ul class="nav navbar-nav navbar-right">
                    <li><a href="${pageContext.request.contextPath}/Sair"><span class="glyphicon glyphicon-log-out"></span> Sair </a></li>
                </ul>
            </div>
        </nav>                 
    </body>
</html>
