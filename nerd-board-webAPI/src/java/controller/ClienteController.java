/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import nerdBoard.dao.IClienteDAO;
import nerdBoard.dao.postgresql.ClienteDAOImpl;
import nerdBoard.entidades.Cliente;



@Path("/cliente")
public class ClienteController {
    private IClienteDAO _app = new ClienteDAOImpl();
    
    
    @GET
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Cliente> index(){
        return _app.ObterTodos();
    }
    
    @GET
    @Path("/select/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Cliente select(@PathParam("id") int pk){
        System.out.println("Parametro:"+pk);
        Cliente cat = _app.ObterPorId(pk);
        return cat;
    }
    
    @GET
    @Path("/inserir/{nome}&{endereco}&{telefone}")
    @Produces(MediaType.APPLICATION_JSON)
    public String inserir(
            @PathParam("nome") String nome,
            @PathParam("endereco") String endereco,
            @PathParam("telefone") String telefone){
        Cliente ent = new Cliente();
        ent.setNome(nome);
        ent.setEndereco(endereco);
        ent.setTelefone(telefone);
        _app.Adicionar(ent);
        return "deu";
    }
    
    @GET
    @Path("/remover/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public String remover(@PathParam("id") int id){
        _app.Remover(id);
        return "deu";
    }
    
    
    @GET
    @Path("/atualizar/{id}&{nome}&{endereco}&{telefone}")
    @Produces(MediaType.APPLICATION_JSON)
    public String atualizar (
            @PathParam("id") int id,
            @PathParam("nome") String nome,
            @PathParam("endereco") String endereco,
            @PathParam("telefone") String telefone){
        Cliente ent = _app.ObterPorId(id);
        ent.setNome(nome);
        ent.setEndereco(endereco);
        ent.setTelefone(telefone);
        _app.Atualizar(ent);
        return "deu";
    }
    

}
    
    

