import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;

public class cadCantor {

    @FXML
    private Button btcadastrar;

    @FXML
    private Button btcancelar;

    @FXML
    private TextField txtgenero;

    @FXML
    private TextField txtnome;

    @FXML
    void btcadastrar(ActionEvent event) {
        cantor cantor = new cantor();
        cantor.setNome(txtnome.getText());
        cantor.setGenero(txtgenero.getText());
        
        int id = 0;
        for(cantor c:App.cantores) {
			if(c.getId() >= id) {
                id = c.getId();
            }
        }
        cantor.setId(id+1);

        
        
        App.cantores.add(cantor);



        Alert a = new Alert(AlertType.INFORMATION);
        a.setTitle("Cadastro de cantor");
        a.setContentText("Cadastro realizado.");
        a.show();

        txtnome.setText("");
        txtgenero.setText("");

    }

    @FXML
    void btcancelar(ActionEvent event) {
        txtnome.setText("");
        txtgenero.setText("");
    }

}
