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
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;

public class consCantor implements Initializable{

    @FXML
    private Button bteditar;

    @FXML
    private Button btexcluir;

    @FXML
    private TableColumn<cantor, String> colunacantores;

    @FXML
    private TableColumn<cantor, String> colunageneros;

    @FXML
    private TableView<cantor> tbcantores;

    @FXML
    void bteditar(ActionEvent event) throws IOException {
                
        cantor c = tbcantores.getSelectionModel().getSelectedItem();
        
        if(c == null) {
            Alert a = new Alert(AlertType.ERROR);
            a.setTitle("Atenção");
            a.setContentText("Selecione um cantor na tabela para fazer a edição.");
            a.show();
        }
        else {
                App.mostrarEditorCantor(c);
    
        }
    }

    @FXML
    void btexcluir(ActionEvent event) throws IOException {
    cantor c = tbcantores.getSelectionModel().getSelectedItem();
        if(c == null) {
            Alert a = new Alert(AlertType.ERROR);
            a.setTitle("Ei bixo!");
            a.setContentText("Tu precisa escolher um cantor para excluir.");
            a.show();
        }
        else {
            App.cantores.remove(c);
            Alert a = new Alert(AlertType.INFORMATION);
            a.setTitle("Exclusão de Cliente");
            a.setContentText("Cadastro excluído com sucesso!");
            a.show();
            App.mostrarConsulta();
        }

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        colunacantores.setCellValueFactory(new PropertyValueFactory<>("nome"));
        colunageneros.setCellValueFactory(new PropertyValueFactory<>("genero"));

        for(cantor can:App.cantores) {
			tbcantores.getItems().add(can);
        }
    }


}

