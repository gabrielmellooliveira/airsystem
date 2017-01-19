package Controller;

import DAO.Airplane_DAO;
import DAO.Company_DAO;
import DAO.Manufacturer_DAO;
import DAO.Model_DAO;
import Main.Main;
import Main.Manage_Aircraft_Plane;
import Model.Airplane;
import Model.Company;
import Model.Manufacturer;
import Model.Model;
import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

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
    @FXML private ComboBox<String> cb_model, cb_manufacturer, cb_company;
    
    //Buttons
    @FXML private Button btn_change, btn_delete_img, btn_register, btn_cancel;
    
    //ImageView
    @FXML private ImageView img_airplane_register;
    @FXML private ImageView img_add_sound;
        
    private String img_file = "/Images/sem-foto.jpg", audio_file;
    
    private Airplane airplane_selected;
    
    private ObservableList<Airplane> airplanes;

    private ObservableList<Model> models;
    private ObservableList<Manufacturer> manufacturers;
    private ObservableList<Company> companys;
    
    private ObservableList<String> new_models;
    private ObservableList<String> new_manufacturers;
    private ObservableList<String> new_companys;
    
    void init_scene(){
        
        Model_DAO model_DAO = new Model_DAO();
        models = model_DAO.select_model();
        
        models.forEach(s -> new_models.add(s.getModel()));
        
        cb_model.getItems().addAll(new_models);
        
        Manufacturer_DAO manufacturer_DAO = new Manufacturer_DAO();
        manufacturers = manufacturer_DAO.select_manufacturer();
        
        manufacturers.forEach(s -> new_manufacturers.add(s.getManufacturer()));
        
        cb_manufacturer.getItems().addAll(new_manufacturers);
        
        Company_DAO company_DAO = new Company_DAO();
        companys = company_DAO.select_company();
        
        companys.forEach(s -> new_companys.add(s.getName_company()));
        
        cb_company.getItems().addAll(new_companys);
        
    }
    
    void init_table(){
        col_id.setCellValueFactory(new PropertyValueFactory("id_airplane"));
        col_model.setCellValueFactory(new PropertyValueFactory("model"));        
        col_company.setCellValueFactory(new PropertyValueFactory("company"));
        col_manufacturer.setCellValueFactory(new PropertyValueFactory("manufacturer"));        
        col_number_seats.setCellValueFactory(new PropertyValueFactory("number_seats"));
        col_fabrication.setCellValueFactory(new PropertyValueFactory("fabrication"));
        col_customization.setCellValueFactory(new PropertyValueFactory("color"));        
        col_description.setCellValueFactory(new PropertyValueFactory("description"));
       
        Airplane_DAO airplane_DAO = new Airplane_DAO();       
        airplanes = airplane_DAO.select_airplane();
        table_airplane.setItems(airplanes); 
    }
    
    void search(){
        ObservableList<Airplane> airplane = FXCollections.observableArrayList();
        
        for (Airplane plane : airplanes) {
            if (plane.getDescription().contains(tf_search.getText())) {
                airplane.add(plane);
            }
        }
        table_airplane.setItems(airplane);  
    }
    
    void generate_pdf(){
        
        Document doc = new Document();
        FileChooser fc = new FileChooser();
        fc.getExtensionFilters().add(new FileChooser.ExtensionFilter("PDF", "*.pdf"));
        File file = fc.showOpenDialog(new Stage());
        if(file != null){
            try {
                PdfWriter.getInstance(doc, new FileOutputStream(file.getAbsolutePath()));

                doc.open();

                for (Airplane plane : airplanes) {
                   doc.add(new Paragraph(lb_model.getText() + ": " + plane.getModel()));
                   doc.add(new Paragraph("Ex.number seats" + ": " + plane.getNumber_seats()));
                   doc.add(new Paragraph("Ex. fabrication" + ": " + plane.getFabrication()));
                   doc.add(new Paragraph(lb_manufacturer.getText() + ": " + plane.getManufacturer()));
                   doc.add(new Paragraph(lb_company.getText() + ": " + plane.getCompany()));
                   doc.add(new Paragraph(lb_customization.getText() + ": " + plane.getColor()));
                   doc.add(new Paragraph(lb_description.getText() + ": " + plane.getDescription()));
                   com.itextpdf.text.Image image = com.itextpdf.text.Image.getInstance(plane.getImg());
                   doc.add(image);
                }

                //Alert
                Interfaces.Interface_Alert.Alert("PDF gerado com sucesso", "");

            } catch (Exception e) {

            }finally{
                doc.close();
            }
        }else{
            //Alert
            Interfaces.Interface_Alert.Alert("Escolha um local para salvar o PDF", "");
        }
        
    }
    
    void delete(){
        Airplane_DAO airplane_DAO = new Airplane_DAO();
        try {
            airplane_DAO.deleta_airplane(airplane_selected);
            
            //Alert
            Interfaces.Interface_Alert.Alert("Companhia deletada com sucesso", "");
            
        } catch (SQLException ex) {
            Logger.getLogger(List_UsersController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    void add_audio(){
        FileChooser fc = new FileChooser();
        fc.getExtensionFilters().add(new FileChooser.ExtensionFilter("Sound", "*.mp3"));
        File file = fc.showOpenDialog(new Stage());
        if (file != null)
            audio_file = "file:///" + file.getAbsolutePath();
    }
    
    void change(){
        FileChooser fc = new FileChooser();
        fc.getExtensionFilters().add(new FileChooser.ExtensionFilter("Images", "*.jpg", "*.jpeg", "*.png"));
        File file = fc.showOpenDialog(new Stage());
        if (file != null)
            img_airplane_register.setImage(new Image("file:///" + file.getAbsolutePath()));
        img_file = "file:///" + file.getAbsolutePath();
    }
    
    void register(){
        if (tf_customization.getText().equals("") || tf_description.getText().equals("") || 
            cb_model.getSelectionModel().isEmpty() || cb_manufacturer.getSelectionModel().isEmpty() || cb_company.getSelectionModel().isEmpty()) {
            
            //Alert
            Interfaces.Interface_Alert.Alert("Campos Nulos", "");
            
        } else {
            
            Model_DAO model_DAO = new Model_DAO();
            Model model = model_DAO.select_model_especific(cb_model.getSelectionModel().getSelectedItem());
            
            Airplane airplane = new Airplane(model.getModel(), model.getNumber_seats(), model.getFabrication(),
            cb_manufacturer.getSelectionModel().getSelectedItem(), cb_company.getSelectionModel().getSelectedItem(),
            tf_customization.getText(), tf_description.getText(), audio_file, img_file);
                
            Airplane_DAO airplane_DAO = new Airplane_DAO();
            try {
                airplane_DAO.insert_airplane(airplane);
                    
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
        //TAB - PESQUISAR
        btn_search.setOnMouseClicked(s -> search());
        btn_generate_pdf.setOnMouseClicked(s -> generate_pdf());
        btn_delete.setOnMouseClicked(s -> delete());
        
        //TAB - CADASTRAR
        btn_change.setOnMouseClicked(s -> change());
        btn_delete_img.setOnMouseClicked(s -> img_airplane_register.setImage(new Image("/Images/sem-foto.jpg")));
        btn_register.setOnMouseClicked(s -> register());
        btn_cancel.setOnMouseClicked(s -> {
            Main screen = new Main();
            try {
                screen.start(new Stage());
                Manage_Aircraft_Plane.getStage().close();
            } catch (Exception ex) {
                Logger.getLogger(Manage_Aircraft_ManufacturerController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        
        table_airplane.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {
            @Override
            public void changed(ObservableValue observable, Object oldValue, Object newValue) {
                if(newValue != null){
                    airplane_selected = (Airplane) newValue;
                    img_airplane.setImage(new Image(airplane_selected.getImg()));
                }else{
                    airplane_selected = null;
                }
            }
        });
        
        tf_search.setOnKeyReleased((KeyEvent e)->{
            search();
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
        init_table();
        add_css();
        action_buttons();
        language_adaptation();
    }    
    
}
