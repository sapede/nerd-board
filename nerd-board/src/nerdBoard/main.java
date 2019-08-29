package nerdBoard;

import java.util.Scanner;
import nerdBoard.dao.ICategoriaDAO;
import nerdBoard.dao.postgresql.CategoriaDAOImpl;
import nerdBoard.entidades.Categoria;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author mathe
 */
public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ICategoriaDAO cat = new CategoriaDAOImpl();
        
         Scanner t = new Scanner(System.in);
         
         String nome = t.nextLine();
         
         Categoria ent =  new Categoria();
         ent.setNome(nome);
         
         cat.Adicionar(ent);
         
         System.out.println("deu");

    }
    
}
