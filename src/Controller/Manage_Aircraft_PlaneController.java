package Controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;

/**
 * FXML Controller class
 *
 * @author User
 */
public class Manage_Aircraft_PlaneController implements Initializable {

    //Tabs
    @FXML private Tab tab_cadastro, tab_pesquisa;
    
    //TableView and TableColumns
    @FXML private TableView table_airplane;
    @FXML private TableColumn col_id, col_model, col_company, col_manufacturer, col_number_seats, col_fabrication, col_customization, col_description;
    
    /**
    *   <TAB - PESQUISA
    */
    
    //Label
    @FXML private Label lb_search;
    
    //TextField
    @FXML private TextField tf_search;
    
    //Buttons
    @FXML private Button btn_search, btn_generate_pdf, btn_delete;
    
    //ImageView
    @FXML private ImageView img_airplane;
    
    /**
    *   <TAB - CADASTRO
    */
    
    //Labels
    @FXML private Label lb_model, lb_manufacturer, lb_company, lb_customization, lb_description, lb_add_sound;
    
    //TextFields and ComboBoxs
    @FXML private TextField tf_customization, tf_description;
    @FXML private ComboBox cb_model, cb_manufacturer, cb_company;
    
    //Buttons
    @FXML private Button btn_change, btn_delete_img, btn_register, btn_cancel;
    
    //ImageView
    @FXML private ImageView img_airplane_register;
    @FXML private ImageView img_add_sound;
    
    void add_css(){
        //TAB - PESQUISAR
        btn_search.getStyleClass().add("button_green");
        btn_generate_pdf.getStyleClass().add("button_green");
        btn_delete.getStyleClass().add("button_red");
        
        //TAB - CADASTRAR
        btn_change.getStyleClass().add("button_green");
        btn_delete_img.getStyleClass().add("button_red");
        btn_register.getStyleClass().add("button_green");
        btn_cancel.getStyleClass().add("button_red");
    }
    
    void action_buttons(){
        //btn_list_users.setOnMouseClicked(s -> Login.getStage().show());
        //btn_list_aircrafts.setOnMouseClicked(s -> Login.getStage().show());
        //btn_manage_company.setOnMouseClicked(s -> Login.getStage().show());
        //btn_manage_aircrafts.setOnMouseClicked(s -> Login.getStage().show());
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
