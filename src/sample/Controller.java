package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;

public class Controller {

    private static final ObservableList<String> sexos = FXCollections.observableArrayList("Nenhum", "Homem", "Mulher");
    private static final ObservableList<String> faixaEtarias = FXCollections.observableArrayList("Nenhum", "i00a14", "i15a29", "i30a59", "i60a79", "i80ouMais");
    private static final ObservableList<String> regioes = FXCollections.observableArrayList("Nenhum", "CentroOeste", "Nordeste", "Norte", "Sudeste", "Sul");
    private static final ObservableList<String> classeSociais = FXCollections.observableArrayList("Nenhum", "State0", "State1");


    @FXML
    public ComboBox<String> sexo;

    @FXML
    public ComboBox<String> faixaEtaria;

    @FXML
    public ComboBox<String> regiao;

    @FXML
    public ComboBox<String> classesocial;

    @FXML
    private TextArea resultado;

    JSmile jSmile = new JSmile();

    @FXML
    public void initialize() {
        sexo.getItems().addAll(sexos);
        faixaEtaria.getItems().addAll(faixaEtarias);
        regiao.getItems().addAll(regioes);
        classesocial.getItems().addAll(classeSociais);
    }

    @FXML
    public void sexoChange() {
        if (!sexo.getValue().isEmpty())
            resultado.setText(jSmile.run("sexo", sexo.getValue()));
    }

    @FXML
    public void faixaEtariaChange() {
        if (!faixaEtaria.getValue().isEmpty())
            resultado.setText(jSmile.run("FaixaEtaria", faixaEtaria.getValue()));
    }

    @FXML
    public void regiaoChange() {
        if (!regiao.getValue().isEmpty())
            resultado.setText(jSmile.run("regiao", regiao.getValue()));
    }

    @FXML
    public void classeSocialChange() {
        if (!classesocial.getValue().isEmpty())
            resultado.setText(jSmile.run("classesocial", classesocial.getValue()));
    }

}
