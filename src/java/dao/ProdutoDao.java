/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;
import java.util.List;

import modelo.Produto;

/**
 *
 * @author Marlon
 */
public interface ProdutoDao {
    
       public void salvar(Produto produto);
	public void atualizar(Produto produto);
	public void remover(Produto produto);
	public List<Produto> getListAll();
	public Produto findById(int id);   
}
