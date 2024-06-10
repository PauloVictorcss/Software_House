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
  `imagem` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
);

CREATE TABLE `pedido` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `mesa_id` bigint NOT NULL,
  `data_hora` datetime(6) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_pedido_mesa` (`mesa_id`),
  CONSTRAINT `fk_pedido_mesa` FOREIGN KEY (`mesa_id`) REFERENCES `mesa` (`id`)
);

CREATE TABLE `item_pedido` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `pedido_id` bigint NOT NULL,
  `produto_id` bigint NOT NULL,
  `quantidade` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_item_pedido_pedido` (`pedido_id`),
  KEY `fk_item_pedido_produto` (`produto_id`),
  CONSTRAINT `fk_item_pedido_pedido` FOREIGN KEY (`pedido_id`) REFERENCES `pedido` (`id`),
  CONSTRAINT `fk_item_pedido_produto` FOREIGN KEY (`produto_id`) REFERENCES `produto` (`id`)
);