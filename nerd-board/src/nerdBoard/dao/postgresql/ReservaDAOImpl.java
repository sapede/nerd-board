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
import nerdBoard.dao.IReservaDAO;
import nerdBoard.entidades.Reserva;

/**
 *
 * @author mathe
 */
public class ReservaDAOImpl implements IReservaDAO{

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
    
    public void Adicionar(Reserva ent){
        Connection con = createConnection();
        String sql = "INSERT INTO reserva (dataentrega,dataretirada) VALUES ("
                + "'" + ent.getDataEntrega()+ "',"
                + "'" + ent.getDataRetirada()+ "'"
                + ");";
        
        try{
            con.createStatement().execute(sql);
            con.close();
        }catch(Exception erro){
            erro.printStackTrace();
        }
    }

    public void Atualizar(Reserva ent) {
        Connection con = createConnection();
        String sql = "update reserva set"
                + " dataentrega = '" + ent.getDataEntrega()+ "',"
                + " dataretirada = '" + ent.getDataRetirada()+ "'"
                + " where Reservaid = " + ent.getReservaId() + ";";

        try{
            con.createStatement().execute(sql);
            con.close();
        }catch(Exception erro){
            erro.printStackTrace();
        }
    }

    public void Remover(int id) {
        Connection con = createConnection();
        String sql = "delete from reserva where "
                + "reservaid = " + id + ";";
        
        try{
            con.createStatement().execute(sql);
            con.close();
        }catch(Exception erro){
            erro.printStackTrace();
        }
    }

    public List<Reserva> ObterTodos() {
        try{
            Connection con = createConnection();
            String sql = "select * from reserva";
            
            List<Reserva> categorias = new ArrayList<Reserva>();
            
            ResultSet res = con.createStatement().executeQuery(sql);
            
            while(res.next()){
                Reserva aux = new Reserva();
                aux.setReservaId(res.getInt("reservaid"));
                aux.setDataEntrega(res.getDate("dataentrega"));
                aux.setDataRetirada(res.getDate("dataretirada"));
                categorias.add(aux);
            }
            return categorias;
        }catch(Exception erro){
            erro.printStackTrace();
            return null;
        }
    }

    public Reserva ObterPorId(int Id) {
        try{
            Connection con = createConnection();
            String sql = "select * from Reserva "
                        + "where Reservaid = " + Id  + ";";
            
            ResultSet res = con.createStatement().executeQuery(sql);
            
            while(res.next()){
                Reserva aux = new Reserva();
                aux.setReservaId(res.getInt("reservaid"));
                aux.setDataEntrega(res.getDate("dataentrega"));
                aux.setDataRetirada(res.getDate("dataretirada"));
                return aux;
            }
        }catch(Exception erro){
            erro.printStackTrace();
        }
        return null;
    }
    
    
}
