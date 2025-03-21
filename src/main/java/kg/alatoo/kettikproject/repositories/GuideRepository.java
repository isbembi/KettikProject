package kg.alatoo.kettikproject.repositories;

import kg.alatoo.kettikproject.entities.Guide;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GuideRepository extends JpaRepository<Guide, Long> {
}
