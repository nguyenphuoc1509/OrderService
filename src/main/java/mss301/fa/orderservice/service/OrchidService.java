package mss301.fa.orderservice.service;

import mss301.fa.orderservice.dto.OrchidDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "orchid-service", url = "http://localhost:8082")
public interface OrchidService {
    @GetMapping("/api/orchids/{id}")
    OrchidDTO getOrchid(@PathVariable("id") Long id);
}
