/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import modelo.Fornecedor;
/**
 *
 * @author Marlon
 */
public interface FornecedorDao {
    
        public void salvar(Fornecedor fornecedor);
	public void atualizar(Fornecedor fornecedor);
	public void remover(Fornecedor fornecedor);
        public List<Fornecedor> getListAll();
	public Fornecedor findById(int id);   
}