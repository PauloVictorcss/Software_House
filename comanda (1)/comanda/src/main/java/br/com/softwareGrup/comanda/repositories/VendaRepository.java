package br.com.softwareGrup.comanda.repositories;

import br.com.softwareGrup.comanda.model.Venda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Date;
import java.util.List;

@Repository
public interface VendaRepository extends JpaRepository<Venda, Long> {

    List<Venda> findByDataHoraPagamentoBetween(Date inicio, Date fim);

}
