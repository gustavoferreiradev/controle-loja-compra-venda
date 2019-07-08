 package br.edu.utfpr.pb.oo24s.aula4.javafx.controller;

import br.edu.utfpr.pb.oo24s.aula4.javafx.dao.MarcaDao;
import br.edu.utfpr.pb.oo24s.aula4.javafx.model.Marca;
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
public class FXMLMarcaCadastroController implements Initializable {

    @FXML
    private TextField textId;
    @FXML
    private TextField textNome;

    private MarcaDao marcaDao;
    private Stage stage;
    private Marca marca;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.marcaDao = new MarcaDao();
        this.marca = new Marca();
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
        marca.setNome(
                textNome.getText());
        this.marcaDao.save(marca);
        
        this.stage.close();
    }

    public void setMarca(Marca marca) {
        this.marca = marca;
        if (marca.getId() != null) {
            this.textId.setText(marca.getId().toString());
            this.textNome.setText(
                    marca.getNome());
        }

    }
}
