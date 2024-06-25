# Sistema de Bar e Restaurante

Este é um sistema de bar e restaurante desenvolvido com Java e Spring Boot 3. O sistema gerencia mesas e comandas, permitindo a adição de pedidos, fechamento de mesas, e geração de relatórios de vendas.

## Funcionalidades
- **Visualizar Mesas**: Permite ver todas as mesas e os seus status
- **Abrir Mesa**: Permite abrir uma mesa e altomaticamente seu status muda para "ocupado".
- **Abrir Comanda**: Permite abrir uma comanda associada a uma mesa específica.
- **Visualizar Cardápio**: Permite a visualização dos cardápios
- **Adicionar Pedidos**: Adiciona pedidos a uma comanda vinculada a uma mesa.
- **Fechar Mesa**: Permite fechar a mesa, alterando altomaticamente seu status para "livre" ou "aguardando pagamento.".
- **Relatórios de Vendas**: Gera relatórios de vendas por data e produtos mais vendidos por data.
- **Encerramento de Pedido**: Quando o cliente encerra o pedido, o sistema calcula e exibe o subtotal de todos os pedidos, acréscimo de gorjeta do garçom e o total a ser pago.

## Tecnologias Utilizadas

- **Java**
- **Spring Boot 3**
- **Spring Data JPA** (para persistência de dados)
- **H2 Database** (para banco de dados em memória)
- **Thymeleaf** (para renderização de páginas HTML)
- **Maven** (para gerenciamento de dependências)

