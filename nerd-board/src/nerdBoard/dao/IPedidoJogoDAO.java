/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nerdBoard.dao;

import java.util.List;
import nerdBoard.entidades.PedidoJogo;

/**
 *
 * @author mathe
 */
public interface IPedidoJogoDAO {
    
    public void Adcionar(PedidoJogo ent);
    
    public void Atualizar(PedidoJogo ent);
    
    public void Remover(int id);
    
    public List<PedidoJogo> ObterTodos();
    
    public PedidoJogo ObterPorId(int Id);
    
}
