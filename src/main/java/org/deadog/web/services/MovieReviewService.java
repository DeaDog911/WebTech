package org.deadog.web.services;

import org.deadog.web.models.MovieReview;
import org.deadog.web.repositories.MovieReviewRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieReviewService {
    private final MovieReviewRepository movieReviewRepository;

    public MovieReviewService(MovieReviewRepository movieReviewRepository) {
        this.movieReviewRepository = movieReviewRepository;
    }

    public List<MovieReview> findAll() {
        return movieReviewRepository.findAll();
    }

    public MovieReview findById(int id) {
        return movieReviewRepository.findById(id).orElse(null);
    }
}
