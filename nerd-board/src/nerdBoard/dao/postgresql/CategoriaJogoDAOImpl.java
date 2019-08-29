/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nerdBoard.dao.postgresql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import nerdBoard.dao.ICategoriaJogoDAO;
import nerdBoard.entidades.CategoriaJogo;

/**
 *
 * @author mathe
 */
public class CategoriaJogoDAOImpl implements ICategoriaJogoDAO {

   private Connection createConnection(){
        Connection connection = null;
        try{
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "1234");
        }catch(Exception erro){
            erro.printStackTrace(); 
        }
        
        return connection;
    }
    
    public void Adicionar(CategoriaJogo ent){
        Connection con = createConnection();
        String sql = "INSERT INTO categoriajogo (categoriaid,jogoid) VALUES ("
                + ent.getCategoriaId() + "," +
                + ent.getJogoId()
                + ");";
        
        try{
            con.createStatement().execute(sql);
            con.close();
        }catch(Exception erro){
            erro.printStackTrace();
        }
    }

    public void Atualizar(CategoriaJogo ent) {
        Connection con = createConnection();
        String sql = "update categoriajogo set"
                + " jogoid = " + ent.getJogoId()
                + " where categoriaid = " + ent.getCategoriaJogoId() + ";";

        try{
            con.createStatement().execute(sql);
            con.close();
        }catch(Exception erro){
            erro.printStackTrace();
        }
    }

    public void Remover(int id) {
        Connection con = createConnection();
        String sql = "delete from categoriajogo where "
                + "categoriajogoid = " + id + ";";
        
        try{
            con.createStatement().execute(sql);
            con.close();
        }catch(Exception erro){
            erro.printStackTrace();
        }
    }

    public List<CategoriaJogo> ObterTodos() {
        try{
            Connection con = createConnection();
            String sql = "select * from categoria";
            
            List<CategoriaJogo> categorias = new ArrayList<CategoriaJogo>();
            
            ResultSet res = con.createStatement().executeQuery(sql);
            
            while(res.next()){
                CategoriaJogo aux = new CategoriaJogo();
                aux.setCategoriaJogoId(res.getInt("categoriajogoid"));
                aux.setCategoriaId(res.getInt("categoriaid"));
                aux.setJogoId(res.getInt("jogoid"));
                categorias.add(aux);
            }
            return categorias;
        }catch(Exception erro){
            erro.printStackTrace();
            return null;
        }
    }

    public CategoriaJogo ObterPorId(int Id) {
        try{
            Connection con = createConnection();
            String sql = "select * from categoriajogo "
                        + "where categoriaid = " + Id  + ";";
            
            ResultSet res = con.createStatement().executeQuery(sql);
            
            while(res.next()){
                CategoriaJogo aux = new CategoriaJogo();
                aux.setCategoriaJogoId(res.getInt("categoriajogoid"));
                aux.setCategoriaId(res.getInt("categoriaid"));
                aux.setJogoId(res.getInt("jogoid"));
                return aux;
            }
        }catch(Exception erro){
            erro.printStackTrace();
        }
        return null;
    }

  
}
