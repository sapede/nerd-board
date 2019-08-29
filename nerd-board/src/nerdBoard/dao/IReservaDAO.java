/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nerdBoard.dao;

import java.util.List;
import nerdBoard.entidades.Reserva;

/**
 *
 * @author mathe
 */
public interface IReservaDAO {
    
    public void Adicionar(Reserva ent);
    
    public void Atualizar(Reserva ent);
    
    public void Remover(int id);
    
    public List<Reserva> ObterTodos();
    
    public Reserva ObterPorId(int Id);
    
}
