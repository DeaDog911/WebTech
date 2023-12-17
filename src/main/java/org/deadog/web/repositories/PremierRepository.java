package org.deadog.web.repositories;

import org.deadog.web.models.Premier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PremierRepository extends JpaRepository<Premier, Integer> {
}
