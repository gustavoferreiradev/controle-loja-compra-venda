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

INSERT INTO cliente (nome, cpf,endereco,bairro,cep,complemento,referencia,cidade_id) VALUES ('Nedson Estark', '00101','Rua Teste, 123','Teste','11111','teste','teste',1);

INSERT INTO fornecedor (nome, cnpj,endereco,bairro,cep,complemento,referencia,cidade_id) VALUES ('Empresa Ltda', '00101','Rua Teste, 123','Teste','11111','teste','teste',1);

INSERT INTO formaPagamento (descricao) VALUES ('Dinheiro');
INSERT INTO formaPagamento (descricao) VALUES ('Cartao de Credito 01x');
INSERT INTO formaPagamento (descricao) VALUES ('Cartao de Credito 02x');
INSERT INTO formaPagamento (descricao) VALUES ('Cartao de Credito 03x');
INSERT INTO formaPagamento (descricao) VALUES ('Cartao de Credito 04x');
INSERT INTO formaPagamento (descricao) VALUES ('Cartao de Credito 05x');
INSERT INTO formaPagamento (descricao) VALUES ('Cartao de Credito 06x');
INSERT INTO formaPagamento (descricao) VALUES ('Cartao de Credito 07x');
INSERT INTO formaPagamento (descricao) VALUES ('Cartao de Credito 08x');
INSERT INTO formaPagamento (descricao) VALUES ('Cartao de Credito 09x');
INSERT INTO formaPagamento (descricao) VALUES ('Cartao de Credito 10x');
INSERT INTO formaPagamento (descricao) VALUES ('Cartao de Credito 11x');
INSERT INTO formaPagamento (descricao) VALUES ('Cartao de Credito 12x');

INSERT INTO categoria (descricao) VALUES ('Informatica');
INSERT INTO categoria (descricao) VALUES ('Eletronico');
INSERT INTO categoria (descricao) VALUES ('Telefonia');
INSERT INTO produto (nome, descricao, valor, categoria_id) VALUES ('Teclado Microsoft 3000', 'Teclado com tecnologia Wireless; ABNT2 ...', 199.49, 1);
INSERT INTO produto (nome, descricao, valor, categoria_id) values ('Monitor 24pol. FHD Samsung', 'Monitor Full HD de 24pol. Taxa de atualização 144Hz...', 2099.00, 1);
INSERT INTO produto (nome, descricao, valor, categoria_id) VALUES ('Smarpthone Samsung A9', 'Smartphone Samsung A9, Tela 2k 440ppi, 64GB ...', 199.49, 3);
INSERT INTO produto (nome, descricao, valor, categoria_id) VALUES ('Home Theater LG LHB655NW', 'O novo Home Theater LG LHB655NW possui 5.1 canais de áudio e 1000W RMS de potencia,...', 1899.99, 2);
INSERT INTO produto (nome, descricao, valor, categoria_id) VALUES ('Processador Core I9', 'Processador Intel Core I9 4.3Ghz...', 7099.99, 1);





