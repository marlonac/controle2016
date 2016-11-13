/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import modelo.Estado;

/**
 *
 * @author Marlon
 */
public interface EstadoDao {
   public void salvar(Estado estado);
	public void atualizar(Estado estado);
	public void remover(Estado estado);
	public List<Estado> getListAll();
	public Estado findById(int id);   
}