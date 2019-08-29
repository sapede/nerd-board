/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nerdBoard.dao;

import java.util.List;
import nerdBoard.entidades.Cliente;

/**
 *
 * @author mathe
 */
public interface IClienteDAO {
    
    public void Adcionar(Cliente ent);
    
    public void Atualizar(Cliente ent);
    
    public void Remover(int id);
    
    public List<Cliente> ObterTodos();
    
    public Cliente ObterPorId(int Id);
    
}
