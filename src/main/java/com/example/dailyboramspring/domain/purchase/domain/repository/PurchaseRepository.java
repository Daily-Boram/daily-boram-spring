package com.example.dailyboramspring.domain.purchase.domain.repository;

import com.example.dailyboramspring.domain.purchase.domain.Purchase;
import com.example.dailyboramspring.domain.user.domain.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PurchaseRepository extends CrudRepository<Purchase, Long> {
    List<Purchase> findAllByUser(User user);
}
