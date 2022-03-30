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

public class ConsShow implements Initializable{

    @FXML
    private Button btexcluir;

    @FXML
    private TableColumn<cantor, String> clcantor;

    @FXML
    private TableColumn<show, String> cldata;

    @FXML
    private TableColumn<local, String> cllocal;

    @FXML
    private TableView<show> tbshows;

    @FXML
    void btexcluir(ActionEvent event) throws IOException {
        show s = tbshows.getSelectionModel().getSelectedItem();
        if(s == null) {
            Alert a = new Alert(AlertType.ERROR);
            a.setTitle("Atenção");
            a.setContentText("Selecione o show a ser excluido.");
            a.show();
        }
        else {
            App.shows.remove(s);
            Alert a = new Alert(AlertType.INFORMATION);
            a.setTitle("Exclusão de Show");
            a.setContentText("Show cancelado");
            a.show();
            
            App.mostrarShows();
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        clcantor.setCellValueFactory(new PropertyValueFactory<>("cantorNome"));
        cldata.setCellValueFactory(new PropertyValueFactory<>("data"));
        cllocal.setCellValueFactory(new PropertyValueFactory<>("localEstabelecimento"));


        for(show sho:App.shows) {
			tbshows.getItems().add(sho);
        }
    }

}
