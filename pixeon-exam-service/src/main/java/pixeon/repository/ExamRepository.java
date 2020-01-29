package pixeon.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import pixeon.model.Exam;

public interface ExamRepository extends MongoRepository<Exam, String> {
}
