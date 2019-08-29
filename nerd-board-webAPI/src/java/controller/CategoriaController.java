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
import nerdBoard.dao.ICategoriaDAO;
import nerdBoard.dao.postgresql.CategoriaDAOImpl;
import nerdBoard.entidades.Categoria;



@Path("/categoria")
public class CategoriaController {
    private ICategoriaDAO _app = new CategoriaDAOImpl();
    
    
    @GET
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Categoria> index(){
        return _app.ObterTodos();
    }
    
    @GET
    @Path("/select/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Categoria select(@PathParam("id") int pk){
        System.out.println("Parametro:"+pk);
        Categoria cat = _app.ObterPorId(pk);
        return cat;
    }
    

}
    
    

