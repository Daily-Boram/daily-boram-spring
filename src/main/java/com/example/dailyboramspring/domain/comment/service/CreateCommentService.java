package com.example.dailyboramspring.domain.comment.service;

import com.example.dailyboramspring.domain.comment.domain.Comment;
import com.example.dailyboramspring.domain.comment.domain.repository.CommentRepository;
import com.example.dailyboramspring.domain.comment.presentation.dto.request.CreateCommentRequest;
import com.example.dailyboramspring.domain.episode.exception.EpisodeNotFoundException;
import com.example.dailyboramspring.domain.episode.facade.EpisodeFacade;
import com.example.dailyboramspring.domain.user.domain.User;
import com.example.dailyboramspring.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CreateCommentService {

    private final UserFacade userFacade;
    private final CommentRepository commentRepository;
    private final EpisodeFacade episodeFacade;

    @Transactional
    public void execute(Long episodeId, CreateCommentRequest request) {

        User user = userFacade.getCurrentUser();

        if (!episodeFacade.existEpisodeById(episodeId)) {
            throw EpisodeNotFoundException.EXCEPTION;
        }

        commentRepository.save(
                Comment.builder()
                        .user(user)
                        .episode(episodeFacade.getEpisodeById(episodeId))
                        .content(request.getContent())
                        .build()
        );
    }
}
