package kg.alatoo.kettikproject.services;

import kg.alatoo.kettikproject.entities.Tourist;
import kg.alatoo.kettikproject.repositories.TouristRepository;
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
public class TouristServiceTest {

    @Mock
    private TouristRepository touristRepository;

    @InjectMocks
    private TouristService touristService;

    private Tourist tourist;

    @BeforeEach
    void setUp() {
        tourist = new Tourist();
        tourist.setId(1L);
        tourist.setName("Bermet");
        tourist.setSurname("Iskenderova");
        tourist.setEmail("bem@gmail.com");
    }

    @Test
    void whenGetAllTourists_thenReturnList() {
        when(touristRepository.findAll()).thenReturn(List.of(tourist));

        List<Tourist> tourists = touristService.getAllTourists();

        assertThat(tourists).isNotEmpty();
        assertThat(tourists).hasSize(1);
        assertThat(tourists.get(0).getName()).isEqualTo("Bermet");

        verify(touristRepository, times(1)).findAll();
    }

    @Test
    void whenGetTouristById_thenReturnTourist() {
        when(touristRepository.findById(1L)).thenReturn(Optional.of(tourist));

        Optional<Tourist> foundTourist = touristService.getTouristById(1L);

        assertThat(foundTourist).isPresent();
        assertThat(foundTourist.get().getName()).isEqualTo("Bermet");

        verify(touristRepository, times(1)).findById(1L);
    }

    @Test
    void whenSaveTourist_thenReturnSavedTourist() {
        when(touristRepository.save(any(Tourist.class))).thenReturn(tourist);

        Tourist savedTourist = touristService.saveTourist(tourist);

        assertThat(savedTourist).isNotNull();
        assertThat(savedTourist.getName()).isEqualTo("Bermet");

        verify(touristRepository, times(1)).save(tourist);
    }

    @Test
    void whenDeleteTourist_thenRepositoryDeleteCalled() {
        doNothing().when(touristRepository).deleteById(1L);

        touristService.deleteTourist(1L);

        verify(touristRepository, times(1)).deleteById(1L);
    }
}
