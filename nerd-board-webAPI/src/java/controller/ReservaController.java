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
import nerdBoard.dao.IReservaDAO;
import nerdBoard.dao.postgresql.ReservaDAOImpl;
import nerdBoard.entidades.Reserva;


@Path("/Reserva")
public class ReservaController {
    private IReservaDAO _app = new ReservaDAOImpl();
    
    
    @GET
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Reserva> index(){
        return _app.ObterTodos();
    }
    
    @GET
    @Path("/select/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Reserva select(@PathParam("id") int pk){
        System.out.println("Parametro:"+pk);
        Reserva cat = _app.ObterPorId(pk);
        return cat;
    }
    
    @GET
    @Path("/inserir/{dataretirada}&{dataentrega}")
    @Produces(MediaType.APPLICATION_JSON)
    public String inserir(
            @PathParam("dataretirada") Date dataretirada,
            @PathParam("dataentrega") Date dataentrega){
        Reserva ent = new Reserva();
        ent.setDataEntrega(dataentrega);
        ent.setDataRetirada(dataretirada);
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
    @Path("/atualizar/{id}&{dataretirada}&{dataentrega}")
    @Produces(MediaType.APPLICATION_JSON)
    public String atualizar (
            @PathParam("id") int id,
            @PathParam("dataretirada") Date dataretirada,
            @PathParam("dataentrega") Date dataentrega){
        Reserva ent = _app.ObterPorId(id);
        ent.setDataEntrega(dataentrega);
        ent.setDataRetirada(dataretirada);
        _app.Atualizar(ent);
        return "deu";
    }
    

}
    
    

