package br.com.softwareGrup.comanda.controllers;

import br.com.softwareGrup.comanda.enuns.FormaPagamento;
import br.com.softwareGrup.comanda.model.Mesa;
import br.com.softwareGrup.comanda.model.Produto;
import br.com.softwareGrup.comanda.model.Venda;
import br.com.softwareGrup.comanda.servicies.MesaServicies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/mesas")
public class MesaController {

    @Autowired
    MesaServicies mesaServicies;

    @GetMapping
    public List<Mesa> getMapaMesas(){
        return mesaServicies.getMesas();
    }

    @PostMapping("/abrir")
    public List<Produto> abrirMesa(@RequestBody Mesa mesa) {
        return mesaServicies.abrirMesa(mesa);
    }

    @PutMapping("/aguardar")
    public Mesa aguardarPagamento(@RequestBody Mesa mesa) {
       return mesaServicies.AguardarPagamento(mesa);
    }


    @PutMapping("/fechar")
    public Venda fecharMesa(@RequestBody Mesa mesa, @RequestParam FormaPagamento formaPagamento) {
        return mesaServicies.fechaMesa(mesa, formaPagamento);
    }


    @PostMapping("/popular")
    public void populaMesa(@RequestBody Mesa mesa){
        mesaServicies.createMesa(mesa);
    }

}
