package br.com.softwareGrup.comanda.servicies;

import br.com.softwareGrup.comanda.enuns.StatusMesa;
import br.com.softwareGrup.comanda.exception.IsNotPossibleToDoException;
import br.com.softwareGrup.comanda.model.Mesa;
import br.com.softwareGrup.comanda.model.Produto;
import br.com.softwareGrup.comanda.repositories.MesaRepository;
import br.com.softwareGrup.comanda.repositories.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoServicies {

    @Autowired
    ProdutoRepository repositoryProduto;
    @Autowired
    MesaRepository repositoryMesa;

    public List<Produto> getProdutos(Long id){
        Mesa mesa = repositoryMesa.findById(id).orElse(null);
        if(mesa.getStatus().equals(StatusMesa.OCUPADA)) {
            return repositoryProduto.findAll();
        } else {
            throw new IsNotPossibleToDoException("Mesa não está ocupada");
        }
    }

    public Produto CreateProduto(Produto produto){
        return repositoryProduto.save(produto);
    }
}
