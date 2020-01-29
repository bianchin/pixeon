package pixeon.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import pixeon.model.Healthcare;
import pixeon.repository.HealthcareRepository;

import java.util.UUID;

@Service
public class HealthcareService {

    @Autowired
    private HealthcareRepository healthcareRepository;

    public Healthcare save(@Validated Healthcare healthcare) {
        healthcare.setCoins(20);
        return healthcareRepository.save(healthcare);
    }

    public Boolean charge(String id){
        Healthcare healthcare = healthcareRepository.findById(id).get();
        Integer coins = healthcare.getCoins();
        if (coins==0) {
            return false;
        }
        coins--;
        healthcare.setCoins(coins);
        healthcareRepository.save(healthcare);
        return true;
    }

    public Iterable<Healthcare> findAll(){
        return healthcareRepository.findAll();
    }

    public void delete(String id) {
        healthcareRepository.deleteById(id);
    }
}
