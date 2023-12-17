package org.deadog.web.repositories;

import org.deadog.web.models.FeedBackMessage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FeedBackMessageRepository extends JpaRepository<FeedBackMessage, Integer> {
}
