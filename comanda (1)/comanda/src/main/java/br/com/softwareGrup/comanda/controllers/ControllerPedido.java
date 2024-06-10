package br.com.softwareGrup.comanda.controllers;

import br.com.softwareGrup.comanda.model.ItemPedido;
import br.com.softwareGrup.comanda.model.Pedido;
import br.com.softwareGrup.comanda.servicies.PedidoServicies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pedido")
public class ControllerPedido {

    @Autowired
    PedidoServicies pedidoServicies;

    @PostMapping
    public Pedido CriarPedido(@RequestParam Long id){
        return pedidoServicies.CriarPedido(id);
    }

    @PutMapping
    public Pedido AdicionarItemPedido(@RequestParam Long idPedido, @RequestParam Long idProduto, @RequestParam int quantidade){
        return pedidoServicies.AdicionarItemPedido(idPedido, idProduto, quantidade);
    }

    @GetMapping("/itens")
    public List<ItemPedido> getItensPedido(@RequestParam Long idPedido){
        return pedidoServicies.Getitenspedidos(idPedido);
    }

    @GetMapping
    public Pedido GetPedido(Long idPedido){
        return pedidoServicies.getPedido(idPedido);
    }
}
