package br.com.softwareGrup.comanda.servicies;

import br.com.softwareGrup.comanda.enuns.StatusMesa;
import br.com.softwareGrup.comanda.exception.EntityNotFoundException;
import br.com.softwareGrup.comanda.exception.IsNotPossibleToDoException;
import br.com.softwareGrup.comanda.model.Mesa;
import br.com.softwareGrup.comanda.repositories.MesaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class MesaServicies {

    @Autowired
    MesaRepository repository;

    public List<Mesa> getMesas(){
        return repository.findAll();

    }

    public Mesa abrirMesa(Long id, int numeroOcupantes) {
        Mesa mesa = repository.findById(id).orElseThrow(() -> new EntityNotFoundException("Mesa não existe"));
        if(mesa.getStatus().equals(StatusMesa.LIVRE)) {
            mesa.setNumeroOcupante(numeroOcupantes);
            mesa.setHoraAbertura(LocalDateTime.now());
            mesa.setHoraFechamento(null);
            mesa.setStatus(StatusMesa.OCUPADA);
            return repository.save(mesa);
        } else {
            throw new IsNotPossibleToDoException("Não é possível fazer abertura pois a mesa não está livre");
        }
    }

    public Mesa AguardarPagamento(Long idMesa) {
        Mesa mesa = repository.findById(idMesa).orElseThrow(() -> new EntityNotFoundException("Mesa não existe"));
        if(mesa.getHoraAbertura() == null){
            throw new IsNotPossibleToDoException("Se a mesa não foi aberta não é possível aguardar pagamento");
        }else {
            mesa.setStatus(StatusMesa.AGUARDANDO_PAGAMENTO);
            return repository.save(mesa);
        }
    }

    public Mesa fechaMesa(Long idMesa, int numeroOcupantes) {
        Mesa mesa = repository.findById(idMesa).orElseThrow(() -> new EntityNotFoundException("Mesa não existe"));
        if(mesa.getHoraAbertura() == null){
            throw new IsNotPossibleToDoException("Não é possível fechar mesa sem antes ter abrido");
        } else {
            mesa.setNumeroOcupante(numeroOcupantes);
            mesa.setHoraFechamento(LocalDateTime.now());
            mesa.setStatus(StatusMesa.LIVRE);
            return repository.save(mesa);
        }
    }


    public void createMesa(Mesa mesa){
        repository.save(mesa);
    }

}
