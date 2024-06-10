package br.com.softwareGrup.comanda.repositories;

import br.com.softwareGrup.comanda.model.Venda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VendaRepository extends JpaRepository<Venda, Long> {
}
