
INSERT INTO usuario (ativo,email, nome, senha) VALUES ('T','admin@admin.com', 'Administrador', '123');
INSERT INTO usuario (ativo,email, nome, senha) VALUES ('T','teste@teste.com','Teste', '123');

INSERT INTO Estado (nome) VALUES ('Acre');
INSERT INTO Estado (nome) VALUES ('Alagoas');
INSERT INTO Estado (nome) VALUES ('Amapa');
INSERT INTO Estado (nome) VALUES ('Amazonas');
INSERT INTO Estado (nome) VALUES ('Bahia');
INSERT INTO Estado (nome) VALUES ('Ceara');
INSERT INTO Estado (nome) VALUES ('Distrito Federal');
INSERT INTO Estado (nome) VALUES ('Espirito Santo');
INSERT INTO Estado (nome) VALUES ('Goias');
INSERT INTO Estado (nome) VALUES ('Maranhao');
INSERT INTO Estado (nome) VALUES ('Mato Grosso');
INSERT INTO Estado (nome) VALUES ('Mato Grosso do Sul');
INSERT INTO Estado (nome) VALUES ('Minas Gerais');
INSERT INTO Estado (nome) VALUES ('Para');
INSERT INTO Estado (nome) VALUES ('Paraiba');
INSERT INTO Estado (nome) VALUES ('Parana');
INSERT INTO Estado (nome) VALUES ('Pernambuco');
INSERT INTO Estado (nome) VALUES ('Piaui');
INSERT INTO Estado (nome) VALUES ('Rio de Janeiro');
INSERT INTO Estado (nome) VALUES ('Rio Grande do Norte');
INSERT INTO Estado (nome) VALUES ('Rio Grande do Sul');
INSERT INTO Estado (nome) VALUES ('Rondonia');
INSERT INTO Estado (nome) VALUES ('Roraima');
INSERT INTO Estado (nome) VALUES ('Santa Catarina');
INSERT INTO Estado (nome) VALUES ('Sao Paulo');
INSERT INTO Estado (nome) VALUES ('Sergipe');
INSERT INTO Estado (nome) VALUES ('Tocantins');

INSERT INTO Cidade (nome, estado_id) VALUES ('Rio Branco', 1);

INSERT INTO categoria (descricao) VALUES ('Informatica');
INSERT INTO categoria (descricao) VALUES ('Eletronico');
INSERT INTO categoria (descricao) VALUES ('Telefonia');
INSERT INTO produto (nome, descricao, valor, categoria_id) VALUES ('Teclado Microsoft 3000', 'Teclado com tecnologia Wireless; ABNT2 ...', 199.49, 1);
INSERT INTO produto (nome, descricao, valor, categoria_id) values ('Monitor 24pol. FHD Samsung', 'Monitor Full HD de 24pol. Taxa de atualização 144Hz...', 2099.00, 1);
INSERT INTO produto (nome, descricao, valor, categoria_id) VALUES ('Smarpthone Samsung A9', 'Smartphone Samsung A9, Tela 2k 440ppi, 64GB ...', 199.49, 3);
INSERT INTO produto (nome, descricao, valor, categoria_id) VALUES ('Home Theater LG LHB655NW', 'O novo Home Theater LG LHB655NW possui 5.1 canais de áudio e 1000W RMS de potencia,...', 1899.99, 2);
INSERT INTO produto (nome, descricao, valor, categoria_id) VALUES ('Processador Core I9', 'Processador Intel Core I9 4.3Ghz...', 7099.99, 1);

INSERT INTO cliente (nome, cpf) VALUES ('Nedson Estark', '00100100101');
INSERT INTO cliente (nome, cpf) VALUES ('Tiao Lanister', '12357894518');
INSERT INTO cliente (nome, cpf) VALUES ('Jonas Mormont', '65487321997');

INSERT INTO venda(data, dataentrega, numerodocumento, cliente_id) VALUES ('2018-03-20', '2018-03-21', '123456', 1);
INSERT INTO vendaproduto(quantidade, valor, produto_id, venda_id) VALUES (1, 225, 1, 1);
INSERT INTO vendaproduto(quantidade, valor, produto_id, venda_id) VALUES (3, 400, 2, 1);

INSERT INTO venda(data, dataentrega, numerodocumento, cliente_id) VALUES ('2018-04-12', '2018-04-12', '2254', 2);
INSERT INTO vendaproduto(quantidade, valor, produto_id, venda_id) VALUES (2, 930, 3, 2);
INSERT INTO vendaproduto(quantidade, valor, produto_id, venda_id) VALUES (4, 225, 1, 2);

INSERT INTO venda(data, dataentrega, numerodocumento, cliente_id) VALUES ('2018-05-15', '2018-05-15', '3214', 3);
INSERT INTO vendaproduto(quantidade, valor, produto_id, venda_id) VALUES (2, 930, 3, 3);

INSERT INTO venda(data, dataentrega, numerodocumento, cliente_id) VALUES ('2018-06-13', '2018-07-11', '321', 2);
INSERT INTO vendaproduto(quantidade, valor, produto_id, venda_id) VALUES (9, 750, 3, 4);
INSERT INTO vendaproduto(quantidade, valor, produto_id, venda_id) VALUES (2, 235, 2, 4);

INSERT INTO venda(data, dataentrega, numerodocumento, cliente_id) VALUES ('2018-09-11', '2018-09-13', '578', 1);
INSERT INTO vendaproduto(quantidade, valor, produto_id, venda_id) VALUES (1, 150, 1, 5);

INSERT INTO venda(data, dataentrega, numerodocumento, cliente_id) VALUES ('2019-01-11', '2019-01-13', '5544', 2);
INSERT INTO vendaproduto(quantidade, valor, produto_id, venda_id) VALUES (6, 1223, 4, 6);
INSERT INTO vendaproduto(quantidade, valor, produto_id, venda_id) VALUES (5, 7930, 5, 6);