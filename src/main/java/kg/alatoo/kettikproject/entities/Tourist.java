package kg.alatoo.kettikproject.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Entity
@Value
@Builder
@NoArgsConstructor(force = true)
@AllArgsConstructor
@Table(name = "tourists")
public class Tourist {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String name;
    String email;
    String phoneNumber;

    @ManyToMany(mappedBy = "tourists")
    @Builder.Default
    Set<Tour> tours = Set.of();
}
