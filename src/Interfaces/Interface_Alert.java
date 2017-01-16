package Interfaces;


import javafx.scene.control.Alert;

/**
 *
 * @author User
 */
public interface Interface_Alert {

    static Alert Alert(String Header, String Title){
      
        Alert alert =new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(Title);
        alert.setHeaderText(Header);
        alert.showAndWait();
        
        return alert;
    }
    
}
