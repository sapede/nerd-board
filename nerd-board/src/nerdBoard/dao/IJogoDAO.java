/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nerdBoard.dao;

import nerdBoard.entidades.Jogo;

/**
 *
 * @author mathe
 */
public interface IJogoDAO {
    
    public void Adcionar(Jogo ent);
    
    public void Atualizar(Jogo ent);
    
    public void Remover(int id);
    
    public void ObterTodos();
    
    public void ObterPorId(int Id);
    
}
