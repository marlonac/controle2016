/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import controle.MarcaImpl;
import controle.ProdutoImpl;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Marca;

/**
 *
 * @author Marlon
 */
@WebServlet(name = "CadastrarMarca", urlPatterns = {"/cadastrarmarca"})
public class CadastrarMarca extends HttpServlet {

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
            out.println("<title>Servlet CadastrarMarca</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet CadastrarMarca at " + request.getContextPath() + "</h1>");
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
        
      
        Marca marca= new Marca(); //cria o objeto para produto
        int id=0;
        if(request.getParameter("id") !=null)
            id = Integer.valueOf(request.getParameter("id"));
        
        //preencher o objeto usuario
        marca.setDescricao(request.getParameter("descricao"));
      
       
        
        MarcaImpl marcaDao = new MarcaImpl(); 
      
              //salva ou altera
        if(id != 0){
            marca.setId(id);
            marcaDao.atualizar(marca);
        }else
            marcaDao.salvar(marca);
        
        //retorna pra a tela de cadastro
        response.sendRedirect("produto.jsp");
        
    }        
    }
