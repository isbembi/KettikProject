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
@Table(name = "managers")
public class Manager {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//autoincrements value of id
    long id;

    String name;
    String surname;
    String email;
    String phoneNumber;

    @OneToMany(mappedBy = "manager")
    List<Tour> managedTours = List.of();
}
