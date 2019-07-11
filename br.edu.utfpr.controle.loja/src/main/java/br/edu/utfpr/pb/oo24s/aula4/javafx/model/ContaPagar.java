package br.edu.utfpr.pb.oo24s.aula4.javafx.model;

import java.time.LocalDate;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;


@Entity
@Table (name = "contaPagar")
public class ContaPagar implements AbstractModel{
    
    private static final long serialVersionUID = 1L;
     
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer id;
    
   @NotEmpty (message = "o tipo de pagamento deve ser preenchido!")
   @Column (name = "tipoPagamento", length = 100, nullable = false)
   private String tipoPagamento;
   
   @NotEmpty (message = "A Descrição deve ser preenchida!")
   @Column (name = "descricao", length = 100, nullable = false)
   private String descricao;
   
   @NotNull (message = "Preencha o valor da compra!")
   @Column (name = "valor", nullable = false)
   private Double valor;
   
   @NotNull (message = "Preencha a data de vencimento!")
   @Column(name = "dataVencimento", nullable = false)
   private LocalDate dataVencimento;

    public ContaPagar() {
    }
   
   
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTipoPagamento() {
        return tipoPagamento;
    }

    public void setTipoPagamento(String tipoPagamento) {
        this.tipoPagamento = tipoPagamento;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }        

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public LocalDate getDataVencimento() {
        return dataVencimento;
    }

    public void setDataVencimento(LocalDate dataVencimento) {
        this.dataVencimento = dataVencimento;
    }  

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + Objects.hashCode(this.id);
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
        final ContaPagar other = (ContaPagar) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ContaPagar{" + "id=" + id + ", tipoPagamento=" + tipoPagamento + ", descricao=" + descricao + ", valor=" + valor + ", dataVencimento=" + dataVencimento + '}';
    }

   
    
}
