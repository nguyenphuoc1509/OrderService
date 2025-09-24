package mss301.fa.orderservice.service;

import mss301.fa.orderservice.dto.AccountDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "account-service", url = "http://localhost:8081")
public interface AccountService {
    @GetMapping("/api/accounts/{id}")
    AccountDTO getAccount(@PathVariable("id") Long id);
}
