package org.iesvdm.jardineria.jardineria_jpa.service;

import org.iesvdm.jardineria.jardineria_jpa.domain.Gama;
import org.iesvdm.jardineria.jardineria_jpa.exception.GamaNotFoundException;
import org.iesvdm.jardineria.jardineria_jpa.repository.GamaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GamaService {

    private final GamaRepository gamaRepository;

    public GamaService(GamaRepository gamaRepository) {
        this.gamaRepository = gamaRepository;
    }

    public List<Gama> all() {
        return this.gamaRepository.findAll();
    }

    public Gama save(Gama gama) {
        return this.gamaRepository.save(gama);
    }

    public Gama one(Long id) {
        return this.gamaRepository.findById(id)
                .orElseThrow(() -> new GamaNotFoundException(id));
    }

    public Gama replace(Long id, Gama gama) {

        return this.gamaRepository.findById(id).map( p -> (id.equals(gama.getId())  ?
                        this.gamaRepository.save(gama) : null))
                .orElseThrow(() -> new GamaNotFoundException(id));

    }

    public void delete(Long id) {
        this.gamaRepository.findById(id).map(p -> {this.gamaRepository.delete(p);
                    return p;})
                .orElseThrow(() -> new GamaNotFoundException(id));
    }
}
