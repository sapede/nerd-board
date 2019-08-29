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
import nerdBoard.dao.IClienteDAO;
import nerdBoard.entidades.Cliente;

/**
 *
 * @author mathe
 */
public class ClienteDAOImpl implements IClienteDAO{

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
    
    public void Adicionar(Cliente ent){
        Connection con = createConnection();
        String sql = "INSERT INTO cliente (nome,endereco,telefone) VALUES ("
                + "'" + ent.getNome() + "'"
                + "'" + ent.getEndereco() + "'"
                + "'" + ent.getTelefone() + "'"
                + ");";
        
        try{
            con.createStatement().execute(sql);
            con.close();
        }catch(Exception erro){
            erro.printStackTrace();
        }
    }

    public void Atualizar(Cliente ent) {
        Connection con = createConnection();
        String sql = "update cliente set"
                + " nome = '" + ent.getNome() + "',"
                + " endereco = '" + ent.getEndereco() + "',"
                + " telefone = '" + ent.getTelefone() + "'"
                + " where clienteid = " + ent.getClienteId() + ";";

        try{
            con.createStatement().execute(sql);
            con.close();
        }catch(Exception erro){
            erro.printStackTrace();
        }
    }

    public void Remover(int id) {
        Connection con = createConnection();
        String sql = "delete from cliente where "
                + "clienteid = " + id + ";";
        
        try{
            con.createStatement().execute(sql);
            con.close();
        }catch(Exception erro){
            erro.printStackTrace();
        }
    }

    public List<Cliente> ObterTodos() {
        try{
            Connection con = createConnection();
            String sql = "select * from cliente";
            
            List<Cliente> categorias = new ArrayList<Cliente>();
            
            ResultSet res = con.createStatement().executeQuery(sql);
            
            while(res.next()){
                Cliente aux = new Cliente();
                aux.setClienteId(res.getInt("clienteid"));
                aux.setNome(res.getString("nome"));
                aux.setEndereco(res.getString("endereco"));
                aux.setTelefone(res.getString("telefone"));
                categorias.add(aux);
            }
            return categorias;
        }catch(Exception erro){
            erro.printStackTrace();
            return null;
        }
    }

    public Cliente ObterPorId(int Id) {
        try{
            Connection con = createConnection();
            String sql = "select * from cliente "
                        + "where clienteid = " + Id  + ";";
            
            ResultSet res = con.createStatement().executeQuery(sql);
            
            while(res.next()){
                Cliente aux = new Cliente();
                aux.setClienteId(res.getInt("clienteid"));
                aux.setNome(res.getString("nome"));
                aux.setEndereco(res.getString("endereco"));
                aux.setTelefone(res.getString("telefone"));
                return aux;
            }
        }catch(Exception erro){
            erro.printStackTrace();
        }
        return null;
    }

    
}
