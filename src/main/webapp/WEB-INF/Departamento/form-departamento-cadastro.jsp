<%-- 
    Document   : form-departamento-cadastro
    Created on : 02/06/2018, 11:32:08
    Author     : Guilherme
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
       <title>Cadastrar Carro</title>
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
            <h1>Cadastre um Carro</h1>
        </div>
        <p>
        <hr class="style13">    


        <form action="${pageContext.request.contextPath}/cadastro-departamento" method="post">
            
            <div class="form-row" >
                <div class="form-group col-md-8" >
                    <div class="form-row col-md-4">
                        <label for="inputEmail4">Departamento</label>
                        <input type="text" class="form-control" placeholder="Modelo" name="departamento">
                    </div>    
                </div>
                <p>

                <div class="form-group row right">
                    <div class="col-sm-8">
                        <button type="submit" class="btn btn-primary">Cadastrar</button>
                    </div>
                </div>

            </div>
        </form>

        <a href= "${pageContext.request.contextPath}/DepartamentoHome" > Voltar </a>  
    </body>
</html>