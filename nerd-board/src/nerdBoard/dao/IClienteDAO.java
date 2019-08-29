/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nerdBoard.dao;

import nerdBoard.entidades.Cliente;

/**
 *
 * @author mathe
 */
public interface IClienteDAO {
    
    public void Adcionar(Cliente ent);
    
    public void Atualizar(Cliente ent);
    
    public void Remover(int id);
    
    public void ObterTodos();
    
    public void ObterPorId(int Id);
    
}
