package kg.alatoo.kettikproject.services;

import kg.alatoo.kettikproject.entities.Tour;
import kg.alatoo.kettikproject.repositories.TourRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TourService {

    private final TourRepository tourRepository;

    public TourService(TourRepository tourRepository) {
        this.tourRepository = tourRepository;
    }

    public List<Tour> getAllTours() {
        return tourRepository.findAll();
    }

    public Optional<Tour> getTourById(Long id) {
        return tourRepository.findById(id);
    }

    public Tour saveTour(Tour tour) {
        return tourRepository.save(tour);
    }

    public Tour updateTour(Long id, Tour updatedTour) {
        return tourRepository.findById(id).map(tour -> {
            tour.setName(updatedTour.getName());
            tour.setDescription(updatedTour.getDescription());
            tour.setDate(updatedTour.getDate());
            return tourRepository.save(tour);
        }).orElseThrow(() -> new RuntimeException("Tour not found"));
    }

    public void deleteTour(Long id) {
        tourRepository.deleteById(id);
    }

    public List<Tour> findToursByName(String name) {
        return tourRepository.findAll()
                .stream()
                .filter(t -> t.getName().equalsIgnoreCase(name))
                .toList();
    }

    public long countTours() {
        return tourRepository.count();
    }
}
