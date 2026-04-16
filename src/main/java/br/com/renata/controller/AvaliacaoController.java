package br.com.renata.controller;

import br.com.renata.model.Avaliacao;
import br.com.renata.repository.AvaliacaoRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/avaliacoes")
public class AvaliacaoController {

    private final AvaliacaoRepository repository;

    public AvaliacaoController(AvaliacaoRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Avaliacao> listar() {
        return repository.findAll();
    }

    @PostMapping
    public Avaliacao salvar(@RequestBody Avaliacao avaliacao) {
        return repository.save(avaliacao);
    }
}