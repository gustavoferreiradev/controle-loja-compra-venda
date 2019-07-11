package br.edu.utfpr.pb.oo24s.aula4.javafx.dao;

import br.edu.utfpr.pb.oo24s.aula4.javafx.model.Produto;

public class ProdutoDao extends GenericDao<Produto, Long> {

    public ProdutoDao() {
        super(Produto.class);
    }
}
