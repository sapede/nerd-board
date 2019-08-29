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
public class Categoria {
    private int CategoriaId;
    private String Nome;
    private List<Categoria> Jogos;

    public Categoria(int idCat, String nome, List<Categoria> jogos) {
        this.CategoriaId = idCat;
        this.Nome = nome;
        this.Jogos = jogos;
    }

    public Categoria() {
    }

    public int getCategoriaId() {
        return CategoriaId;
    }

    public void setCategoriaId(int CategoriaId) {
        this.CategoriaId = CategoriaId;
    }
    



    public String getNome() {
        return Nome;
    }

    public void setNome(String nome) {
        this.Nome = nome;
    }

    public List<Categoria> getJogos() {
        return Jogos;
    }

    public void setJogos(List<Categoria> Jogos) {
        this.Jogos = Jogos;
    }

   
    
}
