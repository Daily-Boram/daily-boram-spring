package com.example.dailyboramspring.domain.comment.service;

import com.example.dailyboramspring.domain.comment.domain.Comment;
import com.example.dailyboramspring.domain.comment.domain.repository.CommentRepository;
import com.example.dailyboramspring.domain.comment.exception.CommentNotFoundException;
import com.example.dailyboramspring.domain.comment.facade.CommentFacade;
import com.example.dailyboramspring.domain.comment.presentation.dto.request.CreateCommentRequest;
import com.example.dailyboramspring.domain.episode.exception.EpisodeNotFoundException;
import com.example.dailyboramspring.domain.episode.facade.EpisodeFacade;
import com.example.dailyboramspring.domain.user.domain.User;
import com.example.dailyboramspring.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class DeleteCommentService {

    private final UserFacade userFacade;
    private final CommentRepository commentRepository;
    private final CommentFacade commentFacade;
    private final EpisodeFacade episodeFacade;

    @Transactional
    public void execute(Long episodeId) {

        User user = userFacade.getCurrentUser();

        if (!commentFacade.existsCommentByEpisodeAndUser(episodeFacade.getEpisodeById(episodeId), user)) {
            throw CommentNotFoundException.EXCEPTION;
        }

        commentRepository.delete(commentFacade.findCommentByEpisodeAndUser(episodeFacade.getEpisodeById(episodeId), user));
    }
}
