<%-- 
    Document   : buscar
    Created on : 17-oct-2013, 10:33:50
    Author     : alumno
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="css/bootstrap.css" rel="stylesheet" >
        <style type="text/css">
            .cCentrado{
                text-align: center;
                
            }
        </style>
    </head>
    <body>
        <div class="cCentrado" >
            <h1>Buscar Entidad Bancaria</h1>
            <br /><br />
            <form class="form-search" method="GET" action="index.jsp">
                <input name="nombre" type="text" class="input-medium search-query">
                <button type="submit" class="btn">Buscar</button>
            </form>
        </div>
    </body>
</html>
