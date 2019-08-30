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
import nerdBoard.dao.IReservaJogoDAO;
import nerdBoard.dao.postgresql.ReservaJogoDAOImpl;
import nerdBoard.entidades.ReservaJogo;


@Path("/ReservaJogo")
public class ReservaJogoController {
    private IReservaJogoDAO _app = new ReservaJogoDAOImpl();
    
    
    @GET
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    public List<ReservaJogo> index(){
        return _app.ObterTodos();
    }
    
    @GET
    @Path("/select/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public ReservaJogo select(@PathParam("id") int pk){
        System.out.println("Parametro:"+pk);
        ReservaJogo cat = _app.ObterPorId(pk);
        return cat;
    }
    
    @GET
    @Path("/inserir/{jogoId}&{ReservaId}")
    @Produces(MediaType.APPLICATION_JSON)
    public String inserir(
            @PathParam("jogoId") int jogoId,
            @PathParam("ReservaId") int ReservaId){
        ReservaJogo ent = new ReservaJogo();
        ent.setReservaId(ReservaId);
        ent.setJogoId(jogoId);
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
    @Path("/atualizar/{ReservaJogoId}{jogoId}&{ReservaId}}")
    @Produces(MediaType.APPLICATION_JSON)
    public String atualizar (
            @PathParam("ReservaJogoId") int ReservaJogoId,
            @PathParam("jogoId") int jogoId,
            @PathParam("ReservaId") int ReservaId){
        ReservaJogo ent = _app.ObterPorId(ReservaJogoId);
        ent.setReservaId(ReservaId);
        ent.setJogoId(jogoId);
        _app.Atualizar(ent);
        return "deu";
    }
    

}
    
    

