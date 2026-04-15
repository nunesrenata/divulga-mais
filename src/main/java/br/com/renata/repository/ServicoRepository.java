package br.com.renata.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import br.com.renata.model.Servico;

public interface ServicoRepository extends JpaRepository<Servico, Long> {
}