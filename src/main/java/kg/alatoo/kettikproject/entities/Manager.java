package kg.alatoo.kettikproject.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Value
@Builder
@NoArgsConstructor(force = true)
@AllArgsConstructor
@Table(name = "managers")
public class Manager {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//autoincrements value of id
    long id;

    String name;
    String department;

    @OneToMany(mappedBy = "manager")
    List<Tour> managedTours = List.of();
}
