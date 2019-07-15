 package br.edu.utfpr.pb.oo24s.aula4.javafx.controller;

import br.edu.utfpr.pb.oo24s.aula4.javafx.dao.FormaPagamentoDao;
import br.edu.utfpr.pb.oo24s.aula4.javafx.model.FormaPagamento;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Vinicius
 */
public class FXMLFormaPagamentoCadastroController implements Initializable {

    @FXML
    private TextField textId;
    @FXML
    private TextField textDescricao;

    private FormaPagamentoDao formaPagamentoDao;
    private Stage stage;
    private FormaPagamento formaPagamento;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.formaPagamentoDao = new FormaPagamentoDao();
        this.formaPagamento = new FormaPagamento();
    }

    public void setDialogStage(Stage stage) {
        this.stage = stage;
    }

    @FXML
    private void cancel() {
        this.stage.close();
    }

    @FXML
    private void save() {
        formaPagamento.setDescricao(
                textDescricao.getText());
        this.formaPagamentoDao.save(formaPagamento);
        
        this.stage.close();
    }

    public void setFormaPagamento(FormaPagamento formaPagamento) {
        this.formaPagamento = formaPagamento;
        if (formaPagamento.getId() != null) {
            this.textId.setText(formaPagamento.getId().toString());
            this.textDescricao.setText(
                    formaPagamento.getDescricao());
        }

    }
}
