package org.deadog.web.services;

import org.deadog.web.models.Premier;
import org.deadog.web.repositories.PremierRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PremierService {
    private final PremierRepository premierRepository;

    public PremierService(PremierRepository premierRepository) {
        this.premierRepository = premierRepository;
    }

    public List<Premier> findAll() {
        return premierRepository.findAll();
    }
}
