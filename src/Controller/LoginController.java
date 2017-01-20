package Controller;

import static Controller.Choose_Language.map_languages;
import DAO.User_DAO;
import Main.*;
import Model.User;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
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
    
    private ObservableList<User> users;
    
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
            }else{ 
                
                User_DAO user_DAO = new User_DAO();
                users = user_DAO.select_user();
                
                for (User list_user : users) {
                
                    if (list_user.getUser().equals(tf_user.getText())) {
                    
                        if (list_user.getPassword().equals(pf_password.getText())) {
                      
                            //Alert
                            Interfaces.Interface_Alert.Alert("Sucesso", "");
                            
                            is_admin = false;
                            
                            Main main = new Main();
                            
                            try {
                                main.start(new Stage());
                            } catch (Exception ex) {
                                Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
                            }

                            Login.stage.close();
                        
                        }else{
                        
                            //Alert
                            Interfaces.Interface_Alert.Alert("Erro - usuário inválido", "");
                            
                        }
                    
                    }
 
                }
            }
            
        }
    }
    
    void add_css(){
        btn_enter.getStyleClass().add("glass-grey");
        btn_exit.getStyleClass().add("button_red");
        btn_new_user.getStyleClass().add("button_green");
    }
    
    void action_buttons(){
        cb_language.getItems().addAll("Português", "Inglês");  //Arrumar tradução
        cb_language.setValue(cb_language.getItems().get(0));
        cb_language.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                
            }
        });
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
        tf_user.setPromptText(map_languages.get("tf_user"));
        pf_password.setPromptText(map_languages.get("pf_password"));
        btn_enter.setText(map_languages.get("btn_enter"));
        btn_exit.setText(map_languages.get("btn_exit")); 
        btn_new_user.setText(map_languages.get("btn_new_user"));
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        add_css();
        action_buttons();
        language_adaptation();
    }    
    
}
