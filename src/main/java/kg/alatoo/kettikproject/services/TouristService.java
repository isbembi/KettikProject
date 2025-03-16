package kg.alatoo.kettikproject.services;

import kg.alatoo.kettikproject.entities.Tourist;
import kg.alatoo.kettikproject.repositories.TouristRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TouristService {

    private final TouristRepository touristRepository;

    public TouristService(TouristRepository touristRepository) {
        this.touristRepository = touristRepository;
    }

    public List<Tourist> getAllTourists() {
        return touristRepository.findAll();
    }

    public Optional<Tourist> getTouristById(Long id) {
        return touristRepository.findById(id);
    }

    public Tourist saveTourist(Tourist tourist) {
        return touristRepository.save(tourist);
    }

    public Tourist updateTourist(Long id, Tourist updatedTourist) {
        return touristRepository.findById(id).map(tourist -> {
            tourist.setName(updatedTourist.getName());
            tourist.setEmail(updatedTourist.getEmail());
            tourist.setPhoneNumber(updatedTourist.getPhoneNumber());
            return touristRepository.save(tourist);
        }).orElseThrow(() -> new RuntimeException("Tourist not found"));
    }

    public void deleteTourist(Long id) {
        touristRepository.deleteById(id);
    }

    public List<Tourist> findByEmail(String email) {
        return touristRepository.findAll()
                .stream()
                .filter(t -> t.getEmail().equalsIgnoreCase(email))
                .toList();
    }
}
