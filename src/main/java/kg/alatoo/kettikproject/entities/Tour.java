package kg.alatoo.kettikproject.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.Set;

@Entity
@Value
@Builder
@NoArgsConstructor(force = true)
@AllArgsConstructor
@Table(name = "tours")
public class Tour {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String name;
    String description;
    String date;

    @ManyToOne
    Guide guide;

    @ManyToOne
    Driver driver;

    @ManyToOne
    Manager manager;

    @ManyToMany
    Set<Tourist> tourists= Set.of();
}
