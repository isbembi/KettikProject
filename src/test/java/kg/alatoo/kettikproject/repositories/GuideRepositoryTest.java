package kg.alatoo.kettikproject.repositories;


import kg.alatoo.kettikproject.entities.Guide;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class GuideRepositoryTest {

    @Autowired
    private GuideRepository guideRepository;

    @Test
    public void whenSaveGuide_thenFindById(){

        Guide guide = Guide.builder()
                .name("Nurzada Aldzhanova")
                .specialization("Ski bases")
                .language("English")
                .rating(5.0)
                .build();


        Guide savedGuide = guideRepository.save(guide);
        Optional<Guide> foundGuide = guideRepository.findById(savedGuide.getId());

        assertThat(foundGuide).isPresent();
        assertThat(foundGuide.get().getName()).isEqualTo("Nurzada Aldzhanova");
    }
}
