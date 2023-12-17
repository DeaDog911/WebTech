package org.deadog.web.services;

import org.deadog.web.models.SingleNews;
import org.deadog.web.repositories.SingleNewsRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SingleNewsService {
    private final SingleNewsRepository singleNewsRepository;

    public SingleNewsService(SingleNewsRepository singleNewsRepository) {
        this.singleNewsRepository = singleNewsRepository;
    }

    public List<SingleNews> findAll() {
        return singleNewsRepository.findAll();
    }

    public SingleNews findById(int id) {
        return singleNewsRepository.findById(id).orElse(null);
    }
}
