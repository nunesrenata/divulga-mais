package br.com.renata.controller;

import br.com.renata.model.Contato;
import br.com.renata.repository.ContatoRepository;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/contatos")
public class ContatoController {

    private final ContatoRepository repository;

    public ContatoController(ContatoRepository repository) {
        this.repository = repository;
    }

    @PostMapping
    public Contato salvar(@RequestBody Contato contato) {

        if (contato.getNome() == null || contato.getEmail() == null) {
            throw new RuntimeException("Nome e email são obrigatórios");
        }

        return repository.save(contato);
    }
    
}