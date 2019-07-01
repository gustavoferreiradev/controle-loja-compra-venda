package br.edu.utfpr.pb.controle.loja.compra.venda.javafx.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
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
@Table (name = "compra")
public class Compra implements Serializable{
    
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @NotNull (message = "Por favor preencha o número da Nota Fiscal!")
    @Column (name = "nf", length = 6, nullable = false)
    private Integer nf;
    
    @NotNull (message = "Por favor preencha a data de compra!")
    @Column (name = "data", nullable = false)
    private LocalDate data;
    
    @NotNull (message = "Selecione o fornecedor!")
    private Fornecedor fornecedor;
    
     @OneToMany(mappedBy = "compra", 
            cascade = {CascadeType.PERSIST,CascadeType.REMOVE},
            fetch = FetchType.LAZY)
    private List<CompraProduto> compraProdutos;
     
    @Transient
    private Double valorTotal;
    
    public Double getValorTotal(){
        return compraProdutos.stream().mapToDouble(vp -> vp.getValor() *
                vp.getQuantidade()).sum();
    }   
    public List<CompraProduto> getCompraProdutos() {
        return compraProdutos;
    }

    public void setCompraProdutos(List<CompraProduto> compraProdutos) {
        this.compraProdutos = compraProdutos;           
           
}

    public Compra() {
    }

    public Compra(Integer id, Integer nf, LocalDate data, Fornecedor fornecedor, List<CompraProduto> compraProdutos, Double valorTotal) {
        this.id = id;
        this.nf = nf;
        this.data = data;
        this.fornecedor = fornecedor;
        this.compraProdutos = compraProdutos;
        this.valorTotal = valorTotal;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getNf() {
        return nf;
    }

    public void setNf(Integer nf) {
        this.nf = nf;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public Fornecedor getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 71 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Compra other = (Compra) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Compra{" + "id=" + id + ", nf=" + nf + ", data=" + data + ", fornecedor=" + fornecedor + ", compraProdutos=" + compraProdutos + ", valorTotal=" + valorTotal + '}';
    }


    
    

}
    

