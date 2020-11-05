/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.nfactory.crudmysql.dao.impl;

import fr.nfactory.crudmysql.beans.Alcool;
import fr.nfactory.crudmysql.dao.AlcoolDao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author ludivine
 */
public class AlcoolDaoJdbc extends JdbcDao implements AlcoolDao{
    
    public AlcoolDaoJdbc() throws SQLException{
        super();
    }

    @Override
    public void add(Alcool alcool) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Alcool> getAll() {
        ArrayList<Alcool> alcools = new ArrayList<>();
        try{
            String sql = "SELECT * FROM alcools";
            PreparedStatement ps = getConnection().prepareCall(sql);
            ResultSet rs = ps.executeQuery();
            // on va parcourir les lignes de la table "sql' renvoyée
            while(rs.next()){
                // transformer la ligne sql en un object java
                alcools.add(transformSqlToAlcool(rs));
            }
        } catch (SQLException se){
            // affiche l'erreur en console
            se.printStackTrace();
        } catch (Exception e){
            e.printStackTrace();
        }
        return alcools;
    }

    @Override
    public Alcool get(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    private Alcool transformSqlToAlcool(ResultSet rs) throws SQLException{
        Alcool alcool = new Alcool();
        alcool.setId(rs.getInt("id"));
        alcool.setName(rs.getString("name"));
        alcool.setDegre(rs.getDouble("degre"));
        alcool.setVolume(rs.getDouble("volume"));
        return alcool;
    }
    
}
