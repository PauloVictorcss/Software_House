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

    @PostMapping("/{idMesa}")
    public Comanda CriarComanda(@PathVariable Long idMesa){
        return pedidoServicies.CriarComanda(idMesa);
    }

    @PutMapping("/{idComanda}/{idProduto}")
    public Comanda AdicionarItemPedidoNaComanda(
            @PathVariable Long idComanda,
            @PathVariable Long idProduto,
            @RequestParam int quantidade){

        return pedidoServicies.AdicionarItemPedido(idComanda, idProduto, quantidade);
    }

    @GetMapping("/itens/{idComanda}")
    public List<ItemPedido> getItensComanda(@PathVariable Long idComanda){
        return pedidoServicies.GetItensComanda(idComanda);
    }

    @GetMapping("/comanda/{idComanda}")
    public Comanda getComanda(@PathVariable Long idComanda){
        return pedidoServicies.getComanda(idComanda);
    }
}

