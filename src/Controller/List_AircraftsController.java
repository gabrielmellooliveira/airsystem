package Controller;

import static Controller.Choose_Language.map_languages;
import DAO.Airplane_DAO;
import DAO.Company_DAO;
import Main.List_Aircrafts;
import Model.Airplane;
import Model.Company;
import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.animation.FadeTransition;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.geometry.Side;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import static javafx.scene.layout.Region.USE_COMPUTED_SIZE;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.util.Duration;

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
    
    private ObservableList<Company> companys;
    
    private ObservableList<Airplane> airplanes;
    
    private boolean fullscreen;
    
    void init_scene_company(){
        
        Company_DAO company_DAO = new Company_DAO();
        companys = company_DAO.select_company();
        
        for (Company company : companys) {
            Tab tab = new Tab();
            tab.setText(company.getName_company());
            tabpane_airplane.getTabs().add(tab);
            
            AnchorPane ap = new AnchorPane();
            ap.setStyle("-fx-background-color: #2C3E50;");
            tab.contentProperty().set(ap);
            
            VBox vbox_tab = new VBox();
            vbox_tab.setStyle("-fx-background-color: #2C3E50;");
            
            ap.getChildren().add(vbox_tab);
            
            Airplane_DAO airplane_DAO = new Airplane_DAO();
        
            airplanes = airplane_DAO.select_airplane();

            HBox hbox = new HBox();
            hbox.setPrefSize(120, 800);

            int cont = 0;

            for(Airplane air : airplanes){

                cont++;

                if(air.getCompany().equals(company.getName_company()) && cont <= 6){

                    VBox vbox = new VBox();
                    vbox.setPrefSize(120, 120);

                    ImageView img = new ImageView();

                    img.setFitHeight(120);
                    img.setFitWidth(120);
                    img.setImage(new Image(air.getImg()));
                    img.setStyle("-fx-alignment: center;");

                    Label label = new Label(air.getDescription());
                    label.setPrefWidth(120);
                    label.alignmentProperty().set(Pos.CENTER);
                    
                    Media media = new Media(new File(air.getAudio().substring(8)).toURI().toString());
                    MediaPlayer mediaPlayer = new MediaPlayer(media);

                    img.setOpacity(0.2);
                    
                    img.setOnMouseClicked(s -> {
                        if(mediaPlayer == null){

                            //Alert
                            Interfaces.Interface_Alert.Alert(map_languages.get("audio_error"), map_languages.get("audio_error_message"));

                        }else{
                            if(mediaPlayer.getStatus() != MediaPlayer.Status.PLAYING){
                                mediaPlayer.play();
                            }else{
                                mediaPlayer.pause();
                            }
                        }
                    });
                    
                    img.setOnMouseEntered(new EventHandler<MouseEvent>() {
                        @Override
                        public void handle(MouseEvent event) {
                            initAparece(img);
                            label.setTextFill(Color.WHITE);
                        }
                    });

                    img.setOnMouseExited(new EventHandler<MouseEvent>() {
                        @Override
                        public void handle(MouseEvent event) {
                            initDesaparece(img);
                            label.setTextFill(Color.BLACK);
                        }
                    });
                    
                    vbox.getChildren().addAll(img, label);
                    vbox.setStyle("-fx-padding: 6;");

                    hbox.getChildren().addAll(vbox);

                }else{

                    vbox_tab.getChildren().add(hbox);

                    hbox = new HBox();
                    hbox.setPrefSize(120, 800);

                }

            }

            vbox_tab.getChildren().add(hbox);
            
        }
        
    }
    
    void init_scene_airplane(){
        
        Airplane_DAO airplane_DAO = new Airplane_DAO();
        
        airplanes = airplane_DAO.select_airplane();
        
        vbox_airplane.setStyle("-fx-background-color: #2C3E50;");
        
        HBox hbox = new HBox();
        hbox.setPrefSize(120, 800);
        hbox.setStyle("-fx-background-color: #2C3E50;");
        
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

                Label label = new Label(air.getDescription());
                label.setPrefWidth(120);
                label.alignmentProperty().set(Pos.CENTER);
                
                Media media = new Media(new File(air.getAudio().substring(8)).toURI().toString());
                MediaPlayer mediaPlayer = new MediaPlayer(media);
                
                img.setOpacity(0.2);
                
                img.setOnMouseClicked(s -> {
                    if(mediaPlayer == null){
                    
                        //Alert
                        Interfaces.Interface_Alert.Alert(map_languages.get("audio_error"), map_languages.get("audio_error_message"));
                        
                    }else{
                        if(mediaPlayer.getStatus() != MediaPlayer.Status.PLAYING){
                            mediaPlayer.play();
                        }else{
                            mediaPlayer.pause();
                        }
                    }
                });
                
                img.setOnMouseEntered(new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent event) {
                        initAparece(img);
                        label.setTextFill(Color.WHITE);
                    }
                });
     
                img.setOnMouseExited(new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent event) {
                        initDesaparece(img);
                        label.setTextFill(Color.BLACK);
                    }
                });
                
                vbox.getChildren().addAll(img, label);
                vbox.setStyle("-fx-padding: 6;");

                hbox.getChildren().addAll(vbox);
                
            }else{
                
                vbox_airplane.getChildren().add(hbox);
                
                hbox = new HBox();
                hbox.setPrefSize(120, 800);
                hbox.setStyle("-fx-background-color: #2C3E50;");
                
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
            if(fullscreen){
                fullscreen = false;
                List_Aircrafts.getStage().setFullScreen(true);
                tabpane_airplane.setPrefSize(USE_COMPUTED_SIZE, USE_COMPUTED_SIZE);
                img_fullscreen.setImage(new Image("/Images/AumentaSecundario.png"));
            }else{
                fullscreen = true;
                List_Aircrafts.getStage().setFullScreen(false);
                List_Aircrafts.getStage().setHeight(USE_COMPUTED_SIZE);
                List_Aircrafts.getStage().setWidth(USE_COMPUTED_SIZE);
                tabpane_airplane.setPrefSize(USE_COMPUTED_SIZE, USE_COMPUTED_SIZE);
                img_fullscreen.setImage(new Image("/Images/DiminuiSecundario.png"));
            }
        } );
        img_down.setOnMouseClicked(s -> tabpane_airplane.setSide(Side.BOTTOM));
        img_left.setOnMouseClicked(s -> tabpane_airplane.setSide(Side.LEFT));
        img_right.setOnMouseClicked(s -> tabpane_airplane.setSide(Side.RIGHT));
        img_up.setOnMouseClicked(s -> tabpane_airplane.setSide(Side.TOP));
        btn_search.setOnMouseClicked(s -> tabpane_airplane.setSide(Side.TOP));
    }
    
    void language_adaptation(){
        tab_adjust_menu.setText(map_languages.get("tab_adjust_menu"));
        tab_airplane.setText(map_languages.get("tab_airplane"));
        tab_search.setText(map_languages.get("tab_search"));
    
        tf_search.setPromptText(map_languages.get("tf_search"));
    
        btn_search.setText(map_languages.get("btn_search"));
    }
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        init_scene_company();
        init_scene_airplane();
        add_css();
        action_buttons();
        language_adaptation();
    }  
    
    private void initAparece(Node c) {
        Duration d = new Duration(500);
        FadeTransition fadeTransition = new FadeTransition();
        fadeTransition.setFromValue(0);
        fadeTransition.setToValue(1);
        fadeTransition.setDuration(d);
        fadeTransition.setNode(c);
        fadeTransition.play();
    }
    
    private void initDesaparece(Node c) {
        Duration d = new Duration(500);
        FadeTransition fadeTransition = new FadeTransition();
        fadeTransition.setFromValue(1);
        fadeTransition.setToValue(0.2);
        fadeTransition.setDuration(d);
        fadeTransition.setNode(c);
        fadeTransition.play();
    } 
   
}
