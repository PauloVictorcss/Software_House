package br.com.softwareGrup.comanda.controllers;

import br.com.softwareGrup.comanda.model.Mesa;
import br.com.softwareGrup.comanda.model.Produto;
import br.com.softwareGrup.comanda.servicies.ProdutoServicies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    @Autowired
    ProdutoServicies servicies;

    //Não esquecer de jogar essa parte dentro da comanda que vai ser retornado no abrir mesa
    @GetMapping
    public List<Produto> getProdutos() {
        return servicies.getProdutos();
    }

    @GetMapping("/categoria/{categoria}")
    public List<Produto> getProdutosByCategoria(@PathVariable String categoria) {
        return servicies.getProdutosByCategoria(categoria);
    }



    @PostMapping
    public Produto CreatProduto(@RequestBody Produto produto){
        return servicies.CreateProduto(produto);
    }
}
