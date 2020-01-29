package pixeon.client;

import feign.Param;

//@FeignClient(name = "delivery-payments-service")
public interface HealthcareClient {

//	@GetMapping("/api/payments-status/{orderCode}")
	String checkStatus(@Param("orderCode") String orderCode);
}
