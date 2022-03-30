import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;

public class cadLocal {

    @FXML
    private Button btcadastrar;

    @FXML
    private Button btcancelar;

    @FXML
    private TextField txtender;

    @FXML
    private TextField txtestabe;

    @FXML
    private TextField txtturno;

    @FXML
    void btcadastrar(ActionEvent event) {
        local local = new local();
        local.setEstabelecimento(txtestabe.getText());
        local.setEndereco(txtender.getText());
        local.setTurno(txtturno.getText());
        
        int id = 0;
        for(local l:App.locais) {
			if(l.getId() >= id) {
                id = l.getId();
            }
        }
        local.setId(id+1);

        
        
        App.locais.add(local);



        Alert a = new Alert(AlertType.INFORMATION);
        a.setTitle("Cadastro de local");
        a.setContentText("Cadastro realizado.");
        a.show();

        txtestabe.setText("");
        txtender.setText("");
        txtturno.setText("");

    }

    @FXML
    void btcancelar(ActionEvent event) {
        txtestabe.setText("");
        txtender.setText("");
        txtturno.setText("");
    }

}
