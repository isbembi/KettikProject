package kg.alatoo.kettikproject.repositories;


import kg.alatoo.kettikproject.entities.Driver;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class DriverRepositoryTest {
    @Autowired
    private DriverRepository driverRepository;

    @Test
    public void whenSaveDriver_thenFindById(){
        Driver driver = Driver.builder()
                .name("Ivan ")
                .surname("Ivanov")
                .vehicleNumber("01A111AA")
                .experienceYear(9)
                .build();

        Driver savedDriver = driverRepository.save(driver);
        Optional<Driver> foundDriver = driverRepository.findById(savedDriver.getId());

        assertThat(foundDriver).isPresent();
        assertThat(foundDriver.get().getVehicleNumber()).isEqualTo("01A111AA");
    }
}
