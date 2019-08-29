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
public class ReservaJogo {
    private int ReservaJogoId;
    private int ReservaId;
    private int JogoId;

    public ReservaJogo(int ReservaJogoId, int ReservaId, int JogoId) {
        this.ReservaJogoId = ReservaJogoId;
        this.ReservaId = ReservaId;
        this.JogoId = JogoId;
    }

    public int getReservaJogoId() {
        return ReservaJogoId;
    }

    public void setReservaJogoId(int ReservaJogoId) {
        this.ReservaJogoId = ReservaJogoId;
    }

    public int getReservaId() {
        return ReservaId;
    }

    public void setReservaId(int ReservaId) {
        this.ReservaId = ReservaId;
    }

    public int getJogoId() {
        return JogoId;
    }

    public void setJogoId(int JogoId) {
        this.JogoId = JogoId;
    }
    
    
}
