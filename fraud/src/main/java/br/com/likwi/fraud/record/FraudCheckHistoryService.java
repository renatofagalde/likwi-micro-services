package br.com.likwi.fraud.record;

import br.com.likwi.fraud.dao.FraudCheckHistoryRepository;
import br.com.likwi.fraud.model.FraudCheckHistory;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public record FraudCheckHistoryService(FraudCheckHistoryRepository fraudCheckHistoryRepository) {

    public boolean isFraudulentCustomer(Long customerId) {

        fraudCheckHistoryRepository.save(
                FraudCheckHistory.builder()
                        .customerId(customerId)
                        .isFraudster(Boolean.FALSE)
                        .createdAt(LocalDateTime.now())
                        .build()
        );

        return false;
    }

}
