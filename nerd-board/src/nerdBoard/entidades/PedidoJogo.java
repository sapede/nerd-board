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
public class PedidoJogo {
    private int PedidoJogoId;
    private int PedidoId;
    private int JogoId;

    public PedidoJogo(int PedidoJogoId, int PedidoId, int JogoId) {
        this.PedidoJogoId = PedidoJogoId;
        this.PedidoId = PedidoId;
        this.JogoId = JogoId;
    }

    public PedidoJogo() {
    }

    
    
    public int getPedidoJogoId() {
        return PedidoJogoId;
    }

    public void setPedidoJogoId(int PedidoJogoId) {
        this.PedidoJogoId = PedidoJogoId;
    }

    public int getPedidoId() {
        return PedidoId;
    }

    public void setPedidoId(int PedidoId) {
        this.PedidoId = PedidoId;
    }

    public int getJogoId() {
        return JogoId;
    }

    public void setJogoId(int JogoId) {
        this.JogoId = JogoId;
    }

    
    
}
