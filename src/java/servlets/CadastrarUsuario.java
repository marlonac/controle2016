/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import controle.UsuarioImpl;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Cidade;
import modelo.Usuario;

/**
 *
 * @author Marlon
 */
@WebServlet(name = "CadastrarUsuario", urlPatterns = {"/cadastrarusuario"})
public class CadastrarUsuario extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet CadastrarUsuario</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet CadastrarUsuario at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        
        Usuario usuario = new Usuario(); //cria o objeto para usuario
        int id=0;
        if(request.getParameter("id") !=null)
            id = Integer.valueOf(request.getParameter("id"));
        
        //preencher o objeto usuario
        usuario.setNome(request.getParameter("nome"));
        usuario.setPhone(request.getParameter("phone"));
        usuario.setCpf(request.getParameter("cpf"));
        usuario.setSexo(request.getParameter("sexo"));
        usuario.setLogin(request.getParameter("login"));
        usuario.setSenha(request.getParameter("senha"));
        usuario.setLogradouro(request.getParameter("logradouro"));
        usuario.setCep(request.getParameter("cep"));
        usuario.setBairro(request.getParameter("bairro"));
        
        Cidade cidade = new Cidade();
        cidade.setId(Integer.valueOf(request.getParameter("idcidade")));
        
        usuario.setCidade(cidade);
        
        UsuarioImpl usuarioDao = new UsuarioImpl();
              //salva ou altera
        if(id != 0){
            usuario.setId(id);
            usuarioDao.atualizar(usuario);
            //atualizar usuario
             response.sendRedirect("listarusuario.jsp");
            
        }else
            usuarioDao.salvar(usuario);
        
        //retorna pra a tela de cadastro
        response.sendRedirect("cadastro.jsp");
        
    }        
    }