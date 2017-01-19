package Controller;

import DAO.Model_DAO;
import Main.Manage_Aircraft;
import Main.Manage_Aircraft_Model;
import Model.Model;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.ObservableList;
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
    @FXML private ComboBox<String> cb_origin;
    @FXML private ComboBox<Integer> cb_turbines;
    @FXML private DatePicker dp_fabrication;
    
    //Buttons
    @FXML private Button btn_register, btn_cancel;
    
    ObservableList<String> list_origin; 
    ObservableList<Integer> list_turbines;
    
    void init_scene(){
    
        cb_origin.getItems().addAll("BRASIL", "ALEMANHA", "ESTADOS UNIDOS", "REINO UNIDO");
        cb_turbines.getItems().addAll(1, 2, 3, 4);
        
    }
    
    void register(){
        if (tf_model.getText().equals("") || tf_number_seats.getText().equals("") || cb_origin.getSelectionModel().isEmpty() || cb_turbines.getSelectionModel().isEmpty() || dp_fabrication.getValue().equals(null)) {
            
            //Alert
            Interfaces.Interface_Alert.Alert("Campos Nulos", "");
            
        } else {
            
            Model model = new Model(tf_model.getText(), Integer.valueOf(tf_number_seats.getText()), cb_origin.getSelectionModel().getSelectedItem(),
                                    dp_fabrication.getValue(), cb_turbines.getSelectionModel().getSelectedItem());
                
            Model_DAO model_DAO = new Model_DAO();
            try {
                model_DAO.insert_model(model);
                    
                //Alert
                Interfaces.Interface_Alert.Alert("Registrado com sucesso", "");
                
            } catch (SQLException ex) {
                Logger.getLogger(Register_UserController.class.getName()).log(Level.SEVERE, null, ex);
                    
                //Alert
                Interfaces.Interface_Alert.Alert("Erro ao registrar", "");
                
            }
        }
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
        init_scene();
        add_css();
        action_buttons();
        language_adaptation();
    }    
    
}
