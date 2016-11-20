/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import dao.ConnectionFactory;
import dao.ProdutoDao;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import modelo.Produto;

/**
 *
 * @author Marlon
 */
public class ProdutoImpl implements ProdutoDao {
    
    Connection conn = ConnectionFactory.getConnection();
    PreparedStatement stmt;
    ResultSet rs;
    
@Override
    public void salvar(Produto produto) {
        try {
            String sql = "insert into produto "
                    + "(descricao, preco, quantidade, dataCadastro) values(?,?,?,?)";

            stmt = conn.prepareStatement(sql);

            // verificar formato de dadoi float 
            stmt.setString(1, produto.getDescricao());
            stmt.setFloat(2, produto.getPreco());
            stmt.setString(3, produto.getQuantidade());
            stmt.setString(4, produto.getDataCadastro());
           

            stmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void atualizar(Produto produto) {
        try {
             String sql = "insert into produto "
                    + "(descricao, preco, quantidade, dataCadastro) values(?,?,?,?)"
                    + "where id = ?";
            stmt = conn.prepareStatement(sql);

       

            stmt.setString(1, produto.getDescricao());
            stmt.setFloat(2, produto.getPreco());
            stmt.setString(3, produto.getQuantidade());
            stmt.setString(4, produto.getDataCadastro());
           

            stmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
@Override
public void remover(Produto produto){
    String sql = "delete from produto where id = ?";
    try{
        stmt = conn.prepareStatement(sql);
        stmt.setInt(1,produto.getId());
        
        stmt.execute();
             
    }
    catch(SQLException ex){
        ex.printStackTrace();
        
    }
}

    @Override
    public List<Produto> getListAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Produto findById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

