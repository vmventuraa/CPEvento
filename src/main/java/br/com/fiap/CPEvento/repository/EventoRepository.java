package br.com.fiap.CPEvento.repository;

import br.com.fiap.CPEvento.model.Evento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventoRepository extends JpaRepository<Evento,Long> {
}
