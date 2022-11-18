package com.example.dailyboramspring.domain.purchase.facade;

import com.example.dailyboramspring.domain.purchase.domain.Purchase;
import com.example.dailyboramspring.domain.purchase.domain.repository.PurchaseRepository;
import com.example.dailyboramspring.domain.user.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@RequiredArgsConstructor
@Component
public class PurchaseFacade {

    private final PurchaseRepository purchaseRepository;

    public List<Purchase> GetAllByUser(User user) {
        return purchaseRepository.findAllByUser(user);
    }
}
