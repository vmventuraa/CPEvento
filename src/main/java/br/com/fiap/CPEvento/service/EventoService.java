package br.com.fiap.CPEvento.service;

import br.com.fiap.CPEvento.model.Evento;
import br.com.fiap.CPEvento.repository.EventoRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EventoService {


    @Autowired
    private EventoRepository repository;

    public Evento insert(Evento evento) {
        return repository.save(evento);

    }

    @Transactional(readOnly = true)
    public List<Evento> findAll() {
        return repository.findAll();

    }

    @Transactional(readOnly = true)
    public Evento findById(Long id) {
        Evento evento = repository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("Recurso Inválido - id: " + id)
        );
        return evento;
    }


    @Transactional
    public Evento update(Long id, Evento entity) {
        try {
            Evento evento = repository.getReferenceById(id);
            copyToEvento(entity, evento);
            evento = repository.save(evento);
            return evento;
        } catch (EntityNotFoundException e) {
            throw new IllegalArgumentException("Recurso não encontrado");
        }

    }

    private void copyToEvento(Evento entity, Evento evento) {
        evento.setNome(entity.getNome());
        evento.setData(entity.getData());
        evento.setUrl(entity.getUrl());
        evento.setCidade(entity.getCidade());
    }

    @Transactional
    public void delete(Long id) {
        if (!repository.existsById(id)) {
            throw new IllegalArgumentException("Recurso inválido - id " + id);
        }
        try {
            repository.deleteById(id);
        } catch (DataIntegrityViolationException e) {
            throw new IllegalArgumentException("Integridade Referencial violada - id" + id);
        }
    }
}
