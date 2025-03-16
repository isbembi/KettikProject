package kg.alatoo.kettikproject.services;

import kg.alatoo.kettikproject.entities.Tour;
import kg.alatoo.kettikproject.repositories.TourRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class TourServiceTest {

    @Mock
    private TourRepository tourRepository;

    @InjectMocks
    private TourService tourService;

    private Tour tour;

    @BeforeEach
    void setUp() {
        tour = new Tour();
        tour.setId(1L);
        tour.setName("Горный поход");
        tour.setDescription("Поход в горы с гидом");
    }

    @Test
    void whenGetAllTours_thenReturnList() {
        when(tourRepository.findAll()).thenReturn(List.of(tour));

        List<Tour> tours = tourService.getAllTours();

        assertThat(tours).isNotEmpty();
        assertThat(tours).hasSize(1);
        assertThat(tours.get(0).getName()).isEqualTo("Горный поход");

        verify(tourRepository, times(1)).findAll();
    }

    @Test
    void whenGetTourById_thenReturnTour() {
        when(tourRepository.findById(1L)).thenReturn(Optional.of(tour));

        Optional<Tour> foundTour = tourService.getTourById(1L);

        assertThat(foundTour).isPresent();
        assertThat(foundTour.get().getName()).isEqualTo("Горный поход");

        verify(tourRepository, times(1)).findById(1L);
    }

    @Test
    void whenSaveTour_thenReturnSavedTour() {
        when(tourRepository.save(any(Tour.class))).thenReturn(tour);

        Tour savedTour = tourService.saveTour(tour);

        assertThat(savedTour).isNotNull();
        assertThat(savedTour.getName()).isEqualTo("Горный поход");

        verify(tourRepository, times(1)).save(tour);
    }

    @Test
    void whenDeleteTour_thenRepositoryDeleteCalled() {
        doNothing().when(tourRepository).deleteById(1L);

        tourService.deleteTour(1L);

        verify(tourRepository, times(1)).deleteById(1L);
    }
}
