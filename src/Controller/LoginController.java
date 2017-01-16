package Controller;

import Main.*;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 *
 * @author User
 */
public class LoginController implements Initializable {
    
    public static boolean is_admin;

    public static boolean Is_admin() {
        return is_admin;
    }
    
    //Fileds
    @FXML private TextField tf_user;
    @FXML private PasswordField pf_password;
    
    //ComboBox
    @FXML private ComboBox<String> cb_language;
    
    //Buttons
    @FXML private Button btn_enter, btn_exit, btn_new_user;
    
    void log_into(){
        //Do login
        if (tf_user.getText().equals("") || pf_password.getText().equals("")) {
          
            //Alert
            Interfaces.Interface_Alert.Alert("Campos Nulos", "");
            
        } else {
        
            if (tf_user.getText().equals("admin") && pf_password.getText().equals("admin")){
                is_admin = true;
                Main screen = new Main();
                try { 
                    screen.start(new Stage());
                    Login.getStage().close();
                } catch (Exception ex) {
                    Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }else if(tf_user.getText().equals("admin")){
            
            }else{
            
                //Alert    
                Interfaces.Interface_Alert.Alert("Campos Nulos", "Teste - Alert with Interface");    
            } 
            
        }
    }
    
    void add_css(){
        btn_enter.getStyleClass().add("glass-grey");
        btn_exit.getStyleClass().add("button_red");
        btn_new_user.getStyleClass().add("button_green");
    }
    
    void action_buttons(){
        //Alert alert = Alert.createAlert("Teste - Alert with Interface", "Alert Teste");
        btn_enter.setOnMouseClicked(s -> log_into());
        btn_exit.setOnMouseClicked(s -> System.exit(0));
        btn_new_user.setOnMouseClicked(s -> {
            Register_User register_User = new Register_User();
            try { 
                register_User.start(new Stage());
            } catch (Exception ex) {
                Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
            }
            Login.getStage().close();
        });
    } 
    
    void language_adaptation(){
        
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        add_css();
        action_buttons();
        language_adaptation();
    }    
    
}
