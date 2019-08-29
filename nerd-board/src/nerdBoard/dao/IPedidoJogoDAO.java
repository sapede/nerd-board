/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nerdBoard.dao;

import nerdBoard.entidades.PedidoJogo;

/**
 *
 * @author mathe
 */
public interface IPedidoJogoDAO {
    
    public void Adcionar(PedidoJogo ent);
    
    public void Atualizar(PedidoJogo ent);
    
    public void Remover(int id);
    
    public void ObterTodos();
    
    public void ObterPorId(int Id);
    
}
