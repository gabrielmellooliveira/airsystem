package DAO;

import JDBC.Connection_Factory;
import Model.Manufacturer;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author Gabriel
 */
public class Manufacturer_DAO {
    
    public static Connection connection_DB;
    
    public Manufacturer_DAO()
    {
        Manufacturer_DAO.connection_DB = Connection_Factory.getConnection();
    }
        
    public void insert_manufacturer(Manufacturer manufacturer) throws SQLException{
       
       Connection c = Connection_Factory.getConnection();
       String sql = "INSERT INTO Manufacturers(manufacturer, focus, country_origin, phone, email)" + 
                    " VALUES (?, ?, ?, ?, ?)"; 
        
       try{
           
           PreparedStatement stat = c.prepareStatement(sql);
           
           stat.setString(1, manufacturer.getManufacturer());
           stat.setString(2, manufacturer.getFocus());
           stat.setString(3, manufacturer.getCountry_origin());
           stat.setString(4, manufacturer.getPhone());
           stat.setString(5, manufacturer.getEmail());
           
           stat.execute();
           
       }catch(SQLException ex){
           System.out.println(ex.getMessage());
       }finally{
           c.close();
       }
       
    }
    
    public ObservableList<Manufacturer> select_manufacturer()
    {
        
        ObservableList<Manufacturer> Manufacturers = FXCollections.observableArrayList();
        
        try{
      
            PreparedStatement stmt = this.connection_DB.prepareStatement("SELECT * FROM Manufacturers");
            
            ResultSet rs = stmt.executeQuery();
                        
            while(rs.next()){
 
                Manufacturer manufacturer = new Manufacturer(
                    rs.getInt("manufacturer"),
                    rs.getString("manufacturer"),
                    rs.getString("focus"),
                    rs.getString("country_origin"),
                    rs.getString("phone"),
                    rs.getString("email")
                );
                
                Manufacturers.add(manufacturer);
            }
            
            stmt.executeQuery();
            
        }catch(SQLException ex){
            throw new RuntimeException(ex);
        }finally{        
            return Manufacturers;
        }
        
    }
    
}
