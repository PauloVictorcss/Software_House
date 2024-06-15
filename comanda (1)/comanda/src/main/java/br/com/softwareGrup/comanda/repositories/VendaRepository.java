package br.com.softwareGrup.comanda.repositories;

import br.com.softwareGrup.comanda.model.Venda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface VendaRepository extends JpaRepository<Venda, Long> {

    List<Venda> findByDataPagamentoBetween(LocalDate inicio, LocalDate fim);

    @Query("SELECT p.nome AS produto, SUM(ip.quantidade) AS total_vendido " +
            "FROM Venda v " +
            "JOIN v.comanda c " +
            "JOIN c.itens ip " +
            "JOIN ip.produto p " +
            "WHERE v.dataPagamento BETWEEN :dataInicio AND :dataFim " +
            "GROUP BY p.nome " +
            "ORDER BY total_vendido DESC")
    List<Object[]> rankingProdutosMaisVendidos(LocalDate dataInicio, LocalDate dataFim);
}
