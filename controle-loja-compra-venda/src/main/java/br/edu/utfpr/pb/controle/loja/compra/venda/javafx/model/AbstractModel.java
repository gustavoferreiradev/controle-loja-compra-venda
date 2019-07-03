package br.edu.utfpr.pb.controle.loja.compra.venda.javafx.model;

import java.io.Serializable;

public interface AbstractModel <ID extends  Serializable> extends Serializable{
     ID getId();
}
