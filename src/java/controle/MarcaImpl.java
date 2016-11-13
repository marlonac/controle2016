/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import dao.ConnectionFactory;
import dao.MarcaDao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import modelo.Marca;

/**
 *
 * @author Marlon
 */
public class MarcaImpl implements MarcaDao {
  
      Connection conn = ConnectionFactory.getConnection();
    PreparedStatement stmt;
    ResultSet rs;
    
    public void salvar(Marca marca) {
        try {
            String sql = "insert into marca "
                    + "(descricao) values(?)";

            stmt = conn.prepareStatement(sql);

            // verificar formato de dadoi float 
            stmt.setString(1, marca.getDescricao());
    
            stmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

   
    public void atualizar(Marca marca) {
        try {
             String sql = "insert into marca "
                    + "(descricao) values(?)"
                    + "where id = ?";
            stmt = conn.prepareStatement(sql);


            stmt.setString(1, marca.getDescricao());
    
            stmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
public void remover(Marca marca){
    String sql = "delete from marca where id = ?";
    try{
        stmt = conn.prepareStatement(sql);
        stmt.setInt(1,marca.getId());
        
        stmt.execute();
             
    }
    catch(SQLException ex){
        ex.printStackTrace();
        
    }
}  

    @Override
    public List<Marca> getListAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Marca findById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
