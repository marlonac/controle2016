<%-- 
    Document   : cadastro
    Created on : 25/10/2016, 00:52:07
    Author     : Marlon
--%>
<%@page import="controle.UsuarioImpl"%>
<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>
<%@page import="modelo.Cidade" %>
<%@page import="modelo.Usuario" %>
<jsp:useBean id="cidadeDao" class="controle.CidadeImpl"/>

<!DOCTYPE html>
<html lang="pt-br">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <!-- As 3 meta tags acima *devem* vir em primeiro lugar dentro do `head`; qualquer outro conteúdo deve vir *após* essas tags -->
        <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
        <title>Cadastro de usuários</title>

        <!-- Bootstrap -->
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <link rel="icon" href="../../favicon.ico">

        <!-- Latest compiled and minified CSS -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

        <link href="bootstrap-3.3.7-dist/css/bootstrap-theme.min.css" rel="stylesheet" type="text/css"/>
        <!-- Optional theme -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">

        <!-- Latest compiled and minified JavaScript -->
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>


        <!-- HTML5 shim e Respond.js para suporte no IE8 de elementos HTML5 e media queries -->
        <!-- ALERTA: Respond.js não funciona se você visualizar uma página file:// -->
        <!--[if lt IE 9]>
          <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
          <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
        <![endif]-->
    </head>

    <body>
        
        
        <div class="page-header">
            <div class="jumbotron">
                <%-- <%@include file="home.html" %> --%>
                <h2><center><B>Cadastro de Usuários<B></center></h2>
                                </div>


                                <div class="container">

                                    <!--formulario de cadastro de usuarios -->
                                    <form action="cadastrarusuario" method="post">
                                        <div class="form-group">

                                            <div class="col-xs-6">
                                                <label for="name">Nome</label>
                                                <input class="form-control" id="name" name="nome" type="text" required=""><br>

                                                <label for="sexo">Sexo</label> <br>
                                                <input type="radio" id="sexo" name="sexo" value="M"/> Masculino
                                                <input type="radio" id="sexo" name="sexo" value="F"/> Feminino <br><br>
                                                <!-- navegação para selecionar o sexo do usuario
                                                       <select class="form-control" id="sexo" type="text"><br>
                                                 <option>Selecione uma OPÇÃO</option>
                                                 <option>Masculino</option>
                                                 <option>Feminino</option>
                                               </select> -->


                                                <label for="phone">Telefone</label>
                                                <input class="form-control" id="phone"  name="phone" type="text" required=""><br>

                                                <label for="email">E-mail</label>
                                                <input class="form-control" id="email" name="email" type="text" required="">

                                                <label for="cpf">CPF</label>
                                                <input class="form-control" id="cpf" name="cpf" type="text" placeholder="Somente Numeros"required=""><br>

                                                
                                                <label for=logradouro"> Endereço</label>
                          
                                                <input class="form-control" id="logradouro" name="logradouro" type="text" required=""><br>


                                                <label for="cep">CEP</label>
                                                <input class="form-control" id="cep" name="cep" type="text" required=""><br>
                                                
                                              <label for="bairro">Bairro</label>
                                                <input class="form-control" id="bairro" name="bairro"type="text" required=""><br>
                                                
                                                <label for="idcidade">Cidade</label>
                                                <select name="idcidade" class="form-control">
                                                    <option value="">Escolha</option>
                                                <%
                                                for(Cidade c : cidadeDao.getListAll()){
                                                %>
                                                    <option value="<%=c.getId()%>"><%=c.getNome()%></option>
                                                <%
                                                }    
                                                %>
                                                </select> <br>

                                                <label for="login">Login</label>
                                                <input class="form-control" id="login" name="login" type="text" required=""><br>

                                                <label for="senha">Senha</label>
                                                <input class="form-control"  id="senha" name="senha" type="password" required=""><br>

                                                <label for="senha">Confirmar Senha</label>
                                                <input class="form-control"  id="senha" name="senha" type="password" required=""><br>
                                                <!--butoes do formulario-->
                                                <button type="submit" class="btn btn-primary">Cadastrar</button>


                                                <a
                                                    <button class="btn btn btn-danger" type="submit" href="index.html">Cancelar</button> </a>


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


