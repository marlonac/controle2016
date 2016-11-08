/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import dao.ConnectionFactory;
import dao.FornecedorDao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import modelo.Fornecedor;

/**
 *
 * @author Marlon
 */

public abstract class FornecedorImpl implements FornecedorDao {

    Connection conn = ConnectionFactory.getConnection();
    PreparedStatement stmt;
    ResultSet rs;
    
    public void salvar(Fornecedor fornecedor) {
    
        try {
            String sql = "insert into fornecedor "
                    + "(nome, email, phone, cnpj, logradouro, cep, bairro) values(?,?,?,?,?,?,?)";

            stmt = conn.prepareStatement(sql);

            stmt.setString(1, fornecedor.getNome());
            stmt.setString(2, fornecedor.getEmail());
            stmt.setString(3, fornecedor.getPhone());
            stmt.setString(4, fornecedor.getCnpj());
            stmt.setString(5, fornecedor.getLogradouro());
            stmt.setString(6, fornecedor.getCep());
            stmt.setString(7, fornecedor.getBairro());

            stmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void atualizar(Fornecedor fornecedor) {
        try {
            String sql = "insert into fornecedor "
                    + "(nome, email, phone, cnpj, logradouro, cep, bairro) values(?,?,?,?,?,?,?)"
                    + "where id = ?";
            stmt = conn.prepareStatement(sql);

            stmt.setString(1, fornecedor.getNome());
            stmt.setString(2, fornecedor.getEmail());
            stmt.setString(3, fornecedor.getPhone());
            stmt.setString(4, fornecedor.getCnpj());
            stmt.setString(5, fornecedor.getLogradouro());
            stmt.setString(6, fornecedor.getCep());
            stmt.setString(7, fornecedor.getBairro());
            

            stmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
public void remover(Fornecedor fornecedor){
    String sql = "delete from contato where id = ?";
    try{
        stmt = conn.prepareStatement(sql);
        stmt.setInt(1,fornecedor.getId());
        
        stmt.execute();
             
    }
    catch(SQLException ex){
        ex.printStackTrace();
        
    }
}
}