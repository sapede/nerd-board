/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nerdBoard.dao;

import java.util.List;
import nerdBoard.entidades.ReservaJogo;

/**
 *
 * @author mathe
 */
public interface IReservaJogoDAO {
    
    public void Adicionar(ReservaJogo ent);
    
    public void Atualizar(ReservaJogo ent);
    
    public void Remover(int id);
    
    public List<ReservaJogo> ObterTodos();
    
    public ReservaJogo ObterPorId(int Id);
    
}
