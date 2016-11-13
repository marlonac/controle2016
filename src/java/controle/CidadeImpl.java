/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import dao.CidadeDao;
import dao.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import modelo.Cidade;

/**
 *
 * @author Marlon
 */
public class CidadeImpl implements CidadeDao {
    
     Connection conn = ConnectionFactory.getConnection();
    PreparedStatement stmt;
    ResultSet rs;

  
    public void salvar(Cidade cidade) {
        try {
            String sql = "insert into cidade "
                    + "(nome, ) values(?)";

            stmt = conn.prepareStatement(sql);

            stmt.setString(1, cidade.getNome());
        

            stmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public void atualizar(Cidade cidade) {
        try {
            String sql = "insert into cidade "
                    + "(nome) values(?) "
                    + "where id = ?";
            stmt = conn.prepareStatement(sql);

            stmt.setString(1, cidade.getNome());
            

            stmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

public void remover(Cidade cidade){
    String sql = "delete from cidade where id = ?";
    try{
        stmt = conn.prepareStatement(sql);
        stmt.setInt(1,cidade.getId());
        
        stmt.execute();
             
    }
    catch(SQLException ex){
        ex.printStackTrace();
        
    }
}

    @Override
    public List<Cidade> getListAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Cidade findById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
}
