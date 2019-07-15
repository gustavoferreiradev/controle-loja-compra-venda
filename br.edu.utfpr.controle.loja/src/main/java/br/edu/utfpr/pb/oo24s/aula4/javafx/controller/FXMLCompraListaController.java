package br.edu.utfpr.pb.oo24s.aula4.javafx.controller;

import br.edu.utfpr.pb.oo24s.aula4.javafx.dao.CompraDao;
import br.edu.utfpr.pb.oo24s.aula4.javafx.model.Compra;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class FXMLCompraListaController implements Initializable {
    @FXML
    private TableView <Compra> tableData;
    
    @FXML
    private TableColumn<Compra, Integer> columnId;
    
    @FXML
    private TableColumn<Compra,Integer> columnNF;   
    
    @FXML
    private TableColumn<Compra,Integer> columnFornecedor;   
       
    private CompraDao compraDao;
    
    private ObservableList<Compra> list = FXCollections.observableArrayList();
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       this.compraDao = new CompraDao();
       setColumnProperties();
       loadData();
    }    

    private void setColumnProperties() {
        columnId.setCellValueFactory(new PropertyValueFactory<>("id"));
        columnNF.setCellValueFactory(new PropertyValueFactory<>("nf"));
        columnNF.setCellValueFactory(new PropertyValueFactory<>("fornecedor"));
    }

    private void loadData() {
        list.clear();
        list.addAll(compraDao.getAll());
        
        tableData.setItems(list);
    }
    
     private void openForm(Compra compra, ActionEvent event) {
        try {
            //Carregar o arquivo fxml e cria um novo stage para a janela Modal
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(this.getClass().getResource("/fxml/FXMLCompraCadastro.fxml"));
            AnchorPane pane = (AnchorPane) loader.load();

            //Criando o stage para o modal
            Stage dialogStage = new Stage();
            dialogStage.setTitle("Cadastro de Compra");
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initOwner(((Node) event.getSource()).getScene().getWindow());

            Scene scene = new Scene(pane);
            dialogStage.setScene(scene);

            FXMLCompraCadastroController controller = loader.getController();
            controller.setCompra(compra);
            controller.setDialogStage(dialogStage);
            //Exibe a janela Modal e espera até o usuário fechar
            dialogStage.showAndWait();
        } catch (Exception e) {
            e.printStackTrace();
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erro");
            alert.setHeaderText("Ocorreu um erro ao abrir a janela do cadastro");
            alert.setContentText("Por favor, tente realizar a operação novamente!");
            alert.showAndWait();
        }

        loadData();
    }

    @FXML
    private void edit(ActionEvent event) {
        Compra compra = tableData.getSelectionModel().getSelectedItem();
        this.openForm(compra, event);
    }

    @FXML
    private void newRecord(ActionEvent event) {
        this.openForm(new Compra(), event);
    }

    @FXML
    private void delete(ActionEvent event) {
        if (tableData.getSelectionModel().getSelectedIndex() >= 0) {
            try {
               Compra compra = tableData.getSelectionModel().getSelectedItem();
               compraDao.delete(compra.getId());
               tableData.getItems().remove(tableData.getSelectionModel().getSelectedIndex());
            } catch (Exception e) {
                e.printStackTrace();
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Erro");
                alert.setHeaderText("Ocorreu um erro ao remover o registro");
                alert.setContentText("Por favor, tente realizar a operação novamente!");
                alert.showAndWait();
            }
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erro");
            alert.setHeaderText("Nenhum registro selecionado");
            alert.setContentText("Por favor, selecione um registro na tabela!");
            alert.showAndWait();
        }
    }

    
    
    
}
