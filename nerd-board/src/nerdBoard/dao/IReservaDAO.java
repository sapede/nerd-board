/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nerdBoard.dao;

import nerdBoard.entidades.Reserva;

/**
 *
 * @author mathe
 */
public interface IReservaDAO {
    
    public void Adcionar(Reserva ent);
    
    public void Atualizar(Reserva ent);
    
    public void Remover(int id);
    
    public void ObterTodos();
    
    public void ObterPorId(int Id);
    
}
