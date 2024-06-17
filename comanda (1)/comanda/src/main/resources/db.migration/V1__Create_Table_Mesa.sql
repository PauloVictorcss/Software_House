CREATE TABLE `mesa` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `status_mesa` varchar(80) DEFAULT NULL,
  `numero` int(10) DEFAULT NULL,
  `numero_ocupante` int(10) DEFAULT NULL,
  `hora_abertura` datetime(6) DEFAULT NULL,
  `hora_fechamento` datetime(6) DEFAULT NULL,
  PRIMARY KEY (`id`)
);

CREATE TABLE `produto` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `nome` varchar(255) NOT NULL,
  `descricao` varchar(255) DEFAULT NULL,
  `preco` decimal(10,2) NOT NULL,
  `categoria` varchar(80) DEFAULT NULL,
  --`imagem` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
);

CREATE TABLE `comanda` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `mesa_id` bigint NOT NULL,
  `data_hora` datetime(6) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_comanda_mesa` (`mesa_id`),
  CONSTRAINT `fk_comanda_mesa` FOREIGN KEY (`mesa_id`) REFERENCES `mesa` (`id`)
);

CREATE TABLE `item_pedido` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `comanda_id` bigint NOT NULL,
  `produto_id` bigint NOT NULL,
  `quantidade` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_item_comanda_comanda` (`pedido_id`),
  KEY `fk_item_comanda_produto` (`produto_id`),
  CONSTRAINT `fk_item_comanda_comanda` FOREIGN KEY (`comanda_id`) REFERENCES `comanda` (`id`),
  CONSTRAINT `fk_item_comanda_produto` FOREIGN KEY (`produto_id`) REFERENCES `produto` (`id`)
);

CREATE TABLE venda (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    mesa_id BIGINT,
    comanda_id BIGINT,
    forma_pagamento VARCHAR(255),
    data_pagamento DATE,
    valor_itens_pedidos DOUBLE,
    desconto_porcentagem_garcon DOUBLE,
    subtotal DOUBLE,
    FOREIGN KEY (mesa_id) REFERENCES mesa(id),
    FOREIGN KEY (comanda_id) REFERENCES comanda(id)
);
