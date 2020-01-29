package pixeon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class HealthcareServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(HealthcareServiceApplication.class, args);
	}
}
