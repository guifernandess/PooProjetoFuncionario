<%-- 
    Document   : form-departamento-resultado
    Created on : 02/06/2018, 13:01:34
    Author     : Guilherme
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
       <title>Atualizar Departamento</title>
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
            <h1>Atualizar Departamento</h1>
        </div>
        <p>
        <hr class="style13">    
        <div>
            <form action="${pageContext.request.contextPath}/AtualizarDepartamento"
                  method="post">

                <div class="form-row" >
                    <div class="form-group col-md-8" >
                        <div class="form-row col-md-2">
                            <label for="inputEmail4">Id Departamento</label>
                            <input type="text" class="form-control" placeholder="Modelo" name="idDepartamento" value= "${departamentoAtualizado.idDepartamento}">
                        </div>
                        <div class="form-row col-md-4">
                            <label for="inputEmail4">Departamento</label>
                            <input type="text" class="form-control" placeholder="Modelo" name="departamento" value= "${departamentoAtualizado.nome}">
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
