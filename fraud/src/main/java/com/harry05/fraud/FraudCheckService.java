package com.harry05.fraud;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@AllArgsConstructor
@Service
public class FraudCheckService {

    private final FraudCheckHistoryRepositories fraudCheckHistoryRepositories;

    public boolean isFraudulentCustomer( Integer customerId ) {
        fraudCheckHistoryRepositories.save(
                FraudCheckHistory.builder()
                        .customerId(customerId)
                        .isFraudster(false)
                        .createdAt(LocalDateTime.now()).build()
        );
        return false;
    }

}