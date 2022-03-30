import java.io.IOException;
import java.util.ArrayList;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class App extends Application {
    private Stage primaryStage;
    private static BorderPane telas;

    public static ArrayList<cantor> cantores;
    public static ArrayList<local> locais;
    public static ArrayList<show> shows;


    public static void main(String[] args) throws Exception {

        cantores = new ArrayList<cantor>();
        locais = new ArrayList<local>();
        shows = new ArrayList<show>();

        launch(args);
    }

    public void start(Stage primaryStage) throws Exception {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("Gerenciador de shows");
        carregarTelaInicial();
    }
    void carregarTelaInicial() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("telas/telaInicial.fxml"));
        telas = loader.load();
        Scene tela = new Scene(telas);
        primaryStage.setScene(tela);
        primaryStage.show();
    }

    @FXML
    void cadastrarCantor(ActionEvent event) throws IOException{
        App.mostrarCadastroCantor();
    }

    @FXML
    void cadastrarLocal(ActionEvent event) throws IOException{
        App.mostrarCadastroLocal();
    }
    @FXML
    void cadastrarShow(ActionEvent event) throws IOException{
        App.mostrarCadastroShow();
    }
    @FXML
    void consultarlista(ActionEvent event) throws IOException{
        App.mostrarConsulta();
    }
    @FXML 
    void consultarlocais(ActionEvent event) throws IOException{
        App.mostrarLocais();
    }
    @FXML 
    void consultarShows(ActionEvent event) throws IOException{
        App.mostrarShows();
    }

    public static void mostrarCadastroCantor() throws IOException {
        FXMLLoader loader = new FXMLLoader(App.class.getResource("telas/cadCantor.fxml"));
        BorderPane cadCantor = loader.load();
        telas.setCenter(cadCantor);
    }
    public static void mostrarCadastroLocal() throws IOException {
        FXMLLoader loader = new FXMLLoader(App.class.getResource("telas/cadLocal.fxml"));
        BorderPane cadLocal = loader.load();
        telas.setCenter(cadLocal);
    }
    public static void mostrarCadastroShow() throws IOException {
        FXMLLoader loader = new FXMLLoader(App.class.getResource("telas/cadShow.fxml"));
        BorderPane cadShow = loader.load();
        telas.setCenter(cadShow);
    }
    public static void mostrarEditorCantor(cantor c) throws IOException {
        FXMLLoader loader = new FXMLLoader(App.class.getResource("telas/ediCantor.fxml"));
        ediCantor cantor = new ediCantor(c.getNome(), c.getGenero(), c.getId());
        loader.setController(cantor);
        BorderPane editarCantor = loader.load();
        telas.setCenter(editarCantor);
    }

    public static void mostrarEditorLocal(local l) throws IOException {
        FXMLLoader loader = new FXMLLoader(App.class.getResource("telas/ediLocal.fxml"));
        ediLocal local = new ediLocal(l.getEstabelecimento(), l.getEndereco(), l.getId(), l.getTurno());
        loader.setController(local);
        BorderPane editarLocal = loader.load();
        telas.setCenter(editarLocal);
    }
    public static void mostrarShows() throws IOException {
        FXMLLoader loader = new FXMLLoader(App.class.getResource("telas/ConsShow.fxml"));
        BorderPane ConsShow = loader.load();
        telas.setCenter(ConsShow);
    }

    public static void mostrarConsulta() throws IOException {
        FXMLLoader loader = new FXMLLoader(App.class.getResource("telas/consCantor.fxml"));
        BorderPane consCantor = loader.load();
        telas.setCenter(consCantor);
    }
    public static void mostrarLocais() throws IOException {
        FXMLLoader loader = new FXMLLoader(App.class.getResource("telas/consLocal.fxml"));
        BorderPane consLocal = loader.load();
        telas.setCenter(consLocal);
    }
    

}
