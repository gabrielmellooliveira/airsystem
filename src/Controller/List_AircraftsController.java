package Controller;

import Main.List_Aircrafts;
import Main.Login;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Side;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;

/**
 * FXML Controller class
 *
 * @author User
 */
public class List_AircraftsController implements Initializable {

    //TabePane and Tabs
    @FXML private TabPane tabpane_airplane;
    @FXML private Tab tab_adjust_menu, tab_airplane, tab_search;
    
    /**
    *   <TAB - ADJUST MENU
    */
    
    //ImageView
    @FXML private ImageView img_fullscreen, img_down, img_left, img_right, img_up;
    
    /**
    *   <TAB - SEARCH
    */
    
    //TextField
    @FXML private TextField tf_search;
    
    //Button
    @FXML private Button btn_search;
    
    void search(){
        
    }
    
    void add_css(){
        btn_search.getStyleClass().add("button_green");  
    }
    
    void action_buttons(){
        img_fullscreen.setOnMouseClicked(s -> {
            List_Aircrafts.getStage().setFullScreen(true);
            tabpane_airplane.setPrefSize(List_Aircrafts.getStage().getWidth(), List_Aircrafts.getStage().getHeight());
           
        } );
        img_down.setOnMouseClicked(s -> tabpane_airplane.setSide(Side.BOTTOM));
        img_left.setOnMouseClicked(s -> tabpane_airplane.setSide(Side.LEFT));
        img_right.setOnMouseClicked(s -> tabpane_airplane.setSide(Side.RIGHT));
        img_up.setOnMouseClicked(s -> tabpane_airplane.setSide(Side.TOP));
        btn_search.setOnMouseClicked(s -> tabpane_airplane.setSide(Side.TOP));
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
