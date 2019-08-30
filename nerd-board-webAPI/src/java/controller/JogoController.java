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
import nerdBoard.dao.IJogoDAO;
import nerdBoard.dao.postgresql.JogoDAOImpl;
import nerdBoard.entidades.Jogo;


@Path("/jogo")
public class JogoController {
    private IJogoDAO _app = new JogoDAOImpl();
    
    
    @GET
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Jogo> index(){
        return _app.ObterTodos();
    }
    
    @GET
    @Path("/select/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Jogo select(@PathParam("id") int pk){
        System.out.println("Parametro:"+pk);
        Jogo cat = _app.ObterPorId(pk);
        return cat;
    }
    
    @GET
    @Path("/inserir/{nome}&{preco}&{status}")
    @Produces(MediaType.APPLICATION_JSON)
    public String inserir(
            @PathParam("nome") String nome,
            @PathParam("preco") float preco,
            @PathParam("status") String status){
        Jogo ent = new Jogo();
        ent.setNome(nome);
        ent.setPreco(preco);
        ent.setStatus(status);
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
            @PathParam("preco") float preco,
            @PathParam("status") String status){
        Jogo ent = _app.ObterPorId(id);
        ent.setNome(nome);
        ent.setPreco(preco);
        ent.setStatus(status);
        _app.Atualizar(ent);
        return "deu";
    }
    

}
    
    

