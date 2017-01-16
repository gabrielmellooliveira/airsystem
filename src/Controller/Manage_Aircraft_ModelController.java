package Controller;

import Main.Manage_Aircraft;
import Main.Manage_Aircraft_Model;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author User
 */
public class Manage_Aircraft_ModelController implements Initializable {

    //Label
    @FXML private Label lb_model, lb_number_seats, lb_origin, lb_fabrication, lb_turbines;
    
    //TextFields, ComboBoxs and DatePicker
    @FXML private TextField tf_model, tf_number_seats;
    @FXML private ComboBox cb_origin, cb_turbines;
    @FXML private DatePicker dp_fabrication;
    
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
                Manage_Aircraft_Model.getStage().close();
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
