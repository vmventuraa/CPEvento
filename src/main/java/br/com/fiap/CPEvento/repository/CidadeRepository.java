package br.com.fiap.CPEvento.repository;

import br.com.fiap.CPEvento.model.Cidade;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CidadeRepository extends JpaRepository<Cidade,Long> {
}
