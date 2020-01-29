package pixeon.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import pixeon.model.Healthcare;

public interface HealthcareRepository extends MongoRepository<Healthcare, String> {
}
