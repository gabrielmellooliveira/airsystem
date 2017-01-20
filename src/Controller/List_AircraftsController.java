package Controller;

import DAO.Airplane_DAO;
import Main.List_Aircrafts;
import Model.Airplane;
import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Side;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

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
    
    @FXML private VBox vbox_airplane;
    
    //@FXML private ImageView img = new ImageView();
    
    private ObservableList<Airplane> airplanes;
    
    void init_scene(){
        
        Airplane_DAO airplane_DAO = new Airplane_DAO();
        
        airplanes = airplane_DAO.select_airplane();
        
        HBox hbox = new HBox();
        hbox.setPrefSize(120, 800);
        
        int cont = 0;
        
        for(Airplane air : airplanes){
            
            cont++;
            
            if(cont <= 6){
            
                VBox vbox = new VBox();
                vbox.setPrefSize(120, 120);

                ImageView img = new ImageView();

                img.setFitHeight(120);
                img.setFitWidth(120);
                img.setImage(new Image(air.getImg()));
                img.setStyle("-fx-alignment: center;");

                Media media = new Media(new File(air.getAudio().substring(8)).toURI().toString());
                MediaPlayer mediaPlayer = new MediaPlayer(media);
                
                img.setOnMouseClicked(s -> {
                    if(mediaPlayer.getStatus() != MediaPlayer.Status.PLAYING){
                        mediaPlayer.play();
                    }else{
                        mediaPlayer.pause();
                    }
                });
                
                Label label = new Label(air.getDescription());//air.getDescription());
                label.setPrefWidth(120);
                label.setStyle("-fx-text-alignment: center;");

                vbox.getChildren().addAll(img, label);
                vbox.setStyle("-fx-padding: 6;");

                hbox.getChildren().addAll(vbox);
                
            }else{
                
                vbox_airplane.getChildren().add(hbox);
                
                hbox = new HBox();
                hbox.setPrefSize(120, 800);
                
            }
            
        }
        
        vbox_airplane.getChildren().add(hbox);
        
    }
    
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
        init_scene();
        add_css();
        action_buttons();
        language_adaptation();
    }    
    
}
