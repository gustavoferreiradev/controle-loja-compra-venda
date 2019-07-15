package br.edu.utfpr.pb.oo24s.aula4.javafx.controller;

import br.edu.utfpr.pb.oo24s.aula4.javafx.dao.FornecedorDao;
import br.edu.utfpr.pb.oo24s.aula4.javafx.dao.ProdutoDao;
import br.edu.utfpr.pb.oo24s.aula4.javafx.dao.CompraDao;
import br.edu.utfpr.pb.oo24s.aula4.javafx.dao.CompraProdutoDao;
import br.edu.utfpr.pb.oo24s.aula4.javafx.model.Fornecedor;
import br.edu.utfpr.pb.oo24s.aula4.javafx.model.Produto;
import br.edu.utfpr.pb.oo24s.aula4.javafx.model.Compra;
import br.edu.utfpr.pb.oo24s.aula4.javafx.model.CompraProduto;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class FXMLCompraCadastroController implements Initializable {

    @FXML
    private TextField textId;

    @FXML
    private TextField textNF;

    @FXML
    private TextField textQuantidade;

    @FXML
    private DatePicker dateData;


    @FXML
    private TextField textValor;

    @FXML
    private ComboBox<Fornecedor> comboFornecedor;

    @FXML
    private ComboBox<Produto> comboProduto;


    private CompraDao compraDao;
    private CompraProdutoDao compraProdutoDao;
    private FornecedorDao fornecedorDao;
    private ProdutoDao produtoDao;
    private Stage stage;
    private Compra compra;
    private List<CompraProduto> compraProdutos;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        this.compraDao = new CompraDao();
        this.compraProdutoDao = new CompraProdutoDao();
        this.fornecedorDao = new FornecedorDao();
        this.produtoDao = new ProdutoDao();
        ObservableList<Fornecedor> fornecedores = FXCollections.observableArrayList(fornecedorDao.getAll());
        ObservableList<Produto> produtos = FXCollections.observableArrayList(produtoDao.getAll());
        
        
        this.comboFornecedor.setItems(fornecedores);
        this.comboProduto.setItems(produtos);
        this.compraProdutos = new ArrayList<>();

        setColumnProperties();

    }

    public void setDialogStage(Stage stage) {
        this.stage = stage;
    }

    public void setCompra(Compra compra) {
        this.compra = compra;
        if (compra.getId() != null) {
            textId.setText(compra.getId().toString());
            textNF.setText(compra.getNf().toString());
            comboFornecedor.setValue(compra.getFornecedor());
            dateData.setValue(compra.getData());
            

        }
    }

      
        

    

    
    @FXML
    private void cancel(){
        this.stage.close();
    }
    
    @FXML
    private void save(){
        compra.setNf(Integer.parseInt(textNF.getText()));
        compra.setFornecedor(comboFornecedor.getSelectionModel().getSelectedItem());
        compra.setData(dateData.getValue());
       
       
        compra.setCompraProdutos(compraProdutos);
        this.compraDao.save(compra);
        this.stage.close();
        
    }
    
    @FXML
    private void add(){
        CompraProduto vp = new CompraProduto();
        vp.setCompra(compra);
        vp.setProduto(comboProduto.getSelectionModel().getSelectedItem());
        vp.setQuantidade(Integer.parseInt(textQuantidade.getText()));
        vp.setValor(Double.parseDouble(textValor.getText()));
        compraProdutos.add(vp);
        loadData();
    }
    
     @FXML
    private TableView <CompraProduto> tableData;
    
    @FXML
    private TableColumn<CompraProduto, String> columnId;
    
    @FXML
    private TableColumn<CompraProduto, String> columnNome; 
    
    @FXML
    private TableColumn<CompraProduto,Integer> columnQuantidade; 
    
    @FXML
    private TableColumn<CompraProduto,Double> columnValor; 
       
   
    private ObservableList<CompraProduto> list = FXCollections.observableArrayList();
    
     private void setColumnProperties() {
        columnId.setCellValueFactory((param) -> new SimpleStringProperty(param.getValue().getProduto().getId().toString()));
        columnNome.setCellValueFactory((param) -> new SimpleStringProperty(param.getValue().getProduto().getNome()));
        
        columnQuantidade.setCellValueFactory(new PropertyValueFactory<>("quantidade"));
        columnValor.setCellValueFactory(new PropertyValueFactory<>("valor"));
    }
    
     private void loadData() {
        list.clear();
        list.addAll(compraProdutos);
        
        tableData.setItems(list);
    }
}
