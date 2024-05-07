package com.uiteco.OfCuocThiPanel.connectDataBase;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import static com.uiteco.database.ConnectionManager.getConnection;

public class DatabaseConnection {
    public DatabaseConnection() {}
    
    public String[] getAllTags(){ //retrieve tags data in TAG_BAIDANG table
        try{
            
            conn = getConnection(); //get connection to database
            stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
               ResultSet.CONCUR_READ_ONLY);
            query = "SELECT * FROM TAG_NAMES";
            rset = stmt.executeQuery(query); 
        
            List<Object> tags = new ArrayList<>(); //contains string values obtained from a database
            while (rset.next()) {
                tags.add(rset.getString("TAG")); 
            }
            return tags.toArray(String[]::new); //String[]::new is a method reference to the constructor of the String[] array, 
                                                //which takes no arguments and returns a new String array
            
        }catch(SQLException e){
            return new String[0];
        }
    }

    Connection conn;
    Statement stmt;
    ResultSet rset;
    String query;
}
