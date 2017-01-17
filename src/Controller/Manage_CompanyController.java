package Controller;

import DAO.Company_DAO;
import Main.Main;
import Main.Manage_Company;
import Model.Company;
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
public class Manage_CompanyController implements Initializable {

    //Tabs
    @FXML private Tab tab_cadastro, tab_pesquisa;
    
    //TableView and TableColumns
    @FXML private TableView table_company;
    @FXML private TableColumn col_id, col_company, col_cnpj, col_phone, col_email;
    
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
    @FXML private ImageView img_company;
    
    /**
    *   <TAB - CADASTRO
    */
    
    //Labels
    @FXML private Label lb_company, lb_cnpj, lb_city, lb_phone, lb_email;
    
    //TextFields and ComboBoxs
    @FXML private TextField tf_company, tf_cnpj, tf_phone, tf_email;
    @FXML private ComboBox cb_city, cb_state;
    
    //Buttons
    @FXML private Button btn_change, btn_delete_img, btn_register, btn_cancel;
    
    //ImageView
    @FXML private ImageView img_company_register;
    
    private String img_file = "/Images/sem-foto.jpg";
    
    private Company company_selected;
    
    private ObservableList<Company> companys;
    
    void init_table(){
        col_id.setCellValueFactory(new PropertyValueFactory("id_user"));
        col_company.setCellValueFactory(new PropertyValueFactory("name"));        
        col_cnpj.setCellValueFactory(new PropertyValueFactory("last_name"));
        col_phone.setCellValueFactory(new PropertyValueFactory("name"));        
        col_email.setCellValueFactory(new PropertyValueFactory("last_name"));
       
        Company_DAO company_DAO = new Company_DAO();       
        companys = company_DAO.select_company();
        table_company.setItems(companys); 
    }
    
    void search(){
        ObservableList<Company> company = FXCollections.observableArrayList();
        
        for (Company comp : companys) {
            if (comp.getName_company().contains(tf_search.getText())) {
                company.add(comp);
            }
        }
        table_company.setItems(company);  
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

                for (Company company : companys) {
                   doc.add(new Paragraph(lb_company.getText() + ": " + company.getName_company()));
                   doc.add(new Paragraph(lb_cnpj.getText() + ": " + company.getCnpj()));
                   doc.add(new Paragraph(lb_city.getText() + ": " + company.getCity()));
                   doc.add(new Paragraph(lb_phone.getText() + ": " + company.getPhone()));
                   doc.add(new Paragraph(lb_email.getText() + ": " + company.getEmail()));
                   com.itextpdf.text.Image image = com.itextpdf.text.Image.getInstance(company.getImg());
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
        Company_DAO company_DAO = new Company_DAO();
        try {
            company_DAO.deleta_company(company_selected);
            
            //Alert
            Interfaces.Interface_Alert.Alert("Companhia deletada com sucesso", "");
            
        } catch (SQLException ex) {
            Logger.getLogger(List_UsersController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    void change(){
        FileChooser fc = new FileChooser();
        fc.getExtensionFilters().add(new FileChooser.ExtensionFilter("Images", "*.jpg", "*.jpeg", "*.png"));
        File file = fc.showOpenDialog(new Stage());
        if (file != null)
            img_company_register.setImage(new Image("file:///" + file.getAbsolutePath()));
        img_file = "file:///" + file.getAbsolutePath();
    }
    
    void register(){
        if (tf_company.getText().equals("") || tf_cnpj.getText().equals("") || tf_phone.getText().equals("") || tf_email.getText().equals("") || 
            cb_city.getSelectionModel().isEmpty() || cb_state.getSelectionModel().isEmpty()) {
            
            //Alert
            Interfaces.Interface_Alert.Alert("Campos Nulos", "");
            
        } else {
            
            Company company = new Company(tf_company.getText(), tf_cnpj.getText(), cb_city.getSelectionModel().getSelectedItem() + " - " + cb_state.getSelectionModel().getSelectedItem(),
            tf_phone.getText(), tf_email.getText(), img_file);
                
            Company_DAO company_DAO = new Company_DAO();
            try {
                company_DAO.insert_company(company);
                    
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
        btn_delete_img.setOnMouseClicked(s -> img_company_register.setImage(new Image("/Images/sem-foto.jpg")));
        btn_register.setOnMouseClicked(s -> register());
        btn_cancel.setOnMouseClicked(s -> {
            Main screen = new Main();
            try {
                screen.start(new Stage());
                Manage_Company.getStage().close();
            } catch (Exception ex) {
                Logger.getLogger(Manage_Aircraft_ManufacturerController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        
        table_company.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {
            @Override
            public void changed(ObservableValue observable, Object oldValue, Object newValue) {
                if(newValue != null){
                    company_selected = (Company) newValue;
                    img_company.setImage(new Image(company_selected.getImg()));
                }else{
                    company_selected = null;
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
        init_table();
        add_css();
        action_buttons();
        language_adaptation();
    }    
    
}
