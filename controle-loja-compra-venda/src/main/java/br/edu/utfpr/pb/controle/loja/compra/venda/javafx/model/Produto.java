package br.edu.utfpr.pb.controle.loja.compra.venda.javafx.model;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table (name = "produto")
public class Produto implements AbstractModel{
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @NotEmpty (message = "Preencha o Nome!")
    @Column (name = "nome", length = 100, nullable = false)
    private String nome;
    
    @NotEmpty (message = "Preencha a Descrição!")
    @Column (name = "descricao", length = 100, nullable = false)
    private String descricao;
    
    @NotNull (message = "Por favor, selecione uma marca!")
    @JoinColumn (name = "marca_id", referencedColumnName = "id")
    private Marca marca;
    
    @NotNull (message = "Por favor, selecione uma categoria!")
    @JoinColumn (name = "categoria_id", referencedColumnName = "id")
    private Categoria categoria;

    public Produto() {
    }

    public Produto(Integer id, String nome, String descricao, Marca marca, Categoria categoria) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.marca = marca;
        this.categoria = categoria;
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

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Marca getMarca() {
        return marca;
    }

    public void setMarca(Marca marca) {
        this.marca = marca;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + Objects.hashCode(this.id);
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
        final Produto other = (Produto) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Produto{" + "id=" + id + ", nome=" + nome + ", descricao=" + descricao + ", marca=" + marca + ", categoria=" + categoria + '}';
    }
    
    
    
}
