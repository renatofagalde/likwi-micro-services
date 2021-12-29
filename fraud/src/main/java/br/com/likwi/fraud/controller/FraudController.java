package br.com.likwi.fraud.controller;

import br.com.likwi.clients.fraud.FraudCheckResponse;
import br.com.likwi.fraud.record.FraudCheckHistoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v001/fraud-check")
@Slf4j
public record FraudController(FraudCheckHistoryService fraudCheckHistoryService) {

    @GetMapping(path = "{customerId}")
    public FraudCheckResponse isFraudster(@PathVariable("customerId") Long customerId) {
        final boolean isFraudulentCustomer = this.fraudCheckHistoryService.isFraudulentCustomer(customerId);
        log.info("fraud check request for customer " + customerId);
        return new FraudCheckResponse(isFraudulentCustomer);
    }

}
