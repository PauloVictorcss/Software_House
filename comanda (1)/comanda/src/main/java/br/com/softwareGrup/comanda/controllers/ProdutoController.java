package br.com.softwareGrup.comanda.controllers;
import br.com.softwareGrup.comanda.model.Produto;
import br.com.softwareGrup.comanda.servicies.ProdutoServicies;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named
@ViewScoped
public class ProdutoController implements Serializable {

    @Inject
    private ProdutoServicies servicies;

    private List<Produto> produtos;
    private Produto novoProduto;

    @PostConstruct
    public void init() {
        produtos = servicies.getProdutos();
        novoProduto = new Produto();
    }

    public void criarProduto() {
        servicies.CreateProduto(novoProduto);
        produtos = servicies.getProdutos(); // Atualiza a lista de produtos
        novoProduto = new Produto(); // Reseta o produto para um novo cadastro
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public Produto getNovoProduto() {
        return novoProduto;
    }

    public void setNovoProduto(Produto novoProduto) {
        this.novoProduto = novoProduto;
    }
}
