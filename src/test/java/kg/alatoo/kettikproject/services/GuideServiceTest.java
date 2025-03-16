package kg.alatoo.kettikproject.services;

import kg.alatoo.kettikproject.entities.Guide;
import kg.alatoo.kettikproject.repositories.GuideRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class GuideServiceTest {

    @Mock
    private GuideRepository guideRepository;

    @InjectMocks
    private GuideService guideService;

    private Guide guide;

    @BeforeEach
    void setUp() {
        guide = new Guide();
        guide.setId(1L);
        guide.setName("Nurzada");
        guide.setSpecialization("Ski bases");
        guide.setLanguage("English");
    }

    @Test
    void whenGetAllGuides_thenReturnList() {
        when(guideRepository.findAll()).thenReturn(List.of(guide));

        List<Guide> guides = guideService.getAllGuides();

        assertThat(guides).isNotEmpty();
        assertThat(guides).hasSize(1);
        assertThat(guides.get(0).getName()).isEqualTo("Nurzada");

        verify(guideRepository, times(1)).findAll();
    }

    @Test
    void whenGetGuideById_thenReturnGuide() {
        when(guideRepository.findById(1L)).thenReturn(Optional.of(guide));

        Optional<Guide> foundGuide = guideService.getGuideById(1L);

        assertThat(foundGuide).isPresent();
        assertThat(foundGuide.get().getName()).isEqualTo("Nurzada");

        verify(guideRepository, times(1)).findById(1L);
    }

    @Test
    void whenSaveGuide_thenReturnSavedGuide() {
        when(guideRepository.save(any(Guide.class))).thenReturn(guide);

        Guide savedGuide = guideService.saveGuide(guide);

        assertThat(savedGuide).isNotNull();
        assertThat(savedGuide.getName()).isEqualTo("Nurzada");

        verify(guideRepository, times(1)).save(guide);
    }

    @Test
    void whenDeleteGuide_thenRepositoryDeleteCalled() {
        doNothing().when(guideRepository).deleteById(1L);

        guideService.deleteGuide(1L);

        verify(guideRepository, times(1)).deleteById(1L);
    }
}
