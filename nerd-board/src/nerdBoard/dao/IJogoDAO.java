/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nerdBoard.dao;

import java.util.List;
import nerdBoard.entidades.Jogo;

/**
 *
 * @author mathe
 */
public interface IJogoDAO {
    
    public void Adicionar(Jogo ent);
    
    public void Atualizar(Jogo ent);
    
    public void Remover(int id);
    
    public List<Jogo> ObterTodos();
    
    public Jogo ObterPorId(int Id);
    
}
