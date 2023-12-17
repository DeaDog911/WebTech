package org.deadog.web.repositories;

import org.deadog.web.models.FeedBackMessage;
import org.deadog.web.models.MovieReview;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieReviewRepository extends JpaRepository<MovieReview, Integer> {
}
