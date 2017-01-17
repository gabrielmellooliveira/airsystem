package DAO;

import JDBC.Connection_Factory;
import Model.Company;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author User
 */
public class Company_DAO {
    
    public static Connection connection_DB;
    
    public Company_DAO()
    {
        Company_DAO.connection_DB = Connection_Factory.getConnection();
    }
        
    public void insert_company(Company company) throws SQLException{
       
       Connection c = Connection_Factory.getConnection();
       String sql = "INSERT INTO Companys(name_company, cnpj, city, phone, email, img)" + 
                    " VALUES (?, ?, ?, ?, ?, ?)"; 
        
       try{
           
           PreparedStatement stat = c.prepareStatement(sql);
           
           stat.setString(1, company.getName_company());
           stat.setString(2, company.getCnpj());
           stat.setString(3, company.getCity());
           stat.setString(4, company.getPhone());
           stat.setString(5, company.getEmail());
           stat.setString(6, company.getImg());
           
           stat.execute();
           
       }catch(SQLException ex){
           System.out.println(ex.getMessage());
       }finally{
           c.close();
       }
       
    }
    
    public ObservableList<Company> select_company()
    {
        
        ObservableList<Company> Companys = FXCollections.observableArrayList();
        
        try{
      
            PreparedStatement stmt = this.connection_DB.prepareStatement("SELECT * FROM Companys");
            
            ResultSet rs = stmt.executeQuery();
                        
            while(rs.next()){
 
                Company company = new Company(
                    rs.getInt("id_company"),
                    rs.getString("name_company"),
                    rs.getString("cnpj"),
                    rs.getString("city"),
                    rs.getString("phone"),
                    rs.getString("email"),
                    rs.getString("img")
                );
                
                Companys.add(company);
            }
            
            stmt.executeQuery();
            
        }catch(SQLException ex){
            throw new RuntimeException(ex);
        }finally{        
            return Companys;
        }
        
    }
    
    public void edit_company(Company company) throws SQLException
    {
        Connection c = Connection_Factory.getConnection();
        String sql = "UPDATE Companys SET name_company = ?, cnpj = ?, city = ?, phone = ?, email = ?, img = ?" + 
                    " WHERE id_company = ?"; 
        
        PreparedStatement stat = c.prepareStatement(sql);
        
        try{
           
            stat.setString(1, company.getName_company());
            stat.setString(2, company.getCnpj());
            stat.setString(3, company.getCity());
            stat.setString(4, company.getPhone());
            stat.setString(5, company.getEmail());
            stat.setString(6, company.getImg());
            stat.setInt(7, company.getId_company());
           
            stat.execute();
            
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }finally{
            stat.close();
        }
    }
    
    public void deleta_company(Company company) throws SQLException
    {
        String sql = "DELETE FROM Companys WHERE id_company = ?";
        PreparedStatement stmt = connection_DB.prepareStatement(sql);
        
        try{           
            stmt.setInt(1, company.getId_company());
            stmt.execute();         
        }catch(SQLException e){
            throw new RuntimeException(e);
        }finally{
            stmt.close();
        }
    }
    
}
