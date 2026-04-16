package br.com.renata;

import br.com.renata.model.Servico;
import br.com.renata.model.Avaliacao;
import br.com.renata.repository.ServicoRepository;
import br.com.renata.repository.AvaliacaoRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataLoader {

    @Bean
    CommandLineRunner initDatabase(ServicoRepository servicoRepo, AvaliacaoRepository avaliacaoRepo) {
        return args -> {

            Servico s1 = new Servico();
            s1.setNome("Design de sobrancelha");
            s1.setDescricao("Modelagem profissional");
            s1.setPreco(50.0);

            Servico s2 = new Servico();
            s2.setNome("Limpeza de pele");
            s2.setDescricao("Tratamento facial completo");
            s2.setPreco(120.0);

            servicoRepo.save(s1);
            servicoRepo.save(s2);

            Avaliacao a1 = new Avaliacao();
            a1.setNomeCliente("Maria");
            a1.setComentario("Atendimento excelente!");
            a1.setNota(5);

            Avaliacao a2 = new Avaliacao();
            a2.setNomeCliente("Ana");
            a2.setComentario("Gostei muito do serviço");
            a2.setNota(4);

            avaliacaoRepo.save(a1);
            avaliacaoRepo.save(a2);
        };
    }
}