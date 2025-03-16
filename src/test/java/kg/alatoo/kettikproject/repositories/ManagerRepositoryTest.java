package kg.alatoo.kettikproject.repositories;

import kg.alatoo.kettikproject.entities.Manager;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class ManagerRepositoryTest {

    @Autowired
    private ManagerRepository managerRepository;

    @Test
    public void whenSaveManager_thenFindById() {
        Manager manager = Manager.builder()
                .name("Zhyldyz")
                .surname("Karypkulova")
                .email("zhyldyz.karypkulova@gmail.com")
                .phoneNumber("+996709797979")
                .build();


        Manager savedManager = managerRepository.save(manager);

        Optional<Manager> foundManager = managerRepository.findById(savedManager.getId());

        assertThat(foundManager).isPresent();
        assertThat(foundManager.get().getEmail()).isEqualTo("zhyldyz.karypkulova@gmail.com");
    }
}
