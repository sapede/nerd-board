/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nerdBoard.entidades;

import java.util.List;

/**
 *
 * @author mathe
 */
public class Jogo {
    private int JogoId;
    private String Nome;
    private float Preco;
    private String Status;
    private List<Categoria> Categorias;

    public Jogo(int JogoId, String Nome, float Preco, String Status, List<Categoria> Categorias) {
        this.JogoId = JogoId;
        this.Nome = Nome;
        this.Preco = Preco;
        this.Status = Status;
        this.Categorias = Categorias;
    }

    public Jogo() {
    }
    
    

    public int getJogoId() {
        return JogoId;
    }

    public void setJogoId(int JogoId) {
        this.JogoId = JogoId;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String Nome) {
        this.Nome = Nome;
    }

    public float getPreco() {
        return Preco;
    }

    public void setPreco(float Preco) {
        this.Preco = Preco;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String Status) {
        this.Status = Status;
    }

    public List<Categoria> getCategorias() {
        return Categorias;
    }

    public void setCategorias(List<Categoria> Categorias) {
        this.Categorias = Categorias;
    }
    
    
    
    
}
