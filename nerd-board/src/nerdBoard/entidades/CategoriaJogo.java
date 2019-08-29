/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nerdBoard.entidades;

/**
 *
 * @author mathe
 */
public class CategoriaJogo {
    private int CategoriaJogoId;
    private int CategoriaId;
    private int JogoId;

    public CategoriaJogo(int CategoriaJogoId, int CategoriaId, int JogoId) {
        this.CategoriaJogoId = CategoriaJogoId;
        this.CategoriaId = CategoriaId;
        this.JogoId = JogoId;
    }

    public int getCategoriaJogoId() {
        return CategoriaJogoId;
    }

    public void setCategoriaJogoId(int CategoriaJogoId) {
        this.CategoriaJogoId = CategoriaJogoId;
    }

    public int getCategoriaId() {
        return CategoriaId;
    }

    public void setCategoriaId(int CategoriaId) {
        this.CategoriaId = CategoriaId;
    }

    public int getJogoId() {
        return JogoId;
    }

    public void setJogoId(int JogoId) {
        this.JogoId = JogoId;
    }
    
    
}
