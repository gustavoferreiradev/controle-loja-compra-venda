package br.edu.utfpr.pb.controle.loja.compra.venda.javafx.model;

import java.io.Serializable;
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
@Table (name = "cliente")
public class Cliente implements Serializable{
    
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @NotEmpty (message = "o campo 'nome' deve ser preenchido!")
    @Column (name = "nome", length = 100, nullable = false)
    private String nome;
    
    @NotNull (message = "O campo 'cpf' deve ser preenchido!")
    @Column (name = "cpf", length = 11, nullable = false)
    private Long cpf;
    
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
    
}
