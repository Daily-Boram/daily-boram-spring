package com.example.dailyboramspring.domain.comment.service;

import com.example.dailyboramspring.domain.comment.domain.repository.CommentRepository;
import com.example.dailyboramspring.domain.comment.exception.CommentNotFoundException;
import com.example.dailyboramspring.domain.comment.facade.CommentFacade;
import com.example.dailyboramspring.domain.episode.facade.EpisodeFacade;
import com.example.dailyboramspring.domain.user.domain.User;
import com.example.dailyboramspring.domain.user.exception.ForbiddenUserException;
import com.example.dailyboramspring.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class DeleteCommentService {

    private final UserFacade userFacade;
    private final CommentRepository commentRepository;
    private final CommentFacade commentFacade;
    private final EpisodeFacade episodeFacade;

    @Transactional
    public void execute(Long commentId) {

        User user = userFacade.getCurrentUser();

        if (!commentFacade.findCommentById(commentId).getUser().equals(user)) {
            throw ForbiddenUserException.EXCEPTION;
        }

        commentRepository.delete(commentFacade.findCommentById(commentId));
    }
}
