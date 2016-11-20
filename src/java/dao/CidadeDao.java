/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import modelo.Cidade;

/**
 *
 * @author Marlon
 */
public interface CidadeDao {
    
        public void salvar(Cidade cidade);

    public void atualizar(Cidade cidade);
	public void remover(Cidade cidade);
	public List<Cidade> getListAll();
	public Cidade findById(int id);   
}