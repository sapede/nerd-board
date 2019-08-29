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
public class Cliente {
    private int ClienteId;
    private String Nome;
    private String Endereco;
    private String Telefone;

    public Cliente(int ClienteId, String Nome, String Endereco, String Telefone) {
        this.ClienteId = ClienteId;
        this.Nome = Nome;
        this.Endereco = Endereco;
        this.Telefone = Telefone;
    }

  

    public Cliente() {
    }

    public String getTelefone() {
        return Telefone;
    }

    public void setTelefone(String Telefone) {
        this.Telefone = Telefone;
    }
    

    public int getClienteId() {
        return ClienteId;
    }

    public void setClienteId(int ClienteId) {
        this.ClienteId = ClienteId;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String Nome) {
        this.Nome = Nome;
    }

    public String getEndereco() {
        return Endereco;
    }

    public void setEndereco(String Endereco) {
        this.Endereco = Endereco;
    }

    
    
}
