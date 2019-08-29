/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nerdBoard.dao;

import java.util.List;
import nerdBoard.entidades.CategoriaJogo;

/**
 *
 * @author mathe
 */
public interface ICategoriaJogoDAO {
    
    public void Adicionar(CategoriaJogo ent);
    
    public void Atualizar(CategoriaJogo ent);
    
    public void Remover(int id);
    
    public List<CategoriaJogo> ObterTodos();
    
    public CategoriaJogo ObterPorId(int Id);
}
