package kg.alatoo.kettikproject.entities;

import jakarta.persistence.*;
import lombok.*;
import java.util.Set;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor(force = true)
@AllArgsConstructor
@Table(name = "tours")
public class Tour {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;

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
