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
import nerdBoard.dao.IPedidoJogoDAO;
import nerdBoard.dao.postgresql.PedidoJogoDAOImpl;
import nerdBoard.entidades.PedidoJogo;


@Path("/PedidoJogo")
public class PedidoJogoController {
    private IPedidoJogoDAO _app = new PedidoJogoDAOImpl();
    
    
    @GET
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    public List<PedidoJogo> index(){
        return _app.ObterTodos();
    }
    
    @GET
    @Path("/select/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public PedidoJogo select(@PathParam("id") int pk){
        System.out.println("Parametro:"+pk);
        PedidoJogo cat = _app.ObterPorId(pk);
        return cat;
    }
    
    @GET
    @Path("/inserir/{jogoId}&{PedidoId}")
    @Produces(MediaType.APPLICATION_JSON)
    public String inserir(
            @PathParam("jogoId") int jogoId,
            @PathParam("PedidoId") int PedidoId){
        PedidoJogo ent = new PedidoJogo();
        ent.setPedidoId(PedidoId);
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
    @Path("/atualizar/{PedidoJogoId}{jogoId}&{PedidoId}}")
    @Produces(MediaType.APPLICATION_JSON)
    public String atualizar (
            @PathParam("PedidoJogoId") int PedidoJogoId,
            @PathParam("jogoId") int jogoId,
            @PathParam("PedidoId") int PedidoId){
        PedidoJogo ent = _app.ObterPorId(PedidoJogoId);
        ent.setPedidoId(PedidoId);
        ent.setJogoId(jogoId);
        _app.Atualizar(ent);
        return "deu";
    }
    

}
    
    

