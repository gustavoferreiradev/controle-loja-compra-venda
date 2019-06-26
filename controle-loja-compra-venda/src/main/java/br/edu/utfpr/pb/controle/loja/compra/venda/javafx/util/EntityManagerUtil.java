package br.edu.utfpr.pb.controle.loja.compra.venda.javafx.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagerUtil {

    private static EntityManagerFactory emf;
    
    public static EntityManager getEntityManager(){
        if (emf == null){
            emf = Persistence.createEntityManagerFactory("LojaPU");
        }
        return emf.createEntityManager();
    }
}
