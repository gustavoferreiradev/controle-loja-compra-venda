package br.edu.utfpr.pb.oo24s.aula4.javafx.model;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table (name = "fornecedor")
public class Fornecedor implements AbstractModel{
    
     private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @NotEmpty (message = "o campo 'nome' deve ser preenchido!")
    @Column (name = "nome", length = 100, nullable = false)
    private String nome;
    
    @NotNull (message = "O campo 'cnpj' deve ser preenchido!")
    private Long cnpj;
    
    @NotEmpty (message = "o campo 'endereço' deve ser preenchido!")
    @Column (name = "endereco", length = 100, nullable = false)
    private String endereco;
    
    @NotEmpty (message = "o campo 'bairro' deve ser preenchido!")
    @Column (name = "bairro", length = 100, nullable = false)
    private String bairro;
    
    @NotNull (message = "o campo CEP deve ser preenchido!")
    @Column (name = "cep", length = 9, nullable = false)
    private Long cep;
    
    @Column (name = "complemento", length = 100, nullable = true)
    private String complemento;
    
    @Column  (name = "referencia", length = 100, nullable = true)
    private String referencia;
    
    @NotNull (message = "Por favor, selecione uma cidade!")
    @JoinColumn (name = "cidade_id", referencedColumnName= "id")
    @ManyToOne
    private Cidade cidade;

    public Fornecedor() {
    }

    public Fornecedor(Integer id, String nome, Long cnpj, String endereco, String bairro, Long cep, String complemento, String referencia, Cidade cidade) {
        this.id = id;
        this.nome = nome;
        this.cnpj = cnpj;
        this.endereco = endereco;
        this.bairro = bairro;
        this.cep = cep;
        this.complemento = complemento;
        this.referencia = referencia;
        this.cidade = cidade;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Long getCnpj() {
        return cnpj;
    }

    public void setCnpj(Long cnpj) {
        this.cnpj = cnpj;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public Long getCep() {
        return cep;
    }

    public void setCep(Long cep) {
        this.cep = cep;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public Cidade getCidade() {
        return cidade;
    }

    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 73 * hash + Objects.hashCode(this.id);
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
        final Fornecedor other = (Fornecedor) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Razão Social=" + nome + ", cnpj=" + cnpj;
    }
    
    
    
}
