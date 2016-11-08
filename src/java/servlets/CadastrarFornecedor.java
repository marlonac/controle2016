/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import controle.FornecedorImpl;
import dao.FornecedorDao;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Fornecedor;

/**
 *
 * @author Marlon
 */
@WebServlet(name = "CadastrarFornecedor", urlPatterns = {"/cadastrarFornecedor"})
public class CadastrarFornecedor extends HttpServlet {

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
            out.println("<title>Servlet CadastrarFornecedor</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet CadastrarFornecedor at " + request.getContextPath() + "</h1>");
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
        processRequest(request, response);
        
     
   
    Fornecedor fornecedor = new Fornecedor(); //cria o objeto para usuario
        int id=0;
        if(request.getParameter("id") !=null)
            id = Integer.valueOf(request.getParameter("id"));
        
        //preencher o objeto usuario
        fornecedor.setNome(request.getParameter("nome"));
        fornecedor.setEmail(request.getParameter("email"));
        fornecedor.setPhone(request.getParameter("phone"));
        fornecedor.setCnpj(request.getParameter("cnpj"));
        fornecedor.setLogradouro(request.getParameter("logradouro"));
        fornecedor.setCep(request.getParameter("cep"));
        fornecedor.setBairro(request.getParameter("bairro"));
        
        //alterar para fornecedorIml
        FornecedorImpl fornecedorDao = new FornecedorImpl() {
            
            public List<Fornecedor> getListAll() {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            public Fornecedor findById(int id) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            public void salvar(FornecedorDao fornecedor) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            public void atualizar(FornecedorDao fornecedor) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            public void remover(FornecedorDao fornecedor) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void salvar(Fornecedor fornecedor) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void atualizar(Fornecedor fornecedor) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void remover(Fornecedor fornecedor) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        };
              //salva ou altera
        if(id != 0){
            fornecedor.setId(id);
            fornecedorDao.atualizar(fornecedor);
        }else
            fornecedor.salvar(fornecedor);
        
        //retorna pra a tela de cadastro
        response.sendRedirect("fornecedor.jsp");
        
    }        

    private void Fornecedor() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
   
 }