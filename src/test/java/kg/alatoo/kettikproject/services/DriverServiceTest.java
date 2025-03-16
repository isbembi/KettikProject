package kg.alatoo.kettikproject.services;

import kg.alatoo.kettikproject.entities.Driver;
import kg.alatoo.kettikproject.repositories.DriverRepository;
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
public class DriverServiceTest {

    @Mock
    private DriverRepository driverRepository;

    @InjectMocks
    private DriverService driverService;

    private Driver driver;

    @BeforeEach
    void setUp() {
        driver = new Driver();
        driver.setId(1L);
        driver.setName("Алексей");
        driver.setVehicleNumber("AB123456");
    }

    @Test
    void whenGetAllDrivers_thenReturnList() {
        when(driverRepository.findAll()).thenReturn(List.of(driver));

        List<Driver> drivers = driverService.getAllDrivers();

        assertThat(drivers).isNotEmpty();
        assertThat(drivers).hasSize(1);
        assertThat(drivers.get(0).getName()).isEqualTo("Алексей");

        verify(driverRepository, times(1)).findAll();
    }

    @Test
    void whenGetDriverById_thenReturnDriver() {
        when(driverRepository.findById(1L)).thenReturn(Optional.of(driver));

        Optional<Driver> foundDriver = driverService.getDriverById(1L);

        assertThat(foundDriver).isPresent();
        assertThat(foundDriver.get().getVehicleNumber()).isEqualTo("AB123456");

        verify(driverRepository, times(1)).findById(1L);
    }

    @Test
    void whenSaveDriver_thenReturnSavedDriver() {
        when(driverRepository.save(any(Driver.class))).thenReturn(driver);

        Driver savedDriver = driverService.saveDriver(driver);

        assertThat(savedDriver).isNotNull();
        assertThat(savedDriver.getVehicleNumber()).isEqualTo("AB123456");

        verify(driverRepository, times(1)).save(driver);
    }

    @Test
    void whenDeleteDriver_thenRepositoryDeleteCalled() {
        doNothing().when(driverRepository).deleteById(1L);

        driverService.deleteDriver(1L);

        verify(driverRepository, times(1)).deleteById(1L);
    }
}
