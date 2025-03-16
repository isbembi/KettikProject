package kg.alatoo.kettikproject.services;

import kg.alatoo.kettikproject.entities.Driver;
import kg.alatoo.kettikproject.repositories.DriverRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DriverService {

    private final DriverRepository driverRepository;

    public DriverService(DriverRepository driverRepository) {
        this.driverRepository = driverRepository;
    }

    public List<Driver> getAllDrivers() {
        return driverRepository.findAll();
    }

    public Optional<Driver> getDriverById(Long id) {
        return driverRepository.findById(id);
    }

    public Driver saveDriver(Driver driver) {
        return driverRepository.save(driver);
    }

    public Driver updateDriver(Long id, Driver updatedDriver) {
        return driverRepository.findById(id).map(driver -> {
            driver.setName(updatedDriver.getName());
            driver.setVehicleNumber(updatedDriver.getVehicleNumber());
            driver.setExperienceYear(updatedDriver.getExperienceYear());
            return driverRepository.save(driver);
        }).orElseThrow(() -> new RuntimeException("Driver not found"));
    }

    public void deleteDriver(Long id) {
        driverRepository.deleteById(id);
    }
}
