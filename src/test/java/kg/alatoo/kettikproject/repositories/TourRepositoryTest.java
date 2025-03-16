package kg.alatoo.kettikproject.repositories;


import kg.alatoo.kettikproject.entities.Tour;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest
public class TourRepositoryTest {


    @Autowired
    private TourRepository tourRepository;

    @Test
    public void testSaveAndFindTour() {
        Tour tour = Tour.builder()
                .name("Поход на озеро Кол-Тор")
                .description("Сложность маршрута: сложная")
                .date("2025-06-10")
                .build();


        Tour savedTour = tourRepository.save(tour);

        assertThat(savedTour.getId()).isNotNull();

        Tour foundTour = tourRepository.findById(savedTour.getId()).orElse(null);
        assertThat(foundTour).isNotNull();
        assertThat(foundTour.getName()).isEqualTo(tour.getName());
    }
}
