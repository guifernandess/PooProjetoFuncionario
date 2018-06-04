<%-- 
    Document   : form-clt-resultado
    Created on : 03/06/2018, 20:41:37
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
            <h1>Atualizar um funcionario</h1>
        </div>
         <p>
        <hr class="style13">    
        <div>
            <form action="${pageContext.request.contextPath}/AtualizarCLT"
                  method="post">
                
                <div class="form-row" >
                    <div class="form-group col-md-8" >
                        <div class="form-row col-md-2">
                            <label for="inputEmail4">Id CLT</label>
                            <input type="text" class="form-control" placeholder="Modelo" name="idCLT" value= "${cltAtualizado.idCLT}">
                        </div>
                        
                        <div class="form-row col-md-2">
                            <label for="inputEmail4">Id Funcionario</label>
                            <input type="text" class="form-control" placeholder="Modelo" name="idFuncionario" value= "${cltAtualizado.idFuncionario}">
                        </div>
                        
                        <div class="form-row col-md-2">
                            <label for="inputEmail4">Id Departamento</label>
                            <input type="text" class="form-control" placeholder="Modelo" name="idDepartamento" value= "${cltAtualizado.idDepartamento}">
                        </div>
                        
                        <div class="form-row col-md-4">
                            <label for="inputEmail4">Nome</label>
                            <input type="text" class="form-control" placeholder="Modelo" name="nome" value= "${cltAtualizado.nome}">
                        </div>
                        
                        <div class="form-row col-md-4">
                            <label for="inputAddress">CPF</label>
                            <input type="number" class="form-control" placeholder="Ano Fabricação" name="cpf" value= "${cltAtualizado.CPF}">
                        </div>
                        
                        <div class="form-row col-md-4">
                            <label for="inputEmail4">Data Nascimento</label>
                            <input type="date" class="form-control" placeholder="Modelo" name="dataNascimento" value= "${cltAtualizado.dataNascimento}">
                        </div>
                        
                        <div class="form-row col-md-4">
                            <label for="inputEmail4">Departamento</label>
                            <input type="text" class="form-control" placeholder="Modelo" name="departamento" value= "${cltAtualizado.Departamento}">
                        </div>
                        
                        <div class="form-row col-md-4">
                            <label for="inputEmail4">Data Admissão</label>
                            <input type="date" class="form-control" placeholder="Modelo" name="dataAdmissao" value= "${cltAtualizado.dataAdmissao}">
                        </div>
                        
                        <div class="form-row col-md-4">
                            <label for="inputEmail4">Endereço</label>
                            <input type="text" class="form-control" placeholder="Modelo" name="endereco" value= "${cltAtualizado.endereco}">
                        </div>
                        
                        <div class="form-row col-md-4">
                            <label for="inputAddress">Telefone</label>
                            <input type="number" class="form-control" placeholder="Ano Fabricação" name="telefone" value= "${cltAtualizado.telefone}">
                        </div>
                        
                        <div class="form-row col-md-4">
                            <label for="inputAddress">Valor Refeição</label>
                            <input type="number" class="form-control" placeholder="Ano Fabricação" name="valorRefeicao" value= "${cltAtualizado.valorRefeicao}">
                        </div>
                        
                        <div class="form-row col-md-4">
                            <label for="inputAddress">Valor Transporte</label>
                            <input type="number" class="form-control" placeholder="Ano Fabricação" name="valorTransporte" value= "${cltAtualizado.valorTransporte}">
                        </div>
                        
                        <div class="form-row col-md-4">
                            <label for="inputAddress">Salario</label>
                            <input type="number" class="form-control" placeholder="Ano Fabricação" name="salario" value= "${cltAtualizado.salario}">
                        </div>
                        
                        
                        
                        <div class="custom-control custom-radio custom-control-inline">
                            <input type="radio" id="customRadioInline1" name="metodo" class="custom-control-input" value="atualizar">
                            <label class="custom-control-label" for="customRadioInline1">Atualizar</label>
                        </div>
                        
                        <div class="custom-control custom-radio custom-control-inline">
                            <input type="radio" id="customRadioInline2" name="metodo" value="deletar" class="custom-control-input">
                            <label class="custom-control-label" for="customRadioInline2">Deletar</label>
                        </div>
                    </div>
                    <p>

                    <div class="form-group row">
                        <div class="col-sm-8">
                            <button type="submit" class="btn btn-primary">Salvar</button>
                        </div>
                    </div>

                </div>
            </form>
            <p> 
                <a href= "${pageContext.request.contextPath}/DepartamentoHome" > Voltar </a> 

                <script>

                    var classe = "${departamentoAtualizado.idDepartamento}";
                    var element = document.querySelector('#categoria');
                    element.selectedIndex = classe;

                </script>   
        </div>
    </body>
</html>
