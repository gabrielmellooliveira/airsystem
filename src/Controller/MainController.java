package Controller;

import Main.List_Aircrafts;
import Main.List_Users;
import Main.Main;
import Main.Manage_Aircraft;
import Main.Manage_Company;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author User
 */
public class MainController implements Initializable {

    @FXML private Button btn_list_users, btn_list_airplanes, btn_manage_company, btn_manage_airplane;
    
    void manage_permission(){
        if(LoginController.Is_admin() == true){
            btn_list_users.setVisible(true);
        }else{
            btn_list_users.setVisible(false);
        }
    }
    
    void add_css(){
        btn_list_users.getStyleClass().add("button_green");
        btn_list_airplanes.getStyleClass().add("button_green");
        btn_manage_company.getStyleClass().add("button_green");
        btn_manage_airplane.getStyleClass().add("button_green");
    }
    
    void action_buttons(){
        btn_list_users.setOnMouseClicked(s -> {
            List_Users screen = new List_Users();
            try {
                screen.start(new Stage());
                Main.getStage().close();
            } catch (Exception ex) {
                Logger.getLogger(Manage_AircraftController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        
        btn_list_airplanes.setOnMouseClicked(s -> {
            List_Aircrafts screen = new List_Aircrafts();
            try {
                screen.start(new Stage());
                Main.getStage().close();
            } catch (Exception ex) {
                Logger.getLogger(Manage_AircraftController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        
        btn_manage_company.setOnMouseClicked(s -> {
            Manage_Company screen = new Manage_Company();
            try {
                screen.start(new Stage());
                Main.getStage().close();
            } catch (Exception ex) {
                Logger.getLogger(Manage_AircraftController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        
        btn_manage_airplane.setOnMouseClicked(s -> {
            Manage_Aircraft screen = new Manage_Aircraft();
            try {
                screen.start(new Stage());
                Main.getStage().close();
            } catch (Exception ex) {
                Logger.getLogger(Manage_AircraftController.class.getName()).log(Level.SEVERE, null, ex);
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
        manage_permission();
        add_css();
        action_buttons();
        language_adaptation();
    }    
    
}
