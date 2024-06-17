package br.com.softwareGrup.comanda.controllers;

import br.com.softwareGrup.comanda.model.Venda;
import br.com.softwareGrup.comanda.repositories.VendaRepository;
import br.com.softwareGrup.comanda.servicies.VendaServicies;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/relatorios")
public class ControllerRelatorio {

    @Autowired
    VendaServicies vendaServicies;
    @Autowired
    VendaRepository vendaRepository;

    @GetMapping
    public List<Venda> relatorioVendaPorData(
            @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate dataInicio,
            @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate dataFim
    ) throws ParseException {

        List<Venda> vendas =  vendaServicies.relatorioVenda(dataInicio, dataFim);
        return vendas;

    }


    @GetMapping("/mais/vendidos")
    public List<Object[]> rankingProdutosMaisVendidos(@RequestParam("dataInicio") String dataInicio,
                                                      @RequestParam("dataFim") String dataFim) {
        LocalDate inicio = LocalDate.parse(dataInicio);
        LocalDate fim = LocalDate.parse(dataFim);
        return vendaRepository.rankingProdutosMaisVendidos(inicio, fim);
    }
}

