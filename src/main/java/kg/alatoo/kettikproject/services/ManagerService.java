package kg.alatoo.kettikproject.services;

import kg.alatoo.kettikproject.entities.Manager;
import kg.alatoo.kettikproject.repositories.ManagerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ManagerService {

    private final ManagerRepository managerRepository;

    public ManagerService(ManagerRepository managerRepository) {
        this.managerRepository = managerRepository;
    }

    public List<Manager> getAllManagers() {
        return managerRepository.findAll();
    }

    public Optional<Manager> getManagerById(Long id) {
        return managerRepository.findById(id);
    }

    public Manager saveManager(Manager manager) {
        return managerRepository.save(manager);
    }

    public Manager updateManager(Long id, Manager updatedManager) {
        return managerRepository.findById(id).map(manager -> {
            manager.setName(updatedManager.getName());
            manager.setEmail(updatedManager.getEmail());
            manager.setPhoneNumber(updatedManager.getPhoneNumber());
            return managerRepository.save(manager);
        }).orElseThrow(() -> new RuntimeException("Manager not found"));
    }

    public void deleteManager(Long id) {
        managerRepository.deleteById(id);
    }
}
