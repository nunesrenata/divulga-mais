package br.com.renata.controller;

import br.com.renata.model.Servico;
import br.com.renata.repository.ServicoRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/servicos")
public class ServicoController {

    private final ServicoRepository repository;

    public ServicoController(ServicoRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Servico> listar() {
        return repository.findAll();
    }

    @PostMapping
    public Servico salvar(@RequestBody Servico servico) {
        return repository.save(servico);
    }
}