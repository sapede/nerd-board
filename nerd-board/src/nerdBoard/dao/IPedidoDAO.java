/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nerdBoard.dao;

import nerdBoard.entidades.Pedido;

/**
 *
 * @author mathe
 */
public interface IPedidoDAO {
    
    public void Adcionar(Pedido ent);
    
    public void Atualizar(Pedido ent);
    
    public void Remover(int id);
    
    public void ObterTodos();
    
    public void ObterPorId(int Id);
    
}
