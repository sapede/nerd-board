/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nerdBoard.dao;

import java.util.List;
import nerdBoard.entidades.Categoria;

/**
 *
 * @author mathe
 */
public interface ICategoriaDAO {
    
    public void Adcionar(Categoria ent);
    
    public void Atualizar(Categoria ent);
    
    public void Remover(int id);
    
    public void ObterTodos();
    
    public void ObterPorId(int Id);
    
    
}
