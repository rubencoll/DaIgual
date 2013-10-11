<%@page import="com.fpmislata.daw2.bancocutre.datos.EntidadBancariaDAOImplJDBC"%>
<%@page import="com.fpmislata.daw2.bancocutre.negocio.TipoEntidadBancaria"%>
<%@page import="com.fpmislata.daw2.bancocutre.datos.EntidadBancariaDAO"%>
<%@page import="com.fpmislata.daw2.bancocutre.negocio.EntidadBancaria"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Date"%>
<%

    Date hoy = new Date();


    //Prueba para buscar una entidad Bancaria mediante ID

    int idEntidadBancariaBuscarda = 3;

    EntidadBancariaDAO entidadBancariaDAO = new EntidadBancariaDAOImplJDBC();

    EntidadBancaria entidadBancariaBuscada = new EntidadBancaria();
    entidadBancariaBuscada = entidadBancariaDAO.read(idEntidadBancariaBuscarda);


    int idEntidadBancaria = entidadBancariaBuscada.getIdEntidadBancaria();
    String codigo = entidadBancariaBuscada.getCodigoEntidadBancaria();
    String nombre = entidadBancariaBuscada.getNombre();
    TipoEntidadBancaria tipoEntidadBancaria = entidadBancariaBuscada.getTipoEntidadBancaria();

    //Mostrar muchas entidades bancarias    

    List<EntidadBancaria> entidadesBancarias = new ArrayList<EntidadBancaria>();

    entidadesBancarias = entidadBancariaDAO.findAll();

    /* for (EntidadBancaria entidadBancaria : entidadesBancarias) {

     out.println(entidadBancaria.getIdEntidadBancaria());
     out.println(entidadBancaria.getCodigoEntidadBancaria());
     out.println(entidadBancaria.getNombre());
     out.println(entidadBancaria.getTipoEntidadBancaria());
     out.println(entidadBancaria.getCif());
     }*/
    
    //Prueba con Data Source
    
    

%>

<%@page import="java.util.GregorianCalendar"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="css/bootstrap.css" rel="stylesheet" >
    </head>
    <body>
        <h1>Entidades Bancarias</h1>

        <table class="table">
            <th>IDENTIFICADOR</th>
            <th>CODIGO</th>
            <th>NOMBRE</th>
            <th>TIPO</th>
            <th>CIF</th>
            <%

                for (EntidadBancaria entidadBancaria : entidadesBancarias) {
            %>
            <tr>
                <td>Identificador:<%= entidadBancaria.getIdEntidadBancaria()%></td>
                <td>Codigo:<%= entidadBancaria.getCodigoEntidadBancaria()%></td>
                <td>Nombre:<%= entidadBancaria.getNombre()%></td>
                <td>Tipo:<%= entidadBancaria.getTipoEntidadBancaria()%></td>       
                <td>Cif:<%= entidadBancaria.getCif()%></td>
            </tr>
            <%
                }
            %>
        </table>
    </body>
</html>
