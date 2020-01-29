package pixeon.client;

import feign.Param;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(name = "pixeon-healthcare-service")
public interface HealthcareClient {

	@PostMapping("/api/healthcares/{id}/charge")
	void charge(@PathVariable("id") String id);
}
