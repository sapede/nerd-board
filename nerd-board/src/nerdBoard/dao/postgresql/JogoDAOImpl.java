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
import nerdBoard.dao.IJogoDAO;
import nerdBoard.entidades.Jogo;

/**
 *
 * @author mathe
 */
public class JogoDAOImpl implements IJogoDAO{

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
    
    public void Adicionar(Jogo ent){
        Connection con = createConnection();
        String sql = "INSERT INTO jogo (nome,preco,status) VALUES ("
                + "'" + ent.getNome() + "',"
                + ent.getPreco() + ","
                + "'" + ent.getStatus() + "'"
                + ");";
        
        try{
            con.createStatement().execute(sql);
            con.close();
        }catch(Exception erro){
            erro.printStackTrace();
        }
    }

    public void Atualizar(Jogo ent) {
        Connection con = createConnection();
        String sql = "update Jogo set"
                + " nome = '" + ent.getNome() + "',"
                + " preco = " + ent.getPreco() + ","
                + " status = '" + ent.getStatus() + "'"
                + " where jogoid = " + ent.getJogoId() + ";";

        try{
            con.createStatement().execute(sql);
            con.close();
        }catch(Exception erro){
            erro.printStackTrace();
        }
    }

    public void Remover(int id) {
        Connection con = createConnection();
        String sql = "delete from jogo where "
                + "jogoid = " + id + ";";
        
        try{
            con.createStatement().execute(sql);
            con.close();
        }catch(Exception erro){
            erro.printStackTrace();
        }
    }

    public List<Jogo> ObterTodos() {
        try{
            Connection con = createConnection();
            String sql = "select * from jogo";
            
            List<Jogo> categorias = new ArrayList<Jogo>();
            
            ResultSet res = con.createStatement().executeQuery(sql);
            
            while(res.next()){
                Jogo aux = new Jogo();
                aux.setJogoId(res.getInt("jogoid"));
                aux.setNome(res.getString("nome"));
                aux.setPreco(res.getFloat("preco"));
                aux.setStatus(res.getString("status"));
                categorias.add(aux);
            }
            return categorias;
        }catch(Exception erro){
            erro.printStackTrace();
            return null;
        }
    }

    public Jogo ObterPorId(int Id) {
        try{
            Connection con = createConnection();
            String sql = "select * from jogo "
                        + "where jogoid = " + Id  + ";";
            
            ResultSet res = con.createStatement().executeQuery(sql);
            
            while(res.next()){
                Jogo aux = new Jogo();
                aux.setJogoId(res.getInt("jogoid"));
                aux.setNome(res.getString("nome"));
                aux.setPreco(res.getFloat("preco"));
                aux.setStatus(res.getString("status"));
                return aux;
            }
        }catch(Exception erro){
            erro.printStackTrace();
        }
        return null;
    }
 
    
}
