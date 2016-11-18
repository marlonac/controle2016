<%-- 
    Document   : listar
    Created on : 16/11/2016, 22:49:30
    Author     : Marlon
--%>

<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="modelo.Usuario"%>
<%@page import="controle.UsuarioImpl"%>
<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>Lista de Contatos</title>
    </head>
    <body>
        <%@include file="index.html" %>
        <h1>Contatos</h1>
        <div>
            <table>
                <tr>
                    <td>ID</td>
                    <td>NOME</td>
                    <td>TELEFONE</td>
                    <td>CPF</td>
                    <td>SEXO</td>
                    <td>LOGIN</td>
                    <td>SENHA</td>
                    <td>LOGRADOURO</td>
                    <td>BAIRRO</td>
                    
                    <td>AÇÃO</td>
                </tr>
                <%
                    UsuarioImpl usuarioImpl = new UsuarioImpl();
                    List<Usuario> list = usuarioImpl.getListAll();
                    for(Usuario usuario : list){
                        %>
                        
                            <td><%= usuario.getId() %></td>
                            <td><%= usuario.getNome()%></td>
                            <td><%= usuario.getPhone()%></td>
                            <td><%= usuario.getCpf()%></td>
                            <td><%= usuario.getSexo()%></td>
                            <td><%= usuario.getLogin()%></td>
                            <td><%= usuario.getSenha()%></td>
                            <td><%= usuario.getLogradouro()%></td>
                            <td><%= usuario.getBairro()%></td>
                            
                          
                            <td><a href="alterarusuario.jsp?id=<%= usuario.getId()%>">editar</a></td>
                        
                        <%
                    }
                %>
            </table>
            <a href="index.html">Inicio</a>
        </div>
    </body>
</html>
