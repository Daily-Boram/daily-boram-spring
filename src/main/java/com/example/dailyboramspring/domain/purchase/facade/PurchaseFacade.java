package com.example.dailyboramspring.domain.purchase.facade;

import com.example.dailyboramspring.domain.episode.domain.Episode;
import com.example.dailyboramspring.domain.episode.domain.repository.EpisodeRepository;
import com.example.dailyboramspring.domain.purchase.domain.Purchase;
import com.example.dailyboramspring.domain.purchase.domain.repository.PurchaseRepository;
import com.example.dailyboramspring.domain.series.domain.Series;
import com.example.dailyboramspring.domain.user.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@RequiredArgsConstructor
@Component
public class PurchaseFacade {

    private final PurchaseRepository purchaseRepository;
    private final EpisodeRepository episodeRepository;

    public List<Purchase> GetAllByUser(User user) {
        return purchaseRepository.findAllByUser(user);
    }

    public void deletePurchase(Series series) {
        List<Episode> episodes = episodeRepository.findAllBySeries(series);

        for (Episode episode : episodes) {
            purchaseRepository.deleteAllByEpisode(episode);
        }
    }
}