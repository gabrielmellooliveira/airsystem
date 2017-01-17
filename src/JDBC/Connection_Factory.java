package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author User
 */
public class Connection_Factory {
   
    public static Connection getConnection(){
        
        String database = "airsystem";
        String user     = "postgres";
        String password = "gabriel";
        
        Connection connect = null;
        
        try {
            
            connect = DriverManager.getConnection("jdbc:postgresql://localhost/" + database, user, password);
            
        } catch (Exception e) {
        }finally{
            return connect;
        }
  
    }
    
}
