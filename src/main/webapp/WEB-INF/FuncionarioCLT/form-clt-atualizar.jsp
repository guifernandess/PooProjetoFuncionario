<%-- 
    Document   : form-clt-atualizar
    Created on : 04/06/2018, 16:17:26
    Author     : Guilherme
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Atualizar Funcionario</title>
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
        <div> 
            <h1>Atualize um Funcionario</h1>
        </div>
        <p>
        <hr class="style13">  
        <div>
            <form action="${pageContext.request.contextPath}/CLTAtualizar"
                  method="post">
                <div class="form-row" >
                    <div class="form-group col-md-8" >
                        <div class="form-row col-md-2">
                            <label for="inputEmail4">Id</label>
                            <input type="text" class="form-control" placeholder="Id" name="id" value= "${FuncionarioAtualizada.id}">
                        </div>
                        <div class="form-row col-md-2">
                            <label for="inputEmail4">Nome</label>
                            <input type="text" class="form-control" placeholder="Seu nome" name="nome" value= "${FuncionarioAtualizada.nome}">
                        </div>
                        <div class="form-row col-md-6">
                            <label for="inputPassword4">Sobrenome</label>
                            <input type="text" class="form-control" placeholder="Sobrenome" name="sobrenome" value= "${FuncionarioAtualizada.sobrenome}">
                        </div>
    </body>
</html>
