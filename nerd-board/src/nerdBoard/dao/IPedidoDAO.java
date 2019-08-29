/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nerdBoard.dao;

import java.util.List;
import nerdBoard.entidades.Pedido;

/**
 *
 * @author mathe
 */
public interface IPedidoDAO {
    
    public void Adicionar(Pedido ent);
    
    public void Atualizar(Pedido ent);
    
    public void Remover(int id);
    
    public List<Pedido> ObterTodos();
    
    public Pedido ObterPorId(int Id);
    
}
