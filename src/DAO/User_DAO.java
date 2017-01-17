package DAO;

import JDBC.Connection_Factory;
import Model.User;
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
public class User_DAO {
    
    public static Connection connection_DB;
    
    public User_DAO()
    {
        User_DAO.connection_DB = Connection_Factory.getConnection();
    }
        
    public void insert_user(User user) throws SQLException{
       
       Connection c = Connection_Factory.getConnection();
       String sql = "INSERT INTO Users(name_, last_name, address, date_birth, phone, user_, password_, img)" + 
                    " VALUES (?, ?, ?, ?, ?, ?, ?, ?)"; 
        
       try{
           
           PreparedStatement stat = c.prepareStatement(sql);
           
           stat.setString(1, user.getName());
           stat.setString(2, user.getLast_name());
           stat.setString(3, user.getAddress());
           stat.setDate(4, Date.valueOf(user.getDate_birth()));
           stat.setString(5, user.getPhone());
           stat.setString(6, user.getUser());
           stat.setString(7, user.getPassword());
           stat.setString(8, user.getImg());
           //stat.setString(10, "file:///E:\\TCC\\Imagens\\Imagens_Usuarios\\Usuario_Default\\usuario_default.png");
           
           stat.execute();
           
       }catch(SQLException ex){
           System.out.println(ex.getMessage());
       }finally{
           c.close();
       }
       
    }
    
    public ObservableList<User> select_user()
    {
        
        ObservableList<User> Users = FXCollections.observableArrayList();
        
        try{
      
            PreparedStatement stmt = this.connection_DB.prepareStatement("SELECT * FROM Users");
            
            ResultSet rs = stmt.executeQuery();
                        
            while(rs.next()){
 
                User user = new User(
                    rs.getInt("id_user"),
                    rs.getString("name_"),
                    rs.getString("last_name"),
                    rs.getString("address"),
                    rs.getDate("date_birth").toLocalDate(),
                    rs.getString("phone"),
                    rs.getString("user_"),
                    rs.getString("password_"),
                    rs.getString("img")
                );
                
                Users.add(user);
            }
            
            stmt.executeQuery();
            
        }catch(SQLException ex){
            throw new RuntimeException(ex);
        }finally{        
            return Users;
        }
        
    }
    
    public void edit_user(User user) throws SQLException
    {
        Connection c = Connection_Factory.getConnection();
        String sql = "UPDATE Users SET name_ = ?, last_name = ?, address = ?, date_birth = ?, phone = ?, user_ = ?, password_ = ?, img = ?" + 
                    " WHERE id_user = ?"; 
        
        PreparedStatement stat = c.prepareStatement(sql);
        
        try{
           
            stat.setString(1, user.getName());
            stat.setString(2, user.getLast_name());
            stat.setString(3, user.getAddress());
            stat.setDate(4, Date.valueOf(user.getDate_birth()));
            stat.setString(5, user.getPhone());
            stat.setString(6, user.getUser());
            stat.setString(7, user.getPassword());
            stat.setString(8, user.getImg());
            stat.setInt(9, user.getId_user());
           
            stat.execute();
            
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }finally{
            stat.close();
        }
    }
    
    public void deleta_user(User user) throws SQLException
    {
        String sql = "DELETE FROM Users WHERE id_user = ?";
        PreparedStatement stmt = connection_DB.prepareStatement(sql);
        
        try{           
            stmt.setInt(1, user.getId_user());
            stmt.execute();         
        }catch(SQLException e){
            throw new RuntimeException(e);
        }finally{
            stmt.close();
        }
    }
    
}
