package kg.alatoo.kettikproject.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor(force = true)
@AllArgsConstructor
@Table(name = "drivers")
public class Driver {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String name;
    String surname;
    String vehicleNumber;
    int experienceYear;

    @OneToMany(mappedBy = "driver")
    @Builder.Default
    List<Tour> tours = List.of();
}
