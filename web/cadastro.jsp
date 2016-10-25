<%-- 
    Document   : cadastro
    Created on : 25/10/2016, 00:52:07
    Author     : Marlon
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
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

 <h2><center><B>Cadastro de Usuários<B></center></h2>
</div>
<!--   <form>
  <div class="form-group" align="center">
    <!-- for =  nome do campo que recebe via GET-->
  <!--  <label for="exampleInputEmail1">Endereço de e-mail</label>
    <!--id =  nome do campo no banco de dados -->
  <!--  <input type="email" class="form-control" id="exampleInputEmail1" placeholder="Email" >
  </div>
  <div class="form-group">
    <label for="exampleInputPassword1">Senha</label>
    <input type="password" class="form-control" id="exampleInputPassword1" placeholder="Password">
  </div>  
<button type="submit" class="btn btn-default">Enviar</button> 
</form> -->

  <div class="container">
 
<!--formulario de cadastro de usuarios -->
  <form>
    <div class="form-group">
 
      <div class="col-xs-6">
        <label for="name">Nome</label>
        <input class="form-control" id="name" type="text"><br>

         <label for="sexo">Sexo</label>
         <!-- navegação para selecionar o sexo do usuario -->
                <select class="form-control" id="sexo" type="text"><br>
          <option>Selecione uma OPÇÃO</option>
          <option>Masculino</option>
          <option>Feminino</option>
        </select>
               
        <label for="address">Endereço</label>
        <input class="form-control" id="address" type="text">

         <label for="phone">Telefone</label>
        <input class="form-control" id="phone" type="text"><br>

         <label for="email">E-mail</label>
        <input class="form-control" id="email" type="text">

           <label for="cpf">CPF</label>
        <input class="form-control" id="cpf" type="text"><br>

           <label for="password">Senhaa</label>
        <input class="form-control" id="password" type="password"><br>

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


