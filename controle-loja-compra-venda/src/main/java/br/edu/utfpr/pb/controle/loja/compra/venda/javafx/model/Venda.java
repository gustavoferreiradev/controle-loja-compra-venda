package br.edu.utfpr.pb.controle.loja.compra.venda.javafx.model;

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
@Table (name = "venda")
public class Venda implements AbstractModel{
      
    private static final long serialVersionUID = 1L;
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

    public Venda() {
    }

    public Venda(Integer id, Integer nf, LocalDate data, Cliente cliente, List<VendaProduto> vendaProdutos, Double valorTotal) {
        this.id = id;
        this.nf = nf;
        this.data = data;
        this.cliente = cliente;
        this.vendaProdutos = vendaProdutos;
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

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 79 * hash + Objects.hashCode(this.id);
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
        final Venda other = (Venda) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Venda{" + "id=" + id + ", nf=" + nf + ", data=" + data + ", cliente=" + cliente + ", vendaProdutos=" + vendaProdutos + ", valorTotal=" + valorTotal + '}';
    }
    
    
    
}
