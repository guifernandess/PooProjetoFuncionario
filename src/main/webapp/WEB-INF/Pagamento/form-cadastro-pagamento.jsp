<%-- 
    Document   : form-cadastro-pagamento
    Created on : 26/05/2018, 18:00:51
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
        <div> 
        <h1>Realizar Pagamento</h1>
        </div>
            <form action="${pageContext.request.contextPath}/cadastro-pagamento"
                  method="post">
                implementar a pagina...
                
                <div>
                    Nome: <input type="text" name="carro" />
                </div>
                <div>
                    Nome: <input type="text" name="carro" />
                </div>
                <div>
                    Nome: <input type="text" name="carro" />
                </div>
            </form>
    </body>
</html>
