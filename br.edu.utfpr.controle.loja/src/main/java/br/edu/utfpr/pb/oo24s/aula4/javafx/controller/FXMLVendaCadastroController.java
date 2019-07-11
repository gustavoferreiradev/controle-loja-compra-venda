package br.edu.utfpr.pb.oo24s.aula4.javafx.controller;

import br.edu.utfpr.pb.oo24s.aula4.javafx.dao.ClienteDao;
import br.edu.utfpr.pb.oo24s.aula4.javafx.dao.ProdutoDao;
import br.edu.utfpr.pb.oo24s.aula4.javafx.dao.VendaDao;
import br.edu.utfpr.pb.oo24s.aula4.javafx.dao.VendaProdutoDao;
import br.edu.utfpr.pb.oo24s.aula4.javafx.model.Cliente;
import br.edu.utfpr.pb.oo24s.aula4.javafx.model.Produto;
import br.edu.utfpr.pb.oo24s.aula4.javafx.model.Venda;
import br.edu.utfpr.pb.oo24s.aula4.javafx.model.VendaProduto;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
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

public class FXMLVendaCadastroController implements Initializable {
    
    @FXML
    private TextField textId;
    
    @FXML
    private TextField textNumeroDocumento;
    
    @FXML
    private TextField textQuantidade;
    
    @FXML
    private DatePicker dateData;
    
    @FXML
    private DatePicker dateDataEntrega;
    
    @FXML
    private TextField textValor;
    
   
    @FXML
    private ComboBox<Cliente> comboCliente;
    
    @FXML
    private ComboBox<Produto> comboProduto;
    
    private VendaDao vendaDao;
    private VendaProdutoDao vendaProdutoDao;
    private ClienteDao clienteDao;
    private ProdutoDao produtoDao;
    private Stage stage;
    private Venda venda;
    private List<VendaProduto> vendaProdutos;
    
            
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        this.vendaDao = new VendaDao();
        this.vendaProdutoDao = new VendaProdutoDao();
        this.clienteDao = new ClienteDao();
        this.produtoDao = new ProdutoDao();
        ObservableList<Cliente> clientes = FXCollections.observableArrayList(clienteDao.getAll());
        ObservableList<Produto> produtos = FXCollections.observableArrayList(produtoDao.getAll());
        
        this.comboCliente.setItems(clientes);
        this.comboProduto.setItems(produtos);
        
        this.vendaProdutos = new ArrayList<>();
        
        setColumnProperties();
        
    }    
    public void setDialogStage(Stage stage){
        this.stage = stage;
    }
    
    public void setVenda(Venda venda){
        this.venda = venda;
        if (venda.getId() != null){
            textId.setText(venda.getId().toString());
            textNumeroDocumento.setText(venda.getNumeroDocumento());
            comboCliente.setValue(venda.getCliente());
            dateData.setValue(venda.getData());
            dateDataEntrega.setValue(venda.getDataEntrega());
        }
    }
    

    
    @FXML
    private void cancel(){
        this.stage.close();
    }
    
    @FXML
    private void save(){
        venda.setNumeroDocumento(textNumeroDocumento.getText());
        venda.setCliente(comboCliente.getSelectionModel().getSelectedItem());
        venda.setData(dateData.getValue());
        venda.setDataEntrega(dateDataEntrega.getValue());
        venda.setVendaProdutos(vendaProdutos);
        this.vendaDao.save(venda);
        this.stage.close();
        
    }
    
    @FXML
    private void add(){
        VendaProduto vp = new VendaProduto();
        vp.setVenda(venda);
        vp.setProduto(comboProduto.getSelectionModel().getSelectedItem());
        vp.setQuantidade(Integer.parseInt(textQuantidade.getText()));
        vp.setValor(Double.parseDouble(textValor.getText()));
        vendaProdutos.add(vp);
        loadData();
    }
    
     @FXML
    private TableView <VendaProduto> tableData;
    
    @FXML
    private TableColumn<VendaProduto, Produto> columnId;
    
    @FXML
    private TableColumn<VendaProduto,Produto> columnNome; 
    
    @FXML
    private TableColumn<VendaProduto,Integer> columnQuantidade; 
    
    @FXML
    private TableColumn<VendaProduto,Double> columnValor; 
       
   
    private ObservableList<VendaProduto> list = FXCollections.observableArrayList();
    
     private void setColumnProperties() {
        columnId.setCellValueFactory(new PropertyValueFactory<>("id"));
        columnNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
        columnQuantidade.setCellValueFactory(new PropertyValueFactory<>("quantidade"));
        columnValor.setCellValueFactory(new PropertyValueFactory<>("valor"));
    }
    
     private void loadData() {
        list.clear();
        list.addAll(vendaProdutos);
        
        tableData.setItems(list);
    }
}
