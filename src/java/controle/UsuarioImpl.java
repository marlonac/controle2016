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
import modelo.Cidade;
import modelo.Usuario;


/**
 *
 * @author Marlon
 */
public class UsuarioImpl implements UsuarioDao {

    Connection conn = ConnectionFactory.getConnection();
    PreparedStatement stmt;
    ResultSet rs;
   

    @Override
    public void salvar(Usuario usuario) {
        try {
            String sql = "insert into usuario" +"(nome, phone, cpf, sexo, senha, logradouro, cep, bairro, login, idcidade) values(?,?,?,?,?,?,?,?,?,?)";

            stmt = conn.prepareStatement(sql);

            stmt.setString(1, usuario.getNome());
            stmt.setString(2, usuario.getPhone());
            stmt.setString(3, usuario.getCpf());
            stmt.setString(4, usuario.getSexo());
            stmt.setString(5, usuario.getSenha());
            stmt.setString(6, usuario.getLogradouro());
            stmt.setString(7, usuario.getCep());
            stmt.setString(8, usuario.getBairro());
            stmt.setString(9, usuario.getLogin());
            stmt.setInt(10, usuario.getCidade().getId());

            stmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void atualizar(Usuario usuario) {
        try {
            String sql = "insert into usuario  "+"(nome=?, phone=?, cpf=?, sexo=?, senha=?, logradouro=?, cep=?, bairro=?, login=?, idcidade=?) values(?,?,?,?,?,?,?,?,?,?) where id = ?";
            stmt = conn.prepareStatement(sql);

            stmt.setString(1, usuario.getNome());
            stmt.setString(2, usuario.getPhone());
            stmt.setString(3, usuario.getCpf());
            stmt.setString(4, usuario.getSexo());
            stmt.setString(5, usuario.getSenha());
            stmt.setString(6, usuario.getLogradouro());
            stmt.setString(7, usuario.getCep());
            stmt.setString(8, usuario.getBairro());
            stmt.setString(9, usuario.getLogin());
             stmt.setInt(10, usuario.getCidade().getId());

            stmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
@Override
public void remover(Usuario usuario){
    String sql = "delete from contato where id = ?";
    try{
        stmt = conn.prepareStatement(sql);
        stmt.setInt(1,usuario.getId());
        
        stmt.execute();
             
    }
    catch(SQLException ex){
        ex.printStackTrace();
        
    }
}

    /**
     *
     * @return
     */
    @Override
    public List<Usuario> getListAll() {
            List<Usuario> list = new ArrayList<Usuario>();
        try {
            //ver se é id ou idusuario
            String sql = "select id, nome, phone, cpf, login, senha, logradouro, cep,bairro, idcidade from usuario";
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();
            while (rs.next()) {
                
                Usuario u = new Usuario();
                u.setId(rs.getInt(1));
                u.setNome(notNull(rs.getString(2)));
                u.setPhone(notNull(rs.getString(3)));
                u.setCpf(notNull(rs.getString(4)));
                u.setSenha(notNull(rs.getString(5)));
                u.setLogradouro(notNull(rs.getString(6)));
                u.setCep(notNull(rs.getString(7)));
                u.setBairro(notNull(rs.getString(8)));
                u.setLogin(notNull(rs.getString(9)));
             
            
                //cria um objeto cidade
                Cidade cidade = new CidadeImpl().findById((rs.getInt(10)));

                //pesquiss e retorna as informações da cidade do contato
                u.setCidade(cidade);
//                                System.out.println("id da cidade:"+rs.getInt(4));
                list.add(u);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
 @Override
    public Usuario findById(int id) {
        String sql = "select id, nome, phone, cpf, login, senha, logradouro, cep, bairro, idcidade from usuario where id = ?";
        Usuario u = new Usuario();
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            rs = stmt.executeQuery();
            rs.next();
                u.setId(rs.getInt(1));
                u.setNome(notNull(rs.getString(2)));
                u.setPhone(notNull(rs.getString(3)));
                u.setCpf(notNull(rs.getString(4)));
                u.setSenha(notNull(rs.getString(5)));
                u.setLogin(notNull(rs.getString(6)))
                u.setLogradouro(notNull(rs.getString(7)));
                u.setCep(notNull(rs.getString(8)));
                u.setBairro(notNull(rs.getString(9)));
                
            

                //cria um objeto cidade
                Cidade cidade = new CidadeImpl().findById((rs.getInt(10)));

   

            //pesquiss e retorna as informações da cidade do contato
            u.setCidade(cidade);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return u;
    }

    public String notNull(String msg) {
        return (msg == null ? "" : msg);
    }

}