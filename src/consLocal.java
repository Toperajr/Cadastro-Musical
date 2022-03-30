import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class consLocal implements Initializable {

    @FXML
    private Button bteditar;

    @FXML
    private Button btexcluir;

    @FXML
    private TableColumn<local, String> colunaender;

    @FXML
    private TableColumn<local, String> colunalocal;

    @FXML
    private TableColumn<local, String> colunaturno;

    @FXML
    private TableView<local> tblocais;

    @FXML
    void bteditar(ActionEvent event) throws IOException {
                        
        local l = tblocais.getSelectionModel().getSelectedItem();
        
        if(l == null) {
            Alert a = new Alert(AlertType.ERROR);
            a.setTitle("Atenção");
            a.setContentText("Selecione um cliente na tabe.");
            a.show();
        }
        else {
                App.mostrarEditorLocal(l);
    
        }
    }

    @FXML
    void btexcluir(ActionEvent event) throws IOException {
        local l = tblocais.getSelectionModel().getSelectedItem();
        if(l == null) {
            Alert a = new Alert(AlertType.ERROR);
            a.setTitle("Ei bixo!");
            a.setContentText("Tu precisa escolher um local para excluir.");
            a.show();
        }
        else {
            App.locais.remove(l);
            Alert a = new Alert(AlertType.INFORMATION);
            a.setTitle("Exclusão de Cliente");
            a.setContentText("Cadastro excluído com sucesso!");
            a.show();
            App.mostrarLocais();
        }

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        colunalocal.setCellValueFactory(new PropertyValueFactory<>("estabelecimento"));
        colunaender.setCellValueFactory(new PropertyValueFactory<>("endereco"));
        colunaturno.setCellValueFactory(new PropertyValueFactory<>("turno"));

        for(local loc:App.locais) {
			tblocais.getItems().add(loc);
        }
    }

}
