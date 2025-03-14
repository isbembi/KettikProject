package kg.alatoo.kettikproject.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Value
@Builder
@NoArgsConstructor(force = true)
@AllArgsConstructor
@Table(name = "guides")
public class Guide {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String name;
    String specialization;
    String language;
    double rating;

    @OneToMany(mappedBy = "guide")
    @Builder.Default
    List<Tour> tours = List.of();
}
