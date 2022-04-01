package com.harry05.fraud;

import org.springframework.data.jpa.repository.JpaRepository;

public interface FraudCheckHistoryRepositories extends JpaRepository<FraudCheckHistory,Integer> {
}
