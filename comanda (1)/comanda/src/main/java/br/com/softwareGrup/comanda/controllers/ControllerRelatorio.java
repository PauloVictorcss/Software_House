package br.com.softwareGrup.comanda.controllers;

import br.com.softwareGrup.comanda.model.Venda;
import br.com.softwareGrup.comanda.repositories.VendaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
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
    VendaRepository vendaRepository;

    @GetMapping
    public List<Venda> relatorioVendaPorData(
            @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") String dataInicio,
            @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") String dataFim
    ) throws ParseException {

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

        Date inicio = formatter.parse(dataInicio);
        Date fim = formatter.parse(dataFim);

        List<Venda> vendas =  vendaRepository.findByDataHoraPagamentoBetween(inicio, fim);
        return vendas;

    }
}
