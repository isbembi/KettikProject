package kg.alatoo.kettikproject.repositories;

import kg.alatoo.kettikproject.entities.Tour;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TourRepository extends JpaRepository<Tour, Long> {
}
