package br.com.softwareGrup.comanda.repositories;
import br.com.softwareGrup.comanda.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {
}
