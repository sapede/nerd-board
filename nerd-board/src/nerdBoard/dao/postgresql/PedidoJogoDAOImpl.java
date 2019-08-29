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
import nerdBoard.dao.IPedidoJogoDAO;
import nerdBoard.entidades.PedidoJogo;

/**
 *
 * @author mathe
 */
public class PedidoJogoDAOImpl implements IPedidoJogoDAO{

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
    
    public void Adicionar(PedidoJogo ent){
        Connection con = createConnection();
        String sql = "INSERT INTO pedidoJogo (pedidoid,jogoid) VALUES ("
                + ent.getPedidoId()+ ","
                + ent.getJogoId()
                + ");";
        
        try{
            con.createStatement().execute(sql);
            con.close();
        }catch(Exception erro){
            erro.printStackTrace();
        }
    }

    public void Atualizar(PedidoJogo ent) {
        Connection con = createConnection();
        String sql = "update pedidojogo set"
                + " pedidoid = '" + ent.getPedidoId()+ "',"
                + " jogoid = '" + ent.getJogoId()+ "'"
                + " where pedidojogoid = " + ent.getPedidoJogoId() + ";";

        try{
            con.createStatement().execute(sql);
            con.close();
        }catch(Exception erro){
            erro.printStackTrace();
        }
    }

    public void Remover(int id) {
        Connection con = createConnection();
        String sql = "delete from pedidojogo where "
                + "pedidojogoid = " + id + ";";
        
        try{
            con.createStatement().execute(sql);
            con.close();
        }catch(Exception erro){
            erro.printStackTrace();
        }
    }

    public List<PedidoJogo> ObterTodos() {
        try{
            Connection con = createConnection();
            String sql = "select * from pedidojogo";
            
            List<PedidoJogo> categorias = new ArrayList<PedidoJogo>();
            
            ResultSet res = con.createStatement().executeQuery(sql);
            
            while(res.next()){
                PedidoJogo aux = new PedidoJogo();
                aux.setPedidoJogoId(res.getInt("pedidojogoid"));
                aux.setPedidoId(res.getInt("pedidoid"));
                aux.setJogoId(res.getInt("jogoid"));
                categorias.add(aux);
            }
            return categorias;
        }catch(Exception erro){
            erro.printStackTrace();
            return null;
        }
    }

    public PedidoJogo ObterPorId(int Id) {
        try{
            Connection con = createConnection();
            String sql = "select * from PedidoJogo "
                        + "where PedidoJogoid = " + Id  + ";";
            
            ResultSet res = con.createStatement().executeQuery(sql);
            
            while(res.next()){
                PedidoJogo aux = new PedidoJogo();
                aux.setPedidoJogoId(res.getInt("pedidojogoid"));
                aux.setPedidoId(res.getInt("pedidoid"));
                aux.setJogoId(res.getInt("jogoid"));
                return aux;
            }
        }catch(Exception erro){
            erro.printStackTrace();
        }
        return null;
    }
    
    
    
}
