package pixeon.service;

import feign.FeignException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import pixeon.client.HealthcareClient;
import pixeon.model.Exam;
import pixeon.repository.ExamRepository;

@Service
public class ExamService {

    @Autowired
    private ExamRepository examRepository;

    @Autowired
    HealthcareClient healthcareClient;

    public Exam save(@Validated Exam exam) {
        healthcareClient.charge(exam.getHealthcareInstitutionId());
        return examRepository.save(exam);
    }

    public Exam findById(String id){
        return examRepository.findById(id).get();
    }

    public Iterable<Exam> findAll(){
        return examRepository.findAll();
    }

    public void delete(String id) {
        examRepository.deleteById(id);
    }
}
