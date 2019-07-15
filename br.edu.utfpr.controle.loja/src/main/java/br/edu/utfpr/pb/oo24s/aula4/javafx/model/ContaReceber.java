package br.edu.utfpr.pb.oo24s.aula4.javafx.model;

import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table (name = "contaReceber")
public class ContaReceber implements AbstractModel{
    
    private static final long serialVersionUID = 1L;
    
   @Id
   @GeneratedValue (strategy = GenerationType.IDENTITY)
   private Integer id;
   
//   @NotNull (message = "Preencha o código da venda!")
//   @OneToOne
//   @JoinColumn (name = "venda_id", referencedColumnName = "id")
//   private Venda venda;
   
   @NotNull (message = "Selecione uma forma de pagamento!")
   @ManyToOne
   @JoinColumn(name = "formaPagamento_id", referencedColumnName = "id")
   private FormaPagamento formaPagamento;

    public ContaReceber() {
    }

    public ContaReceber(Integer id, Venda venda, FormaPagamento formaPagamento) {
        this.id = id;
//        this.venda = venda;
        this.formaPagamento = formaPagamento;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

//    public Venda getVenda() {
//        return venda;
//    }
//
//    public void setVenda(Venda venda) {
//        this.venda = venda;
//    }

    public FormaPagamento getFormaPagamento() {
        return formaPagamento;
    }

    public void setFormaPagamento(FormaPagamento formaPagamento) {
        this.formaPagamento = formaPagamento;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 89 * hash + Objects.hashCode(this.id);
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
        final ContaReceber other = (ContaReceber) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
    
   
   
   
}
