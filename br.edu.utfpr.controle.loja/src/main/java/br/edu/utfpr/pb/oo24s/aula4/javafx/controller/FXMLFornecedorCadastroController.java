package br.edu.utfpr.pb.oo24s.aula4.javafx.controller;

import br.edu.utfpr.pb.oo24s.aula4.javafx.dao.CidadeDao;
import br.edu.utfpr.pb.oo24s.aula4.javafx.dao.FornecedorDao;
import br.edu.utfpr.pb.oo24s.aula4.javafx.model.Cidade;
import br.edu.utfpr.pb.oo24s.aula4.javafx.model.Fornecedor;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class FXMLFornecedorCadastroController implements Initializable {
    
    @FXML
    private TextField textId;
    
    @FXML
    private TextField textNome;
    
    @FXML
    private TextField textCNPJ;
    
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
    
       
    private FornecedorDao fornecedorDao;
    private CidadeDao cidadeDao;
    private Stage stage;
    private Fornecedor fornecedor;
    
    
            
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        this.fornecedorDao = new FornecedorDao();
        this.cidadeDao = new CidadeDao();
        ObservableList<Cidade> cidades = FXCollections.observableArrayList(cidadeDao.getAll());
        
        this.comboCidade.setItems(cidades);
        
    }    
    public void setDialogStage(Stage stage){
        this.stage = stage;
    }
    
    public void setFornecedor(Fornecedor fornecedor){
        this.fornecedor = fornecedor;
        if (fornecedor.getId() != null){
            textId.setText(fornecedor.getId().toString());
            textNome.setText(fornecedor.getNome());
            textCNPJ.setText(fornecedor.getCnpj().toString());
            textEndereco.setText(fornecedor.getEndereco());
            textBairro.setText(fornecedor.getBairro());
            textCEP.setText(fornecedor.getCep().toString());
            textComplemento.setText(fornecedor.getComplemento());
            textReferencia.setText(fornecedor.getReferencia());
            comboCidade.setValue(fornecedor.getCidade());

        }
    }
    
    @FXML
    private void cancel(){
        this.stage.close();
    }
    
    @FXML
    private void save(){
        fornecedor.setNome(textNome.getText());
        fornecedor.setCnpj(Long.parseLong(textCNPJ.getText()));
        fornecedor.setEndereco(textEndereco.getText());
        fornecedor.setBairro(textBairro.getText());
        fornecedor.setCep(Long.parseLong(textCEP.getText()));
        fornecedor.setReferencia(textReferencia.getText());
        fornecedor.setComplemento(textComplemento.getText());
        fornecedor.setCidade(comboCidade.getSelectionModel().getSelectedItem());
        this.fornecedorDao.save(fornecedor);
        this.stage.close();
        
    }
}
