/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.nfactory.crudmysql;

import fr.nfactory.crudmysql.beans.Alcool;
import fr.nfactory.crudmysql.dao.DaoFactory;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ludivine
 */
public class Launcher {
    
    //main : le point d'entrée de l'application
    // ... entre 0 et n valeurs qui seront récupérées dans un tableau appel => main("toto","zozo")
    // ... peut le remplace par String[] appel => main(["toto","zozo"])
    public static void main(String... args){
        try {
            ArrayList<Alcool> alcools = DaoFactory.getAlcoolDao().getAll();
            alcools.forEach(System.out::println);
            for(Alcool a : alcools){
                System.out.println(a);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Launcher.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
