import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;

public class cadShow implements Initializable{

    @FXML
    private Button btcadastrar;

    @FXML
    private Button btcancelar;

    @FXML
    private TableColumn<cantor, String> clcantor;

    @FXML
    private TableColumn<cantor, String> clgenero;

    @FXML
    private TableColumn<local, String> cllocal;

    @FXML
    private TableColumn<local, String> clturno;

    @FXML
    private TableView<cantor> tbartista;

    @FXML
    private TableView<local> tblocal;

    @FXML
    private TextField txtcache;

    @FXML
    private TextField txtdata;

    @FXML
    void btcadastrar(ActionEvent event) throws IOException {

    cantor c = tbartista.getSelectionModel().getSelectedItem();
    local l = tblocal.getSelectionModel().getSelectedItem();
        
    if(c == null || l == null) {
    Alert a = new Alert(AlertType.ERROR);
    a.setTitle("Atenção");
    a.setContentText("Tu não selecionou um cantor e um local.");
    a.show();
    }
    else if(txtcache.getText() == "" || txtdata.getText() == ""){
        Alert x = new Alert(AlertType.ERROR);
        x.setTitle("Atenção");
        x.setContentText("É necessário data e pagamento");
        x.show();
    }
    else {
        show show = new show();
        
        int id = 0;
        for(show s:App.shows) {
            if(s.getId() >= id) {
                id = s.getId();
            }
        }
        show.setId(id+1); 
        
        show.setCache(txtcache.getText());
        show.setData(txtdata.getText());


        show.setCantor(c);
        show.setLocal(l);
            
        App.shows.add(show);
            
        
        Alert a = new Alert(AlertType.INFORMATION);
        a.setTitle("Cadastro de show");
        a.setContentText("O show foi marcado!");
        a.show();
        
        txtdata.setText("");
        txtcache.setText("");

        }
    }

    @FXML
    void btcancelar(ActionEvent event) {
        txtdata.setText("");
        txtcache.setText("");
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {

        clcantor.setCellValueFactory(new PropertyValueFactory<>("nome"));

        clgenero.setCellValueFactory(new PropertyValueFactory<>("genero"));
        cllocal.setCellValueFactory(new PropertyValueFactory<>("estabelecimento"));
        clturno.setCellValueFactory(new PropertyValueFactory<>("turno"));

        for(cantor can:App.cantores) {
			tbartista.getItems().add(can);
        }

        for(local l:App.locais) {
			tblocal.getItems().add(l);
        }
    }



}
