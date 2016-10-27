/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;
import java.util.List;

import modelo.Usuario;
/**
 *
 * @author Marlon
 */
public interface UsuarioDao {
    
        public void salvar(Usuario usuario);
	public void atualizar(Usuario usuario);
	public void remover(Usuario usuario);
	public List<Usuario> getListAll();
	public Usuario findById(int id);   
}


	
	


