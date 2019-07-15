package br.edu.utfpr.pb.oo24s.aula4.javafx.controller;

import br.edu.utfpr.pb.oo24s.aula4.javafx.dao.CidadeDao;
import br.edu.utfpr.pb.oo24s.aula4.javafx.dao.EstadoDao;
import br.edu.utfpr.pb.oo24s.aula4.javafx.model.Cidade;
import br.edu.utfpr.pb.oo24s.aula4.javafx.model.Estado;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class FXMLCidadeCadastroController implements Initializable {
    
    @FXML
    private TextField textId;
    
    @FXML
    private TextField textNome;
     
    @FXML
    private ComboBox<Estado> comboEstado;
    
       
    private CidadeDao cidadeDao;
    private EstadoDao estadoDao;
    private Stage stage;
    private Cidade cidade;
    
            
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        this.cidadeDao = new CidadeDao();
        this.estadoDao = new EstadoDao();
        ObservableList<Estado> estados = FXCollections.observableArrayList(estadoDao.getAll());
        
        this.comboEstado.setItems(estados);
        
    }    
    public void setDialogStage(Stage stage){
        this.stage = stage;
    }
    
    public void setCidade(Cidade cidade){
        this.cidade = cidade;
        if (cidade.getId() != null){
            textId.setText(cidade.getId().toString());
            textNome.setText(cidade.getNome());
            comboEstado.setValue(cidade.getEstado());

        }
    }
    
    @FXML
    private void cancel(){
        this.stage.close();
    }
    
    @FXML
    private void save(){
        cidade.setNome(textNome.getText());
        cidade.setEstado(comboEstado.getSelectionModel().getSelectedItem());
        this.cidadeDao.save(cidade);
        this.stage.close();
        
    }
}
