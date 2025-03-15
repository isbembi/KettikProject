package kg.alatoo.kettikproject.repositories;


import kg.alatoo.kettikproject.entities.Tourist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TouristRepository  extends JpaRepository<Tourist,Long > {

}
