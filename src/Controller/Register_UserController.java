package Controller;

import Main.Login;
import Main.Register_User;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;

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
    @FXML private DatePicker dp_birth;
    
    //ImageView
    @FXML private ImageView img;
    
    //Buttons
    @FXML private Button btn_change, btn_delete, btn_register, btn_cancel;
   
    void change_image(){
        
    }
    
    void register_user(){
        if (tf_name.getText().equals("") || tf_last_name.getText().equals("") || tf_address.getText().equals("") || 
            tf_address_number.getText().equals("") || tf_user.getText().equals("") || pf_password.getText().equals("") || 
            pf_password_confirm.getText().equals("") || dp_birth.getValue().equals(null)) {
            
            //Alert
            
        } else {
            
            if (pf_password_confirm.getText().equals(pf_password.getText())) {
                
                
                
            } else {
                
                //Alert
                
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
        btn_delete.setOnMouseClicked(s -> img.setImage(null));
        btn_register.setOnMouseClicked(s -> register_user());
        btn_cancel.setOnMouseClicked(s -> {Login.getStage().show();Register_User.getStage().close();});
    }
    
    void language_adaptation(){
        
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
