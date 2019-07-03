package br.edu.utfpr.pb.controle.loja.compra.venda.javafx.dao;

import br.edu.utfpr.pb.controle.loja.compra.venda.javafx.model.Categoria;
import java.util.List;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

public class CategoriaDao extends GenericDao <Categoria, Integer> {
    
     public CategoriaDao() {
        super(Categoria.class);
    }

    public List<Object[]> getCategoriaProdutos() {
        Query query = em.createQuery("Select c.nome, "
                + "count(p) from Produto AS p "
                + "INNER JOIN p.categoria AS c "
                + "GROUP BY c.id");
        return (List<Object[]>) query.getResultList();
    }
    
     public List<Categoria> findAll(){
        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<Categoria> query = builder.createQuery(Categoria.class);
        query.from(Categoria.class);
        return em.createQuery(query).getResultList();
     }
}
