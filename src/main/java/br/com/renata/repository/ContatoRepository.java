package br.com.renata.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import br.com.renata.model.Contato;

public interface ContatoRepository extends JpaRepository<Contato, Long> {
}