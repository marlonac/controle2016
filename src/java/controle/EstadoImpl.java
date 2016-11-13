/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import dao.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import modelo.Estado;

/**
 *
 * @author Marlon
 */
public class EstadoImpl {
    
        
     Connection conn = ConnectionFactory.getConnection();
    PreparedStatement stmt;
    ResultSet rs;

  
    public void salvar(Estado estado) {
        try {
            String sql = "insert into estado "
                    + "(nome, ) values(?)";

            stmt = conn.prepareStatement(sql);

            stmt.setString(1, estado.getNome());
        

            stmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public void atualizar(Estado estado) {
        try {
            String sql = "insert into estado "
                    + "(nome) values(?) "
                    + "where id = ?";
            stmt = conn.prepareStatement(sql);

            stmt.setString(1, estado.getNome());
            

            stmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

public void remover(Estado estado){
    String sql = "delete from estado where id = ?";
    try{
        stmt = conn.prepareStatement(sql);
        stmt.setInt(1,estado.getId());
        
        stmt.execute();
             
    }
    catch(SQLException ex){
        ex.printStackTrace();
        
    }
}
}
