package Controller;

import DAO.User_DAO;
import Main.List_Users;
import Main.Main;
import Model.User;
import java.io.File;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author User
 */
public class List_UsersController implements Initializable {

    //TableView and TableColumns
    @FXML private TableView<User> table_users;
    @FXML private TableColumn<User, String> col_id, col_name, col_last_name;
    
    //Labels
    @FXML private Label lb_user_data;
    @FXML private Label lb_name, lb_last_name, lb_address, lb_date_birth, lb_phone,
            lb_user, lb_password, lb_password_confirm;
    
    //TextFields, PasswordFields and DatePicker
    @FXML private TextField tf_name, tf_last_name, tf_address, tf_phone, tf_user;
    @FXML private PasswordField pf_password, pf_password_confirm;
    @FXML private DatePicker dp_date_birth;
    
    //Buttons
    @FXML private Button btn_change, btn_delete, btn_back, btn_new, btn_edit, btn_delete_user;
    
    //ImageView
    @FXML private ImageView img;
    
    private String img_file = "/Images/sem-foto.jpg";
    
    private User user_selected;
    
    private ObservableList<User> users;
    
    void init_table(){
        col_id.setCellValueFactory(new PropertyValueFactory("id_user"));
        col_name.setCellValueFactory(new PropertyValueFactory("name"));        
        col_last_name.setCellValueFactory(new PropertyValueFactory("last_name"));
       
        User_DAO user_DAO = new User_DAO();       
        users = user_DAO.select_user();
        table_users.setItems(users); 
    }
    
    void change_image(){
        FileChooser fc = new FileChooser();
        fc.getExtensionFilters().add(new FileChooser.ExtensionFilter("Images", "*.jpg", "*.jpeg", "*.png"));
        File file = fc.showOpenDialog(new Stage());
        if (file != null)
            img.setImage(new Image("file:///" + file.getAbsolutePath()));
        img_file = "file:///" + file.getAbsolutePath();
        
    }
    
    void register_user(){
        if (tf_name.getText().equals("") || tf_last_name.getText().equals("") || tf_user.getText().equals("") || pf_password.getText().equals("") || 
            pf_password_confirm.getText().equals("") || dp_date_birth.getValue().equals(null)) {
            
            //Alert
            Interfaces.Interface_Alert.Alert("Campos Nulos", "");
            
        } else {
            
            if (pf_password_confirm.getText().equals(pf_password.getText())) {
                
                User user = new User(tf_name.getText(), tf_last_name.getText(), tf_address.getText(),
                dp_date_birth.getValue(), tf_phone.getText(), tf_user.getText(), pf_password.getText(), img_file);
                
                User_DAO user_DAO = new User_DAO();
                try {
                    user_DAO.insert_user(user);
                    
                    //Alert
                    Interfaces.Interface_Alert.Alert("Registrado com sucesso", "");
                
                } catch (SQLException ex) {
                    Logger.getLogger(Register_UserController.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            } else {
                
                //Alert
                Interfaces.Interface_Alert.Alert("Erro ao registrar", "");
                
            }
            
        }
    }
    
    void edit_user(){
        if (tf_name.getText().equals("") || tf_last_name.getText().equals("") || tf_user.getText().equals("") || pf_password.getText().equals("") || 
            pf_password_confirm.getText().equals("") || dp_date_birth.getValue().equals(null)) {
        
            //Alert
            Interfaces.Interface_Alert.Alert("Campos Nulos", "");
            
        } else {
            
            if (pf_password.getText().equals(pf_password_confirm.getText())) {
                
                User user = new User(user_selected.getId_user(), tf_name.getText(), tf_last_name.getText(), tf_address.getText(),
                dp_date_birth.getValue(), tf_phone.getText(), tf_user.getText(), pf_password.getText(), img_file);
                
                User_DAO user_DAO = new User_DAO();
                try {
                    user_DAO.edit_user(user);
                    
                    //Alert
                    Interfaces.Interface_Alert.Alert("Editado com sucesso", "");
                    
                } catch (SQLException ex) {
                    Logger.getLogger(Register_UserController.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            } else {
            }
            
        }
    }
    
    void delete_user(){
        User_DAO user_DAO = new User_DAO();
        try {
            user_DAO.deleta_user(user_selected);
            
            //Alert
            Interfaces.Interface_Alert.Alert("Usuário deletado com sucesso", "");
            
        } catch (SQLException ex) {
            Logger.getLogger(List_UsersController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    void add_css(){
        btn_change.getStyleClass().add("button_green");
        btn_delete.getStyleClass().add("button_red");
        btn_back.getStyleClass().add("button_red");
        btn_new.getStyleClass().add("button_green");
        btn_edit.getStyleClass().add("button_green");
        btn_delete_user.getStyleClass().add("button_red");
    }
    
    void action_buttons(){
        btn_change.setOnMouseClicked(s -> change_image());
        btn_delete.setOnMouseClicked(s -> img.setImage(new Image("/Images/sem-foto.jpg")));
        btn_back.setOnMouseClicked(s -> {
            Main screen = new Main();
            try {
                screen.start(new Stage());
                List_Users.getStage().close();
            } catch (Exception ex) {
                Logger.getLogger(Manage_AircraftController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        btn_new.setOnMouseClicked(s -> register_user());
        btn_edit.setOnMouseClicked(s -> edit_user());
        btn_delete_user.setOnMouseClicked(s -> delete_user());
        
        table_users.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {
            @Override
            public void changed(ObservableValue observable, Object oldValue, Object newValue) {
                if(newValue != null){
                    user_selected = (User) newValue;
                    tf_name.setText(user_selected.getName()); 
                    tf_last_name.setText(user_selected.getLast_name()); 
                    tf_address.setText(user_selected.getAddress()); 
                    tf_phone.setText(user_selected.getPhone());
                    tf_user.setText(user_selected.getUser());
                    dp_date_birth.setValue(user_selected.getDate_birth());
                    img.setImage(new Image(user_selected.getImg()));
                }else{
                    user_selected = null;
                }
            }
        });
    }
    
    void language_adaptation(){
        
    }
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        init_table();
        add_css();
        action_buttons();
        language_adaptation();
    }    
    
}
