package Main;

import static Controller.Choose_Language.map_languages;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author User
 */

public class List_Aircrafts extends Application {
    
    public String fxml = "List_Aircrafts";
    
    public String title_list_aircrafts = map_languages.get("title_list_aircrafts");
    
    public static Stage stage;

    public static Scene scene;
    
    public static Stage getStage() {
        return stage;
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }
    
    public static Scene getScene() {
        return scene;
    }

    public void setScene(Scene scene) {
        this.scene = scene;
    }

    @Override
    public void start(Stage stage) throws Exception {
        
        Parent root = FXMLLoader.load(getClass().getResource("/View/" + fxml + ".fxml"));
        
        Scene scene = new Scene(root);
        
        scene.getStylesheets().add("CSS/Estilo.css");
        
        stage.setScene(scene);
        this.scene = scene;
        this.stage = stage;
        stage.setTitle(title_list_aircrafts + " - AirSystem");
        stage.setResizable(false);
        //stage.setMaxHeight(600);
        //stage.setMaxWidth(800);
        
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
