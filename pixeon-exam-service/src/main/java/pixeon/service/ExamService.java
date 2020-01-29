package pixeon.service;

import feign.FeignException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import pixeon.client.HealthcareClient;
import pixeon.exception.NotFoundException;
import pixeon.model.Exam;
import pixeon.repository.ExamRepository;

import java.util.List;
import java.util.Optional;

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

    public Exam update(@Validated Exam exam) {
        return examRepository.save(exam);
    }


    public Exam findById(String id){
        return examRepository.findById(id).orElseThrow(() -> new NotFoundException());
    }

    public Exam retrieve(String id){
        Exam exam = findById(id);
        if (!exam.getRetrieved()) {
            healthcareClient.charge(exam.getHealthcareInstitutionId());
            exam.setRetrieved(true);
            examRepository.save(exam);
        }
        return exam;
    }

    public List<Exam> findByHealthcareInstitutionId(String healthcareInstitutionId){
        return examRepository.findByHealthcareInstitutionId(healthcareInstitutionId);
    }

    public void delete(String id) {
        findById(id);
        examRepository.deleteById(id);
    }
}
