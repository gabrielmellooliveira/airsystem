package Controller;

import Main.Manage_Aircraft;
import Main.Manage_Aircraft_Manufacturer;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author User
 */
public class Manage_Aircraft_ManufacturerController implements Initializable {

    //Labels
    @FXML private Label lb_manufacturer, lb_focus, lb_country_origin, lb_phone, lb_email;
    
    //TextFields        
    @FXML private TextField tf_manufacturer, tf_focus, tf_country_origin, tf_phone, tf_email; 
    
    //Buttons
    @FXML private Button btn_register, btn_cancel;
    
    void register(){
        
    }
    
    void add_css(){
        btn_register.getStyleClass().add("button_green");
        btn_cancel.getStyleClass().add("button_red");
    }
    
    void action_buttons(){
        btn_register.setOnMouseClicked(s -> register());
        btn_cancel.setOnMouseClicked(s -> {
            Manage_Aircraft screen = new Manage_Aircraft();
            try {
                screen.start(new Stage());
                Manage_Aircraft_Manufacturer.getStage().close();
            } catch (Exception ex) {
                Logger.getLogger(Manage_Aircraft_ManufacturerController.class.getName()).log(Level.SEVERE, null, ex);
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
        add_css();
        action_buttons();
        language_adaptation();
    }    
    
}
