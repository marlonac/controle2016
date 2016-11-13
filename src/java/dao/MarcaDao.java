/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import modelo.Marca;


/**
 *
 * @author Marlon
 */
public interface MarcaDao {
    
 public void salvar(Marca marca);
	public void atualizar(Marca marca);
	public void remover(Marca marca);
	public List<Marca> getListAll();
	public Marca findById(int id);   
}