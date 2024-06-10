package br.com.softwareGrup.comanda.controllers;

import br.com.softwareGrup.comanda.model.Mesa;
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

    @PutMapping("/abrir")
    public Mesa abrirMesa(@RequestParam Long idMesa, @RequestParam int numeroOcupantes) {
        return mesaServicies.abrirMesa(idMesa, numeroOcupantes);
    }

    @PutMapping("/aguardar")
    public Mesa aguardarPagamento(@RequestParam Long idMesa) {
       return mesaServicies.AguardarPagamento(idMesa);
    }

    @PutMapping("/fechar")
    public Mesa fecharMesa(@RequestParam Long idMesa, @RequestParam int numeroOcupantes) {
       return mesaServicies.fechaMesa(idMesa, numeroOcupantes);
    }

    @PostMapping
    public void populaMesa(@RequestBody Mesa mesa){
        mesaServicies.createMesa(mesa);
    }

}
