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
import nerdBoard.dao.ICategoriaJogoDAO;
import nerdBoard.dao.postgresql.CategoriaJogoDAOImpl;
import nerdBoard.entidades.CategoriaJogo;


@Path("/categoriajogo")
public class CategoriaJogoController {
    private ICategoriaJogoDAO _app = new CategoriaJogoDAOImpl();
    
    
    @GET
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    public List<CategoriaJogo> index(){
        return _app.ObterTodos();
    }
    
    @GET
    @Path("/select/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public CategoriaJogo select(@PathParam("id") int pk){
        System.out.println("Parametro:"+pk);
        CategoriaJogo cat = _app.ObterPorId(pk);
        return cat;
    }
    
    @GET
    @Path("/inserir/{jogoId}&{categoriaId}")
    @Produces(MediaType.APPLICATION_JSON)
    public String inserir(
            @PathParam("jogoId") int jogoId,
            @PathParam("categoriaId") int categoriaId){
        CategoriaJogo ent = new CategoriaJogo();
        ent.setCategoriaId(categoriaId);
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
    @Path("/atualizar/{categoriaJogoId}{jogoId}&{categoriaId}}")
    @Produces(MediaType.APPLICATION_JSON)
    public String atualizar (
            @PathParam("categoriaJogoId") int categoriaJogoId,
            @PathParam("jogoId") int jogoId,
            @PathParam("categoriaId") int categoriaId){
        CategoriaJogo ent = _app.ObterPorId(categoriaJogoId);
        ent.setCategoriaId(categoriaId);
        ent.setJogoId(jogoId);
        _app.Atualizar(ent);
        return "deu";
    }
    

}
    
    

