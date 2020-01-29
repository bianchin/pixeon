package pixeon.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import pixeon.exception.NotFoundException;
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
        Healthcare healthcare = findById(id);
        Integer coins = healthcare.getCoins();
        if (coins==0) {
            return false;
        }
        coins--;
        healthcare.setCoins(coins);
        healthcareRepository.save(healthcare);
        return true;
    }

    public Healthcare findById(String id){
        return healthcareRepository.findById(id).orElseThrow(() -> new NotFoundException());
    }


    public Iterable<Healthcare> findAll(){
        return healthcareRepository.findAll();
    }


}
