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
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Cidade;

/**
 *
 * @author Marlon
 */
public class CidadeImpl implements CidadeDao {
    
     Connection conn = ConnectionFactory.getConnection();
    PreparedStatement stmt;
    ResultSet rs;

  
     @Override
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
        List<Cidade> listCidades = new ArrayList<>();
        String sql = "Select idcidade, nome, idestado from cidade order by nome";
        try {
            stmt = conn.prepareStatement(sql);
            rs  = stmt.executeQuery();
            
            while(rs.next()){
                Cidade c = new Cidade();
                c.setId(rs.getInt(1));
                c.setNome(rs.getString(2));
                c.getEstado().setId(rs.getInt(3));
                
                listCidades.add(c);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(CidadeImpl.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
        }
        return listCidades;
    }    
    public Cidade findById(int id) {
        String sql = "SELECT cidade.id, cidade.nome, cidade.idestado, estado.nome FROM cidade, estado "
                + " WHERE cidade.idestado = estado.id AND cidade.id = ?";
        Cidade c = new Cidade();
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            rs = stmt.executeQuery();
            
            rs.next();
            c.setId(rs.getInt(1));
            c.setNome(notNull(rs.getString(2)));
            
            c.getEstado().setId(rs.getInt(3));
            c.getEstado().setNome(notNull(rs.getString(4)));
            
        } catch (SQLException ex) {
            Logger.getLogger(CidadeImpl.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
        }
        
        return c;
    }
    
    public String notNull(String msg){
        return (msg == null? "" : msg);
    }
}