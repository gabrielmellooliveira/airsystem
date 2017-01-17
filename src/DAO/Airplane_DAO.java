package DAO;

import JDBC.Connection_Factory;
import Model.Airplane;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author User
 */
public class Airplane_DAO {
    
    public static Connection connection_DB;
    
    public Airplane_DAO()
    {
        Airplane_DAO.connection_DB = Connection_Factory.getConnection();
    }
        
    public void insert_airplane(Airplane airplane) throws SQLException{
       
       Connection c = Connection_Factory.getConnection();
       String sql = "INSERT INTO Airplanes(model, number_seats, fabrication, manufacturer, company, color, description, audio, img)" + 
                    " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)"; 
        
       try{
           
           PreparedStatement stat = c.prepareStatement(sql);
           
           stat.setString(1, airplane.getModel());
           stat.setInt(2, airplane.getNumber_seats());
           stat.setDate(3, Date.valueOf(airplane.getFabrication()));
           stat.setString(4, airplane.getManufacturer());
           stat.setString(5, airplane.getCompany());
           stat.setString(6, airplane.getColor());
           stat.setString(7, airplane.getDescription());
           stat.setString(8, airplane.getAudio());
           stat.setString(9, airplane.getImg());
           
           stat.execute();
           
       }catch(SQLException ex){
           System.out.println(ex.getMessage());
       }finally{
           c.close();
       }
       
    }
    
    public ObservableList<Airplane> select_airplane()
    {
        
        ObservableList<Airplane> Airplanes = FXCollections.observableArrayList();
        
        try{
      
            PreparedStatement stmt = this.connection_DB.prepareStatement("SELECT * FROM Airplanes");
            
            ResultSet rs = stmt.executeQuery();
                        
            while(rs.next()){
 
                Airplane airplane = new Airplane(
                    rs.getInt("id_airplane"),
                    rs.getString("model"),
                    rs.getInt("number_seats"),
                    rs.getDate("fabrication").toLocalDate(),
                    rs.getString("manufacturer"),
                    rs.getString("company"),
                    rs.getString("color"),
                    rs.getString("description"),
                    rs.getString("audio"),
                    rs.getString("img")
                );
                
                Airplanes.add(airplane);
            }
            
            stmt.executeQuery();
            
        }catch(SQLException ex){
            throw new RuntimeException(ex);
        }finally{        
            return Airplanes;
        }
        
    }
    
    public void deleta_airplane(Airplane airplane) throws SQLException
    {
        String sql = "DELETE FROM Airplanes WHERE id_airplane = ?";
        PreparedStatement stmt = connection_DB.prepareStatement(sql);
        
        try{           
            stmt.setInt(1, airplane.getId_airplane());
            stmt.execute();         
        }catch(SQLException e){
            throw new RuntimeException(e);
        }finally{
            stmt.close();
        }
    }
    
}
