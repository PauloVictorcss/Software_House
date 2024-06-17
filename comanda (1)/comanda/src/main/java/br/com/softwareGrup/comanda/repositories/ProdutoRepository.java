package br.com.softwareGrup.comanda.repositories;
import br.com.softwareGrup.comanda.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {

    List<Produto> findByCategoria(String categoria);
}
