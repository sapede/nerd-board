/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.Date;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import nerdBoard.dao.IPedidoDAO;
import nerdBoard.dao.postgresql.PedidoDAOImpl;
import nerdBoard.entidades.Pedido;


@Path("/Pedido")
public class PedidoController {
    private IPedidoDAO _app = new PedidoDAOImpl();
    
    
    @GET
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Pedido> index(){
        return _app.ObterTodos();
    }
    
    @GET
    @Path("/select/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Pedido select(@PathParam("id") int pk){
        System.out.println("Parametro:"+pk);
        Pedido cat = _app.ObterPorId(pk);
        return cat;
    }
    
    @GET
    @Path("/inserir/{desconto}")
    @Produces(MediaType.APPLICATION_JSON)
    public String inserir(
            @PathParam("desconto") float desconto){
        Pedido ent = new Pedido();
        ent.setDesconto(desconto);
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
    @Path("/atualizar/{id}&{desconto}}")
    @Produces(MediaType.APPLICATION_JSON)
    public String atualizar (
            @PathParam("id") int id,
            @PathParam("desconto") float desconto){
        Pedido ent = _app.ObterPorId(id);
        ent.setDesconto(desconto);
        _app.Atualizar(ent);
        return "deu";
    }
    

}
    
    

