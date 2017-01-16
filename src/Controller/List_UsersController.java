package Controller;

import Main.List_Users;
import Main.Main;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author User
 */
public class List_UsersController implements Initializable {

    //TableView and TableColumns
    @FXML private TableView table_users;
    @FXML private TableColumn col_id, col_name, col_last_name;
    
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
    
    void add_css(){
        btn_change.getStyleClass().add("button_green");
        btn_delete.getStyleClass().add("button_red");
        btn_back.getStyleClass().add("button_red");
        btn_new.getStyleClass().add("button_green");
        btn_edit.getStyleClass().add("button_green");
        btn_delete_user.getStyleClass().add("button_red");
    }
    
    void action_buttons(){
        //btn_change.setOnMouseClicked(s -> );
        btn_delete.setOnMouseClicked(s -> img.setImage(null));
        btn_back.setOnMouseClicked(s -> {
            Main screen = new Main();
            try {
                screen.start(new Stage());
                List_Users.getStage().close();
            } catch (Exception ex) {
                Logger.getLogger(Manage_AircraftController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        //btn_new.setOnMouseClicked(s -> );
        //btn_edit.setOnMouseClicked(s -> );
        //btn_delete_user.setOnMouseClicked(s -> );
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
