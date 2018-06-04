<%-- 
    Document   : form-clt-cadastro
    Created on : 04/06/2018, 14:52:02
    Author     : Guilherme
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cadastrar Funcionario</title>
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
            <h1>Cadastre um Funcionario</h1>
        </div>
        <p>
        <hr class="style13">

        <div>
            <form action="${pageContext.request.contextPath}/cadastro-funcionario"
                  method="post">
                <div class="form-row" >
                    <div class="form-group col-md-8" >
                        <div class="form-row col-md-4">
                            <label for="inputEmail4">Nome</label>
                            <input type="text" class="form-control" placeholder="Seu nome" name="nome">
                        </div>
                        <div class="form-row col-md-4">
                            <label for="inputAddress">Cpf</label>
                            <input type="text" class="form-control" placeholder="CPF" name="cpf">
                        </div>
                        <div class="form-row col-md-4">
                            <label for="inputAddress">Data Nascimento</label>
                            <input type="date" class="form-control" placeholder="Data Nascimento" name="dtnascimento">
                        </div>
                        <div class="form-row col-md-4">
                            <label for="inputEmail4">Endereço</label>
                            <input type="text" class="form-control" placeholder="Seu endereco" name="endereco">
                        </div>
                        <div class="form-row col-md-4">
                            <label for="inputEmail4">Telefone</label>
                            <input type="text" class="form-control" placeholder="tel" name="telefone">
                        </div>
                        <div class="form-row col-md-4">
                            <label for="inputAddress">Data Admissão</label>
                            <input type="date" class="form-control" placeholder="Data Admissão" name="dtadmissao">
                        </div>
                        <div class="form-row col-md-4">
                            <label for="inputEmail4">Departamento</label>
                            <input type="text" class="form-control" placeholder="depar" name="departamento">
                        </div>
                        <div class="form-row col-md-4">
                            <label for="inputAddress">Salario</label>
                            <input type="number" class="form-control" placeholder="salario Atual" name="salario">
                        </div
                        <div class="form-row col-md-4">
                            <label for="inputAddress">Valor Refeição</label>
                            <input type="number" class="form-control" placeholder="Valor refeicao" name="valorrefeicao">
                        </div>
                        <div class="form-row col-md-4">
                            <label for="inputAddress">Valor Transporte</label>
                            <input type="number" class="form-control" placeholder="Valor transporte" name="valortransporte">
                        </div>

                        <p>

                        <div class="form-group row right">
                            <div class="col-sm-8">
                                <button type="submit" class="btn btn-primary">Cadastrar</button>
                            </div>
                        </div>

                    </div>
            </form>

            <a href= "${pageContext.request.contextPath}/CLTHome" > Voltar </a>  

    </body>
</html>
