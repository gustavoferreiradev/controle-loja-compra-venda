package br.edu.utfpr.pb.oo24s.aula4.javafx.controller;

import br.edu.utfpr.pb.oo24s.aula4.javafx.dao.CidadeDao;
import br.edu.utfpr.pb.oo24s.aula4.javafx.dao.ClienteDao;
import br.edu.utfpr.pb.oo24s.aula4.javafx.model.Cidade;
import br.edu.utfpr.pb.oo24s.aula4.javafx.model.Cliente;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class FXMLClienteCadastroController implements Initializable {
    
    @FXML
    private TextField textId;
    
    @FXML
    private TextField textNome;
    
    @FXML
    private TextField textCPF;
    
    @FXML
    private TextField textEndereco;
    
    @FXML
    private TextField textBairro;
    
    @FXML
    private TextField textCEP;
    
    @FXML
    private TextField textComplemento;
    
    @FXML
    private TextField textReferencia;
    
    @FXML
    private ComboBox<Cidade> comboCidade;
    
       
    private ClienteDao clienteDao;
    private CidadeDao cidadeDao;
    private Stage stage;
    private Cliente cliente;
    
    
            
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        this.clienteDao = new ClienteDao();
        this.cidadeDao = new CidadeDao();
        ObservableList<Cidade> cidades = FXCollections.observableArrayList(cidadeDao.getAll());
        
        this.comboCidade.setItems(cidades);
        
    }    
    public void setDialogStage(Stage stage){
        this.stage = stage;
    }
    
    public void setCliente(Cliente cliente){
        this.cliente = cliente;
        if (cliente.getId() != null){
            textId.setText(cliente.getId().toString());
            textNome.setText(cliente.getNome());
            textCPF.setText(cliente.getCpf());
            textEndereco.setText(cliente.getEndereco());
            textBairro.setText(cliente.getBairro());
            textCEP.setText(cliente.getCep().toString());
            textComplemento.setText(cliente.getComplemento());
            textReferencia.setText(cliente.getReferencia());
            comboCidade.setValue(cliente.getCidade());

        }
    }
    
    @FXML
    private void cancel(){
        this.stage.close();
    }
    
    @FXML
    private void save(){
        cliente.setNome(textNome.getText());
        cliente.setCpf((textCPF.getText()));
        cliente.setEndereco(textEndereco.getText());
        cliente.setBairro(textBairro.getText());
        cliente.setCep(Long.parseLong(textCEP.getText()));
        cliente.setReferencia(textReferencia.getText());
        cliente.setComplemento(textComplemento.getText());
        cliente.setCidade(comboCidade.getSelectionModel().getSelectedItem());
        this.clienteDao.save(cliente);
        this.stage.close();
        
    }
}
