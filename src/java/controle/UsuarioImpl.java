/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.UsuarioDao;
import dao.ConnectionFactory;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Usuario;


/**
 *
 * @author Marlon
 */
public abstract class UsuarioImpl implements UsuarioDao {
    
	Connection conn = ConnectionFactory.getConnection();
	PreparedStatement stmt;
	ResultSet rs;

@Override
	public void salvar(Usuario usuario) {
		try {
			String sql = "insert into usuario "
                                + "(nome, phone, cpf, sexo, senha) values(?,?,?,?,?)";
			
			stmt = conn.prepareStatement(sql);
			
			stmt.setString(1, usuario.getNome());
                        stmt.setString(2, usuario.getPhone());
                        stmt.setString(3, usuario.getCpf());
                        stmt.setString(4, usuario.getSexo());
                        stmt.setString(5, usuario.getSenha());
			
			stmt.execute();
} catch (SQLException e) {
			e.printStackTrace();
		}
        }

    @Override
    public void atualizar(Usuario usuario) {
        try {
        String sql = "insert into usuario "
                                + "(nome, phone, cpf, sexo, senha) values(?,?,?,?,?)"
                    + "where id = ?";
                        stmt = conn.prepareStatement(sql);
			
			stmt.setString(1, usuario.getNome());
                        stmt.setString(2, usuario.getPhone());
                        stmt.setString(3, usuario.getCpf());
                        stmt.setString(4, usuario.getSexo());
                        stmt.setString(5, usuario.getSenha());
			
			stmt.execute();
                } catch (SQLException e) {
			e.printStackTrace();
		}
        }  
        
    }
/*
	public void remover(Usuario usuario) {
		// TODO Auto-generated method stub
            try {
                 String sql = "delete from usuario where id = ?";
                 stmt = conn.prepareStatement(sql);
          
                stmt.setInt(1, usuario.getId());
                
                stmt.execute();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
	}

*/
/* falta outros metodos*/


