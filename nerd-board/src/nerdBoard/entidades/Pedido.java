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
public class Pedido {
    private int PedidoId;
    private float Desconto;
    private float Total;
    private Cliente Cliente;
    private List<Jogo> Jogos;

    public Pedido(int PedidoId, float Desconto, float Total, Cliente Cliente, List<Jogo> Jogos) {
        this.PedidoId = PedidoId;
        this.Desconto = Desconto;
        this.Total = Total;
        this.Cliente = Cliente;
        this.Jogos = Jogos;
    }

    public int getPedidoId() {
        return PedidoId;
    }

    public void setPedidoId(int PedidoId) {
        this.PedidoId = PedidoId;
    }

    public float getDesconto() {
        return Desconto;
    }

    public void setDesconto(float Desconto) {
        this.Desconto = Desconto;
    }

    public float getTotal() {
        return Total;
    }

    public void setTotal(float Total) {
        this.Total = Total;
    }

    public Cliente getCliente() {
        return Cliente;
    }

    public void setCliente(Cliente Cliente) {
        this.Cliente = Cliente;
    }

    public List<Jogo> getJogos() {
        return Jogos;
    }

    public void setJogos(List<Jogo> Jogos) {
        this.Jogos = Jogos;
    }
    
    
    
}
