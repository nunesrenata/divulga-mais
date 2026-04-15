package br.com.renata.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import br.com.renata.model.Avaliacao;

public interface AvaliacaoRepository extends JpaRepository<Avaliacao, Long> {
}