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

public class ediLocal implements Initializable{
    private String estabelecimento;
    private String endereco;
    private String turno;
    private int id;
    @FXML
    private Button btcancelar;

    @FXML
    private Button btsalvar;

    @FXML
    private TextField txtediender;

    @FXML
    private TextField txtediesta;

    @FXML
    private TextField txtediturno;

    @FXML
    private Label txtid;

    @FXML
    void btcancelar(ActionEvent event) throws IOException {
        App.mostrarLocais();
    }

    @FXML
    void btsalvar(ActionEvent event) throws IOException {
        
        for(local loc:App.locais) {
			if(loc.getId() == this.id) {
                System.out.println("ID encontrado para " + loc.getEstabelecimento());
                loc.setEndereco(txtediender.getText());
                loc.setEstabelecimento(txtediesta.getText());
                loc.setTurno(txtediturno.getText());
            }
        }

        Alert a = new Alert(AlertType.INFORMATION);
        a.setTitle("Alteração de Local");
        a.setContentText("Atualização completa!");
        a.show();
        
        App.mostrarLocais();

    }
    public ediLocal(String estabelecimento, String endereco, int id, String turno){
        this.estabelecimento = estabelecimento;
        this.endereco = endereco;
        this.id = id;
        this.turno = turno;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        txtediender.setText(endereco);
        txtediesta.setText(estabelecimento);
        txtediturno.setText(turno);
        txtid.setText(Integer.toString(id));

        
    }
}
