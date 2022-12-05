package com.example.dailyboramspring.domain.series.service;

import com.example.dailyboramspring.domain.character.domain.repository.CharacterRepository;
import com.example.dailyboramspring.domain.comment.domain.repository.CommentRepository;
import com.example.dailyboramspring.domain.comment.facade.CommentFacade;
import com.example.dailyboramspring.domain.content.domain.repository.ContentRepository;
import com.example.dailyboramspring.domain.content.facade.ContentFacade;
import com.example.dailyboramspring.domain.episode.domain.repository.EpisodeRepository;
import com.example.dailyboramspring.domain.episodelike.domain.repository.EpisodeLikeRepository;
import com.example.dailyboramspring.domain.episodelike.facade.EpisodeLikeFacade;
import com.example.dailyboramspring.domain.genre.domain.repository.GenreRepository;
import com.example.dailyboramspring.domain.purchase.domain.repository.PurchaseRepository;
import com.example.dailyboramspring.domain.purchase.facade.PurchaseFacade;
import com.example.dailyboramspring.domain.series.domain.Series;
import com.example.dailyboramspring.domain.series.domain.repository.SeriesRepository;
import com.example.dailyboramspring.domain.series.facade.SeriesFacade;
import com.example.dailyboramspring.domain.serieslike.domain.repository.SeriesLikeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class DeleteSeriesService {
    private final SeriesRepository seriesRepository;
    private final SeriesLikeRepository seriesLikeRepository;
    private final PurchaseFacade purchaseFacade;
    private final GenreRepository genreRepository;
    private final EpisodeLikeFacade episodeLikeFacade;
    private final EpisodeRepository episodeRepository;
    private final ContentFacade contentFacade;
    private final CommentFacade commentFacade;
    private final CharacterRepository characterRepository;
    private final SeriesFacade seriesFacade;

    @Transactional
    public void execute(Long id) {
        Series series = seriesFacade.findById(id);

        contentFacade.deleteContent(series);
        commentFacade.deleteComment(series);
        purchaseFacade.deletePurchase(series);
        episodeLikeFacade.deleteEpisodeLike(series);
        episodeRepository.deleteAllBySeries(series);
        characterRepository.deleteAllBySeries(series);
        genreRepository.deleteAllBySeries(series);
        seriesLikeRepository.deleteAllBySeries(series);
        seriesRepository.delete(series);
    }
}
