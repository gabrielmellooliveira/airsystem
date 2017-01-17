package DAO;

import JDBC.Connection_Factory;
import Model.Model;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author Gabriel
 */
public class Model_DAO {
    
    public static Connection connection_DB;
    
    public Model_DAO()
    {
        Model_DAO.connection_DB = Connection_Factory.getConnection();
    }
        
    public void insert_model(Model model) throws SQLException{
       
       Connection c = Connection_Factory.getConnection();
       String sql = "INSERT INTO Models(model, number_seats, origin, fabrication, turbines)" + 
                    " VALUES (?, ?, ?, ?, ?)"; 
        
       try{
           
           PreparedStatement stat = c.prepareStatement(sql);
           
           stat.setString(1, model.getModel());
           stat.setInt(2, model.getNumber_seats());
           stat.setString(3, model.getOrigin());
           stat.setDate(4, Date.valueOf(model.getFabrication()));
           stat.setInt(5, model.getTurbines());
           
           stat.execute();
           
       }catch(SQLException ex){
           System.out.println(ex.getMessage());
       }finally{
           c.close();
       }
       
    }
    
    public ObservableList<Model> select_model()
    {
        
        ObservableList<Model> Models = FXCollections.observableArrayList();
        
        try{
      
            PreparedStatement stmt = this.connection_DB.prepareStatement("SELECT * FROM Models");
            
            ResultSet rs = stmt.executeQuery();
                        
            while(rs.next()){
 
                Model model = new Model(
                    rs.getInt("id_model"),
                    rs.getString("model"),
                    rs.getInt("number_seats"),
                    rs.getString("origin"),
                    rs.getDate("fabrication").toLocalDate(),
                    rs.getInt("turbines")
                );
                
                Models.add(model);
            }
            
            stmt.executeQuery();
            
        }catch(SQLException ex){
            throw new RuntimeException(ex);
        }finally{        
            return Models;
        }
        
    }
    
    public Model select_model_especific(String model_especific)
    {
        Model Models = null;
        
        try{
      
            PreparedStatement stmt = this.connection_DB.prepareStatement("SELECT * FROM Models WHERE model = ?");
            
            stmt.setString(1, model_especific);
            
            ResultSet rs = stmt.executeQuery();
                        
            Model model = new Model(
                rs.getInt("id_model"),
                rs.getString("model"),
                rs.getInt("number_seats"),
                rs.getString("origin"),
                rs.getDate("fabrication").toLocalDate(),
                rs.getInt("turbines")
            );
                
            Models = model;
            
            stmt.executeQuery();
            
        }catch(SQLException ex){
            throw new RuntimeException(ex);
        }finally{        
            return Models;
        }
        
    }
    
}
