package pixeon.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import pixeon.model.Exam;

import java.util.List;

public interface ExamRepository extends MongoRepository<Exam, String> {

    @Query(value="{ healthcareInstitutionId : ?0}", fields="{ patientName : 1 }")
    List<Exam> findByHealthcareInstitutionId(String healthcareInstitutionId);


}
