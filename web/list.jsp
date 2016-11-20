<%-- 
    Document   : list
    Created on : 20/11/2016, 15:29:59
    Author     : Marlon
--%>


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
          <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <title>Lista de Usuarios</title>
    </head>
            
       <div>
         
           <center>    <h1>Usuários</h1> </center> 
             <div class="container">
 
  <table class="table table-bordered">
    <thead>
         
                <tr>
                    <td>ID</td> 
                    <td>NOME </td>
                    <td>TELEFONE</td>
                    <td>CPF</td>
                    <td>SEXO</td>
                    <td>LOGIN</td>
                    <td>SENHA</td>
                    <td>LOGRADOURO</td>
                     <td>CEP</td>
                    <td>BAIRRO</td>
                    <td>CIDADE</td>
                    <td>ALTERAR</td>
                     <td>EXCLUIR</td>
                </tr> 

               <%
                    UsuarioImpl usuarioImpl = new UsuarioImpl();
                    List<Usuario> list = usuarioImpl.getListAll();
                    for(Usuario usuario : list){
                        
                      
                        %>
                        
                        <!--select direto do banco -->
                        
                        <tr><td><%= usuario.getId() %></td>
                            <td><%= usuario.getNome()%></td> 
                            <td><%= usuario.getPhone()%></td>
                            <td><%= usuario.getCpf()%></td>
                            <td><%= usuario.getSexo()%></td>
                            <td><%= usuario.getLogin()%></td>
                            <td><%= usuario.getSenha()%></td>
                            <td><%= usuario.getLogradouro()%></td>
                            <td><%= usuario.getCep()%></td>
                            <td><%= usuario.getBairro()%></td>
                            <td><%= usuario.getCidade()%></td>
                            
                          
                            
                            
                          
                            <td><a href="alterarusuario.jsp?id=<%= usuario.getId()%>">editar</a></td> <br>
                            
                        <%
                    }
                %>
        </tr>           
  </table>
            <!--
            <a href="home.html">Inicio</a> -->
             </div>
      </div>
  
         <script src="//ajax.googleapis.com/ajax/libs/jquery/2.0.2/jquery.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
        <script src="js/scripts.js"></script>
    </body>
</html>

