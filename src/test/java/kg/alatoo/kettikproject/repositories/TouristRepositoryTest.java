package kg.alatoo.kettikproject.repositories;


import kg.alatoo.kettikproject.entities.Tourist;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;
import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class TouristRepositoryTest  {

    @Autowired
    private TouristRepository touristRepository;

    @Test
    public void whenSaveTourist_thenFindById(){
        Tourist tourist = Tourist.builder()
            .name("Bermet")
            .surname("Iskenderova")
            .email("bem@gmail.com")
            .phoneNumber("+996507777777")
            .build();

    Tourist savedTourist = touristRepository.save(tourist);

    Optional<Tourist> foundTourist = touristRepository.findById(savedTourist.getId());


    assertThat(foundTourist).isPresent();
    assertThat(foundTourist.get().getEmail()).isEqualTo("bem@gmail.com" );


    }
}
