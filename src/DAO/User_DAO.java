package DAO;

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
public class User_DAO {
    
    public static Connection connection_DB;
    
    public User_DAO()
    {
        //Usuario_DAO.conexao_BD = Connection_MVC.getConnection();
    }
        
    /*public void insert_user(User user){
       
       //Connection c = Connection_MVC.getConnection();
       String sql = "INSERT INTO Users(name, last_name, address, date_birth, phone, user, password, img)" + 
                    " VALUES (?, ?, ?, ?, ?, ?, ?, ?)"; 
        
       try{
           
           //PreparedStatement stat = c.prepareStatement(sql);
           
           stat.setString(1, usuario.getLogin());
           stat.setString(2, usuario.getSenha());
           stat.setString(3, usuario.getNome());
           stat.setDate(4, usuario.getEmail());
           stat.setString(5, null); //Date.valueOf( usuario.getData_nascimento() ));
           stat.setString(6, 1);
           stat.setString(7, usuario.getResposta_seguranca());
           stat.setString(8, 1);
           stat.setString(10, "file:///E:\\TCC\\Imagens\\Imagens_Usuarios\\Usuario_Default\\usuario_default.png");
           
           //stat.execute();
           
       }catch(SQLException ex){
           System.out.println(ex.getMessage());
       }finally{
           //c.close();
       }
       
    }
    
    public ObservableList<User> select_user()
    {
        try{
            
            ObservableList<User> Users = FXCollections.observableArrayList();
        
            PreparedStatement stmt = this.conexao_BD.prepareStatement("SELECT * FROM Users");
            
            ResultSet rs = stmt.executeQuery();
                        
            while(rs.next()){
 
                User usuario = new User();
                
                usuario.setId_usuario(rs.getInt("id_usuario"));
                usuario.setLogin(rs.getString("login"));
                usuario.setSenha(rs.getString("senha"));
                usuario.setNome(rs.getString("nome"));
                usuario.setEmail(rs.getString("email"));
                usuario.setTelefone(rs.getInt("telefone"));
                usuario.setData_nascimento(rs.getDate("data_nascimento").toLocalDate());
                
                usuario.setPais(rs.getString("nome_pais"));
                
                usuario.setEstado(rs.getString("nome_estado"));
                
                usuario.setPergunta_seguranca(rs.getString("pergunta_seguranca"));
                
                usuario.setResposta_seguranca(rs.getString("resposta_seguranca"));
                usuario.setFoto_perfil(rs.getString("foto_perfil"));
                   
                Users.add(usuario);
            }
            
            stmt.executeQuery();
            
        }catch(SQLException ex){
            throw new RuntimeException(ex);
        }finally{        
            return User;
        }
        
    }
    
    public void deleta_user(User user)
    {
        String sql = "DELETE FROM Users WHERE id_user = ?";
        try{
            PreparedStatement stmt = conexao_BD.prepareStatement(sql);
            stmt.setInt(1, produto.getId_produto());
            stmt.execute();
            stmt.close();
        }catch(SQLException e){
            throw new RuntimeException(e);
        }
    }*/
    
}
