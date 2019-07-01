package br.edu.utfpr.pb.controle.loja.compra.venda.javafx.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

@Entity
@Table (name = "venda")
public class Venda implements Serializable {
      
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @NotNull (message = "Por favor preencha o número da Nota Fiscal!")
    @Column (name = "nf", length = 6, nullable = false)
    private Integer nf;
    
    @NotNull (message = "Por favor preencha a data de compra!")
    @Column (name = "data", nullable = false)
    private LocalDate data;
    
    @NotNull (message = "Selecione o cliente!")
    private Cliente cliente;
    
     @OneToMany(mappedBy = "venda", 
            cascade = {CascadeType.PERSIST,CascadeType.REMOVE},
            fetch = FetchType.LAZY)
    private List<VendaProduto> vendaProdutos;
     
    @Transient
    private Double valorTotal;
    
    public Double getValorTotal(){
        return vendaProdutos.stream().mapToDouble(vp -> vp.getValor() *
                vp.getQuantidade()).sum();
    }   
    public List<VendaProduto> getVendaProdutos() {
        return vendaProdutos;
    }

    public void setVendaProdutos(List<VendaProduto> vendaProdutos) {
        this.vendaProdutos = vendaProdutos;           
           
}
    
}
