package kg.alatoo.kettikproject.repositories;

import kg.alatoo.kettikproject.entities.Manager;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ManagerRepository extends JpaRepository<Manager,Long >  {
}
