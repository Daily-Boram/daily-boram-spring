package com.example.dailyboramspring.domain.purchase.domain.repository;

import com.example.dailyboramspring.domain.purchase.domain.Purchase;
import org.springframework.data.repository.CrudRepository;

public interface PurchaseRepository extends CrudRepository<Purchase, Long> {
}
