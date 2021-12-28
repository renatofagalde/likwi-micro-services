package br.com.likwi.fraud.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class FraudCheckHistory {
    @Id
    @SequenceGenerator(
            name = "fraudCheckHistoru_id_sequence",
            sequenceName = "fraudCheckHistoru_id_sequence"
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "fraudCheckHistoru_id_sequence"
    )
    private Long id;
    private Long customerId;
    private Boolean isFraudster;
    private LocalDateTime createdAt;
}
