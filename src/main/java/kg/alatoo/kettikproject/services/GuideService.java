package kg.alatoo.kettikproject.services;

import kg.alatoo.kettikproject.entities.Guide;
import kg.alatoo.kettikproject.repositories.GuideRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GuideService {

    private final GuideRepository guideRepository;

    public GuideService(GuideRepository guideRepository) {
        this.guideRepository = guideRepository;
    }

    public List<Guide> getAllGuides() {
        return guideRepository.findAll();
    }

    public Optional<Guide> getGuideById(Long id) {
        return guideRepository.findById(id);
    }

    public Guide saveGuide(Guide guide) {
        return guideRepository.save(guide);
    }

    public Guide updateGuide(Long id, Guide updatedGuide) {
        return guideRepository.findById(id).map(guide -> {
            guide.setName(updatedGuide.getName());
            guide.setLanguage(updatedGuide.getLanguage());
            guide.setRating(updatedGuide.getRating());
            return guideRepository.save(guide);
        }).orElseThrow(() -> new RuntimeException("Guide not found"));
    }

    public void deleteGuide(Long id) {
        guideRepository.deleteById(id);
    }

    public List<Guide> findGuidesByLanguage(String language) {
        return guideRepository.findAll()
                .stream()
                .filter(g -> g.getLanguage().equalsIgnoreCase(language))
                .toList();
    }
}
