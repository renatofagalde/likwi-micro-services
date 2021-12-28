package br.com.likwi.fraud.dao;

import br.com.likwi.fraud.model.FraudCheckHistory;
import org.springframework.data.repository.CrudRepository;

public interface FraudCheckHistoryRepository extends CrudRepository<FraudCheckHistory, Long> {
}
