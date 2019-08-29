/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nerdBoard.entidades;

import java.util.Date;
import java.util.List;


/**
 *
 * @author mathe
 */
public class Reserva {
    private int ReservaId;
    private Date DataRetirada;
    private Date DataEntrega;
    private List<Jogo> Jogos;

    public Reserva(int ReservaId, Date DataRetirada, Date DataEntrega, List<Jogo> Jogos) {
        this.ReservaId = ReservaId;
        this.DataRetirada = DataRetirada;
        this.DataEntrega = DataEntrega;
        this.Jogos = Jogos;
    }

    public Reserva() {
    }
    
    

    public int getReservaId() {
        return ReservaId;
    }

    public void setReservaId(int ReservaId) {
        this.ReservaId = ReservaId;
    }

    public Date getDataRetirada() {
        return DataRetirada;
    }

    public void setDataRetirada(Date DataRetirada) {
        this.DataRetirada = DataRetirada;
    }

    public Date getDataEntrega() {
        return DataEntrega;
    }

    public void setDataEntrega(Date DataEntrega) {
        this.DataEntrega = DataEntrega;
    }

    public List<Jogo> getJogos() {
        return Jogos;
    }

    public void setJogos(List<Jogo> Jogos) {
        this.Jogos = Jogos;
    }
    
    
}
