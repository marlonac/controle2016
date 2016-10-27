<%-- 
    Document   : teste1
    Created on : 27/10/2016, 02:14:18
    Author     : Marlon
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="modelo.Usuario"%>
<%@page import="controle.UsuarioImpl"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>Lista de Usuarios</title>
    </head>
    <body>
        <h1>Usuarios</h1>
        <div>
            
                <tr>
                    <td>ID</td>
                    <td>NOME</td>
                    <td>TELEFONE</td>
                </tr>
                <%
                    UsuarioImpl usuarioImpl = new usuarioImpl();
                    List<Usuario>list  = usuarioImpl.getListAll();
                    for(Usuario c: list){
                    %>
                   <%= c.getId()%></td>
                        <td><%= c.getPhone()%></td>
                        <td><%= c.getSexo()%></td>
                        <td><%= c.getSenha()%></td>
                        
                    </tr>
                                <%
                    }
                %>
            
        </div>
    </body>
</html>
