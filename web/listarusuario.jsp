
<%@page import="java.sql.Connection"%>
<%@page import="dao.UsuarioDao"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="modelo.Usuario"%>
<%@page import="controle.UsuarioImpl"%>
<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>Lista de Usuarios</title>
    </head>
    
          <%@include file="home.html" %>
          <fieldset><strong> Usuarios</strong></fieldset>
      <!--  <h1>Usuários</h1> -->
        
            
                <tr>
                    <td>ID</td>
                    <td>NOME </td>
                    <td>TELEFONE</td>
                    <td>CPF</td>
                    <td>SEXO</td>
                    <td>LOGIN</td>
                    <td>SENHA</td>
                    <td>LOGRADOURO</td>
                    <td>BAIRRO</td>
                    <td>CIDADE</td>
                    
                      <td>ALTERAR</td>
                        <td>EXCLUIR</td>
                    
                    
                    <td>AÇÃO</td>
                </tr>
                       
               <%
                    UsuarioImpl usuarioImpl = new UsuarioImpl();
                    List<Usuario> list = usuarioImpl.getListAll();
                    for(Usuario usuario : list){
                        %>
                        
                        <!--select direto do banco -->
                        
                            <td><%= usuario.getId() %></td>
                            <td><%= usuario.getNome()%></td>
                            <td><%= usuario.getPhone()%></td>
                            <td><%= usuario.getCpf()%></td>
                            <td><%= usuario.getSexo()%></td>
                            <td><%= usuario.getLogin()%></td>
                            <td><%= usuario.getSenha()%></td>
                            <td><%= usuario.getLogradouro()%></td>
                            <td><%= usuario.getBairro()%></td>
                            <td><%= usuario.getCidade()%></td>
                            
                          
                            <td><a href="alterarusuario.jsp?id=<%= usuario.getId()%>">editar</a></td>
                        
                        <%
                    }
                %>
            
            <!--
            <a href="home.html">Inicio</a> -->
        
    
</html>
