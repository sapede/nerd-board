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
import nerdBoard.dao.IReservaJogoDAO;
import nerdBoard.entidades.ReservaJogo;

/**
 *
 * @author mathe
 */
public class ReservaJogoDAOImpl implements IReservaJogoDAO{

    private Connection createConnection(){
        Connection connection = null;
        try{
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/nerdboard", "postgres", "1234");
        }catch(Exception erro){
            erro.printStackTrace(); 
        }
        
        return connection;
    }
    
    public void Adicionar(ReservaJogo ent){
        Connection con = createConnection();
        String sql = "INSERT INTO reservajogo (reservaid,jogoid) VALUES ("
                + ent.getReservaId()+ ","
                + ent.getJogoId()
                + ");";
        
        try{
            con.createStatement().execute(sql);
            con.close();
        }catch(Exception erro){
            erro.printStackTrace();
        }
    }

    public void Atualizar(ReservaJogo ent) {
        Connection con = createConnection();
        String sql = "update reservajogo set"
                + " reservaid = " + ent.getReservaId()+ ","
                + " jogoid = " + ent.getJogoId()
                + " where reservajogoid = " + ent.getReservaJogoId() + ";";

        try{
            con.createStatement().execute(sql);
            con.close();
        }catch(Exception erro){
            erro.printStackTrace();
        }
    }

    public void Remover(int id) {
        Connection con = createConnection();
        String sql = "delete from reservajogo where "
                + "reservajogoid = " + id + ";";
        
        try{
            con.createStatement().execute(sql);
            con.close();
        }catch(Exception erro){
            erro.printStackTrace();
        }
    }

    public List<ReservaJogo> ObterTodos() {
        try{
            Connection con = createConnection();
            String sql = "select * from reservajogo";
            
            List<ReservaJogo> categorias = new ArrayList<ReservaJogo>();
            
            ResultSet res = con.createStatement().executeQuery(sql);
            
            while(res.next()){
                ReservaJogo aux = new ReservaJogo();
                aux.setReservaJogoId(res.getInt("reservajogoid"));
                aux.setReservaId(res.getInt("reservaid"));
                aux.setJogoId(res.getInt("jogoid"));
                categorias.add(aux);
            }
            return categorias;
        }catch(Exception erro){
            erro.printStackTrace();
            return null;
        }
    }

    public ReservaJogo ObterPorId(int Id) {
        try{
            Connection con = createConnection();
            String sql = "select * from reservajogo "
                        + "where reservajogoid = " + Id  + ";";
            
            ResultSet res = con.createStatement().executeQuery(sql);
            
            while(res.next()){
                ReservaJogo aux = new ReservaJogo();
                aux.setReservaJogoId(res.getInt("reservajogoid"));
                aux.setReservaId(res.getInt("reservaid"));
                aux.setJogoId(res.getInt("jogoid"));
                return aux;
            }
        }catch(Exception erro){
            erro.printStackTrace();
        }
        return null;
    }
    
}
