<%-- 
    Document   : alterarusuario
    Created on : 16/11/2016, 22:57:15
    Author     : Marlon
--%>

<%@page import="dao.CidadeDao"%>
<%@page import="modelo.Cidade"%>
<%@page import="controle.UsuarioImpl"%>
<%@page import="modelo.Usuario"%>
<jsp:useBean id="cidadeDao" class="controle.CidadeImpl"/>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- As 3 meta tags acima *devem* vir em primeiro lugar dentro do `head`; qualquer outro conteúdo deve vir *após* essas tags -->
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
    <title>Cadastro de usuários</title>

    <!-- Bootstrap -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link rel="icon" href="../../favicon.ico">

   
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

    <link href="bootstrap-3.3.7-dist/css/bootstrap-theme.min.css" rel="stylesheet" type="text/css"/>
    <
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">

  
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>


    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Alterar Usuarios</title>
    </head>
    <body>
        <div class="page-header">
            <div class="jumbotron">

                <h2><center><B>Alterar Usuário<B></center></h2>
                                </div>
                                <div class="container">

                                    <!--formulario de cadastro de usuarios -->
                                    <form action="cadastro" method="post">
                                        <div class="form-group">

                                            <%
                                                int id = 0;
                                                Usuario usuario = new Usuario();
                                                if (request.getParameter("id") != null) {
                                                    id = Integer.valueOf(request.getParameter("id"));
                                                    usuario = new UsuarioImpl().findById(id);
                                                }
                                            %>
                                            <div class="col-xs-6">
                                                <label for="name">Nome</label><input class="form-control" id="name" name="nome"value="<%=usuario.getNome()%>"<br>

                                               <!-- <label for="sexo">Sexo</label> <br> Masculino<input type="radio" id="sexo" name="sexo"value="<%=usuario.getSexo()%>"><br>
                                               
                                                Feminino<input type="radio" id="sexo" name="sexo" value=" <%=usuario.getSexo()%>"<br><br><br> -->

                                                <label for="phone">Telefone</label> <input class="form-control" id="phone"  name="phone" value="<%=usuario.getPhone()%>"<br>

                                                <label for="cpf">CPF</label><input class="form-control" id="cpf" name="cpf" value="<%=usuario.getCpf()%>"<br>

                                                <label for=logradouro"> Endereço</label><input class="form-control" id="logradouro" name="logradouro" value="<%=usuario.getLogradouro()%>"<br>

                                                <label for="cep">CEP</label><input class="form-control" id="cep" name="cep" value="<%=usuario.getCep()%>"<br>

                                                <label for="bairro">Bairro</label><input class="form-control" id="bairro" name="bairro" value="<%=usuario.getBairro()%>"<br>

                                                <label for="idcidade">Cidade</label> 
                                                <select name="idcidade"> 
                                                    <%
                                                        if (id != 0) {
                                                    %>
                                                    <option value="<%=usuario.getCidade().getId()%>"><%=usuario.getCidade().getNome()%></option>
                                                    <%
                                                        }

                                                        for (Cidade cidade : cidadeDao.getListAll()) {
                                                    %>
                                                    <option value="<%=cidade.getId()%>"><%=cidade.getNome()%></option>
                                                    <%
                                                        }
                                                    %>
                                                </select> <br>

                                                <label for="login">Login</label><input class="form-control" id="login" name="login" value="<%=usuario.getLogin()%>"<br>

                                                <label for="senha">Senha</label><input class="form-control"  id="senha" name="senha" value="<%=usuario.getSenha()%>"<br>

                                                <input type="hidden" name="id" value="<%=id%>"/>
                                                <button type="submit" value="Alterar"class="btn btn-primary">Alterar</button>

                                                <a
                                                    <button class="btn btn btn-danger" type="submit" href="listarusuario.jsp">Cancelar</button> </a>

                                                <a <button class="btn btn btn-warning" type="submit" href="cadastro.jsp">Novo Cadastro</button></a>


                                            </div>
                                        </div>
                                    </form>
                                </div>
                                <!-- jQuery (obrigatório para plugins JavaScript do Bootstrap) -->
                                <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
                                <!-- Inclui todos os plugins compilados (abaixo), ou inclua arquivos separadados se necessário -->
                                <script src="js/bootstrap.min.js"></script>
                                </body>
                                </html>
