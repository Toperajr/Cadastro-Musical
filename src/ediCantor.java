import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;

public class ediCantor implements Initializable {
    private String nome;
    private String genero;
    private int id;
    @FXML
    private Button edican;

    @FXML
    private TextField edigenero;

    @FXML
    private TextField edinome;

    @FXML
    private Button edisal;

    @FXML
    private Label idcan;

    @FXML
    void edican(ActionEvent event) throws IOException {
        App.mostrarConsulta();

    }

    @FXML
    void edisal(ActionEvent event) throws IOException {
        
        for(cantor can:App.cantores) {
			if(can.getId() == this.id) {
                System.out.println("ID encontrado para " + can.getNome());
                can.setNome(edinome.getText());
                can.setGenero(edigenero.getText());
            }
        }

        Alert a = new Alert(AlertType.INFORMATION);
        a.setTitle("Alteração de cantor");
        a.setContentText("Atualização completa!");
        a.show();
        
        App.mostrarConsulta();

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        edinome.setText(nome);
        edigenero.setText(genero);
        idcan.setText(Integer.toString(id));
        
    }
    public ediCantor(String nome, String genero, int id){
        this.nome = nome;
        this.genero = genero;
        this.id = id;
    }

}
