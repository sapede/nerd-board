/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nerdBoard.dao;

import nerdBoard.entidades.ReservaJogo;

/**
 *
 * @author mathe
 */
public interface IReservaJogoDAO {
    
    public void Adcionar(ReservaJogo ent);
    
    public void Atualizar(ReservaJogo ent);
    
    public void Remover(int id);
    
    public void ObterTodos();
    
    public void ObterPorId(int Id);
    
}
