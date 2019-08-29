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
import nerdBoard.dao.IPedidoDAO;
import nerdBoard.entidades.Pedido;

/**
 *
 * @author mathe
 */
public class PedidoDAOImpl implements IPedidoDAO{

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
    
    public void Adicionar(Pedido ent){
        Connection con = createConnection();
        String sql = "INSERT INTO pedido (desconto) VALUES ("
                + ent.getDesconto()
                + ");";
        
        try{
            con.createStatement().execute(sql);
            con.close();
        }catch(Exception erro){
            erro.printStackTrace();
        }
    }

    public void Atualizar(Pedido ent) {
        Connection con = createConnection();
        String sql = "update pedido set"
                + " desconto = " + ent.getDesconto()
                + " where pedidoid = " + ent.getPedidoId() + ";";

        try{
            con.createStatement().execute(sql);
            con.close();
        }catch(Exception erro){
            erro.printStackTrace();
        }
    }

    public void Remover(int id) {
        Connection con = createConnection();
        String sql = "delete from pedido where "
                + "pedidoid = " + id + ";";
        
        try{
            con.createStatement().execute(sql);
            con.close();
        }catch(Exception erro){
            erro.printStackTrace();
        }
    }

    public List<Pedido> ObterTodos() {
        try{
            Connection con = createConnection();
            String sql = "select * from pedido";
            
            List<Pedido> categorias = new ArrayList<Pedido>();
            
            ResultSet res = con.createStatement().executeQuery(sql);
            
            while(res.next()){
                Pedido aux = new Pedido();
                aux.setPedidoId(res.getInt("pedidoid"));
                aux.setDesconto(res.getFloat("desconto"));
                categorias.add(aux);
            }
            return categorias;
        }catch(Exception erro){
            erro.printStackTrace();
            return null;
        }
    }

    public Pedido ObterPorId(int Id) {
        try{
            Connection con = createConnection();
            String sql = "select * from Pedido "
                        + "where Pedidoid = " + Id  + ";";
            
            ResultSet res = con.createStatement().executeQuery(sql);
            
            while(res.next()){
                Pedido aux = new Pedido();
                aux.setPedidoId(res.getInt("pedidoid"));
                aux.setDesconto(res.getFloat("desconto"));
                return aux;
            }
        }catch(Exception erro){
            erro.printStackTrace();
        }
        return null;
    }
}
