package br.com.softwareGrup.comanda.controllers;

import br.com.softwareGrup.comanda.model.ItemPedido;
import br.com.softwareGrup.comanda.model.Comanda;
import br.com.softwareGrup.comanda.servicies.ComandaServicies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/comanda")
public class ControllerComanda {

    @Autowired
    ComandaServicies pedidoServicies;

    @PostMapping
    public Comanda CriarComanda(@RequestParam Long idMesa){
        return pedidoServicies.CriarComanda(idMesa);
    }

    @PutMapping
    public Comanda AdicionarItemPedidoNaComanda(@RequestParam Long idComanda, @RequestParam Long idProduto, @RequestParam int quantidade){
        return pedidoServicies.AdicionarItemPedido(idComanda, idProduto, quantidade);
    }

    @GetMapping("/itens")
    public List<ItemPedido> getItensComanda(@RequestParam Long idComanda){
        return pedidoServicies.GetItensComanda(idComanda);
    }

    @GetMapping
    public Comanda GetPedido(Long idComanda){
        return pedidoServicies.getComanda(idComanda);
    }
}
