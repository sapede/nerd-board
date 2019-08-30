package nerdBoard.dao.postgresql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import nerdBoard.dao.ICategoriaDAO;
import nerdBoard.entidades.Categoria;

/**
 *
 * @author mathe
 */
public class CategoriaDAOImpl implements ICategoriaDAO {
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
    
    public void Adicionar(Categoria ent){
        Connection con = createConnection();
        String sql = "INSERT INTO categoria (nome) VALUES ("
                + "'" + ent.getNome() + "'"
                + ");";
        
        try{
            con.createStatement().execute(sql);
            con.close();
        }catch(Exception erro){
            erro.printStackTrace();
        }
    }

    public void Atualizar(Categoria ent) {
        Connection con = createConnection();
        String sql = "update categoria set"
                + " nome = '" + ent.getNome() + "'"
                + " where categoriaid = " + ent.getCategoriaId() + ";";

        try{
            con.createStatement().execute(sql);
            con.close();
        }catch(Exception erro){
            erro.printStackTrace();
        }
    }

    public void Remover(int id) {
        Connection con = createConnection();
        String sql = "delete from categoria where "
                + "categoriaid = " + id + ";";
        
        try{
            con.createStatement().execute(sql);
            con.close();
        }catch(Exception erro){
            erro.printStackTrace();
        }
    }

    public List<Categoria> ObterTodos() {
        try{
            Connection con = createConnection();
            String sql = "select * from categoria";
            
            List<Categoria> categorias = new ArrayList<Categoria>();
            
            ResultSet res = con.createStatement().executeQuery(sql);
            
            while(res.next()){
                Categoria cat = new Categoria();
                cat.setCategoriaId(res.getInt("categoriaid"));
                cat.setNome(res.getString("nome"));
                categorias.add(cat);
            }
            return categorias;
        }catch(Exception erro){
            erro.printStackTrace();
            return null;
        }
    }

    public Categoria ObterPorId(int Id) {
        try{
            Connection con = createConnection();
            String sql = "select * from categoria "
                        + "where categoriaid = " + Id  + ";";
            
            ResultSet res = con.createStatement().executeQuery(sql);
            
            while(res.next()){
                Categoria cat = new Categoria();
                cat.setCategoriaId(res.getInt("categoriaid"));
                cat.setNome(res.getString("nome"));
                return cat;
            }
        }catch(Exception erro){
            erro.printStackTrace();
        }
        return null;
    }

    
    
}
