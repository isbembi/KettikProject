package kg.alatoo.kettikproject.services;

import kg.alatoo.kettikproject.entities.Manager;
import kg.alatoo.kettikproject.repositories.ManagerRepository;
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
public class ManagerServiceTest {

    @Mock
    private ManagerRepository managerRepository;

    @InjectMocks
    private ManagerService managerService;

    private Manager manager;

    @BeforeEach
    void setUp() {
        manager = new Manager();
        manager.setId(1L);
        manager.setName("Chelovek");
        manager.setSurname("Managerov");
        manager.setEmail("managerskiii@gmail.com");
    }

    @Test
    void whenGetAllManagers_thenReturnList() {
        when(managerRepository.findAll()).thenReturn(List.of(manager));

        List<Manager> managers = managerService.getAllManagers();

        assertThat(managers).isNotEmpty();
        assertThat(managers).hasSize(1);
        assertThat(managers.get(0).getName()).isEqualTo("Chelovek");

        verify(managerRepository, times(1)).findAll();
    }

    @Test
    void whenGetManagerById_thenReturnManager() {
        when(managerRepository.findById(1L)).thenReturn(Optional.of(manager));

        Optional<Manager> foundManager = managerService.getManagerById(1L);

        assertThat(foundManager).isPresent();
        assertThat(foundManager.get().getEmail()).isEqualTo("managerskiii@gmail.com");

        verify(managerRepository, times(1)).findById(1L);
    }

    @Test
    void whenSaveManager_thenReturnSavedManager() {
        when(managerRepository.save(any(Manager.class))).thenReturn(manager);

        Manager savedManager = managerService.saveManager(manager);

        assertThat(savedManager).isNotNull();
        assertThat(savedManager.getEmail()).isEqualTo("managerskiii@gmail.com");

        verify(managerRepository, times(1)).save(manager);
    }

    @Test
    void whenDeleteManager_thenRepositoryDeleteCalled() {
        doNothing().when(managerRepository).deleteById(1L);

        managerService.deleteManager(1L);

        verify(managerRepository, times(1)).deleteById(1L);
    }
}
