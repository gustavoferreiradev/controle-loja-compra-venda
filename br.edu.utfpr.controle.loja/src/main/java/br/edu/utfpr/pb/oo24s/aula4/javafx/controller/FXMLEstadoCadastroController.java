 package br.edu.utfpr.pb.oo24s.aula4.javafx.controller;

import br.edu.utfpr.pb.oo24s.aula4.javafx.dao.EstadoDao;
import br.edu.utfpr.pb.oo24s.aula4.javafx.model.Estado;
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
public class FXMLEstadoCadastroController implements Initializable {

    @FXML
    private TextField textId;
    @FXML
    private TextField textNome;

    private EstadoDao estadoDao;
    private Stage stage;
    private Estado estado;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.estadoDao = new EstadoDao();
        this.estado = new Estado();
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
        estado.setNome(
                textNome.getText());
        this.estadoDao.save(estado);
        
        this.stage.close();
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
        if (estado.getId() != null) {
            this.textId.setText(estado.getId().toString());
            this.textNome.setText(
                    estado.getNome());
        }

    }
}
