package Controller;

import static Controller.Choose_Language.map_languages;
import DAO.User_DAO;
import Main.Login;
import Main.Register_User;
import Model.User;
import java.io.File;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author User
 */
public class Register_UserController implements Initializable {

    //Labels
    @FXML private Label lb_name, lb_address, lb_birth, lb_user, lb_password, lb_password_confirm;
    
    //TextFields, PasswordFields and DatePicker
    @FXML private TextField tf_name, tf_last_name, tf_address, tf_address_number, tf_user;
    @FXML private PasswordField pf_password, pf_password_confirm;
    @FXML private DatePicker dp_date_birth;
    
    //ImageView
    @FXML private ImageView img;
    
    //Buttons
    @FXML private Button btn_change, btn_delete, btn_register, btn_cancel;
   
    private String img_file = "/Images/sem-foto.jpg";
    
    void change_image(){
        FileChooser fc = new FileChooser();
        fc.getExtensionFilters().add(new ExtensionFilter("Images", "*.jpg", "*.jpeg", "*.png"));
        File file = fc.showOpenDialog(new Stage());
        if (file != null)
            img.setImage(new Image("file:///" + file.getAbsolutePath()));
        img_file = "file:///" + file.getAbsolutePath();
        
    }
    
    void register_user(){
        if (tf_name.getText().equals("") || tf_last_name.getText().equals("") || tf_user.getText().equals("") || pf_password.getText().equals("") || 
            pf_password_confirm.getText().equals("") || dp_date_birth.getValue() == null) {
            
            //Alert
            Interfaces.Interface_Alert.Alert(map_languages.get("null_fields"), map_languages.get("null_fields_message"));
            
        } else {
            
            if (pf_password_confirm.getText().equals(pf_password.getText())) {
                
                User user = new User(tf_name.getText(), tf_last_name.getText(), tf_address.getText() + " - Nº " + tf_address_number.getText(),
                dp_date_birth.getValue(), null, tf_user.getText(), pf_password.getText(), img_file);
                
                User_DAO user_DAO = new User_DAO();
                try {
                    user_DAO.insert_user(user);
                    
                    //Alert
                    Interfaces.Interface_Alert.Alert(map_languages.get("register_success"), map_languages.get("register_success_message"));
                    
                    Login.getStage().show();
                    Register_User.getStage().close();
                    
                } catch (SQLException ex) {
                    Logger.getLogger(Register_UserController.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            } else {
                
                //Alert
                Interfaces.Interface_Alert.Alert(map_languages.get("register_error"), map_languages.get("register_error_message"));
                
            }
            
        }
    }
    
    void add_css(){
        btn_change.getStyleClass().add("button_green");
        btn_delete.getStyleClass().add("button_red");
        btn_register.getStyleClass().add("button_green");
        btn_cancel.getStyleClass().add("button_red");
    }
    
    void action_buttons(){
        btn_change.setOnMouseClicked(s -> change_image());
        btn_delete.setOnMouseClicked(s -> img.setImage(new Image("/Images/sem-foto.jpg")));
        btn_register.setOnMouseClicked(s -> register_user());
        btn_cancel.setOnMouseClicked(s -> cancel());
    }
    
    void language_adaptation(){
        lb_name.setText(map_languages.get("lb_name"));
        lb_address.setText(map_languages.get("lb_address"));
        lb_birth.setText(map_languages.get("lb_birth"));
        lb_user.setText(map_languages.get("lb_user"));
        lb_password.setText(map_languages.get("lb_password"));
        lb_password_confirm.setText(map_languages.get("lb_password_confirm"));
    
        tf_name.setPromptText(map_languages.get("tf_name"));
        tf_last_name.setPromptText(map_languages.get("tf_last_name"));
        tf_address.setPromptText(map_languages.get("tf_address"));
        tf_address_number.setPromptText(map_languages.get("tf_address_number"));
        tf_user.setPromptText(map_languages.get("tf_user"));
        pf_password.setPromptText(map_languages.get("pf_password"));
        pf_password_confirm.setPromptText(map_languages.get("pf_password_confirm"));
        dp_date_birth.setPromptText(map_languages.get("dp_birth"));
    
        btn_change.setText(map_languages.get("btn_change"));
        btn_delete.setText(map_languages.get("btn_delete"));
        btn_register.setText(map_languages.get("btn_register"));
        btn_cancel.setText(map_languages.get("btn_cancel"));
    }
    
    void cancel(){
        tf_name.clear();
        tf_last_name.clear();
        tf_address.clear();
        tf_address_number.clear();
        tf_user.clear();
        pf_password.clear();
        pf_password_confirm.clear();
        dp_date_birth.setValue(null);
        img.setImage(new Image("/Images/sem-foto.jpg"));
    }
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        add_css();
        action_buttons();
        language_adaptation();
    }    
    
}
