package br.edu.utfpr.pb.oo24s.aula4.javafx.controller;

import br.edu.utfpr.pb.oo24s.aula4.javafx.dao.ContaPagarDao;
import br.edu.utfpr.pb.oo24s.aula4.javafx.model.ContaPagar;
import java.net.URL;

import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class FXMLContaPagarCadastroController implements Initializable {

    @FXML
    private TextField textId;
    @FXML
    private TextField textDescricao;
    @FXML
    private TextField textPagamento;
    @FXML
    private TextField textValor;
    @FXML
    private DatePicker dateData;

    private ContaPagar contaPagar;
    private ContaPagarDao contaPagarDao;
    private Stage dialogStage;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.contaPagarDao = new ContaPagarDao();
        this.contaPagar = new ContaPagar();
    }

    void setContaPagar(ContaPagar contaPagar) {
        this.contaPagar = contaPagar;
        if (contaPagar.getId() != null) {
            textId.setText(contaPagar.getId().toString());
            textDescricao.setText(contaPagar.getDescricao());
            textPagamento.setText(contaPagar.getTipoPagamento());
            textValor.setText(contaPagar.getValor().toString());
            dateData.setValue(contaPagar.getDataVencimento());
          
        }
    }

    void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }

   

    @FXML
    private void cancel() {
        this.dialogStage.close();
    }

    @FXML
    private void save() {

        contaPagar.setDescricao(textDescricao.getText());
        contaPagar.setTipoPagamento(textPagamento.getText());
        contaPagar.setValor(Double.parseDouble(textValor.getText()));
        contaPagar.setDataVencimento(dateData.getValue());
            
        this.contaPagarDao.save(contaPagar);        
        this.dialogStage.close();
        
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erro");
            alert.setHeaderText("Nenhum registro selecionado");
            alert.setContentText(this.contaPagarDao.getErrors(contaPagar));
            alert.showAndWait();

    }
}
