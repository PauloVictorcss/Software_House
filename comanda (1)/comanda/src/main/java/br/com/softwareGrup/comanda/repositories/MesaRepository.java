package br.com.softwareGrup.comanda.repositories;

import br.com.softwareGrup.comanda.model.Mesa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MesaRepository extends JpaRepository<Mesa, Long> {
}
