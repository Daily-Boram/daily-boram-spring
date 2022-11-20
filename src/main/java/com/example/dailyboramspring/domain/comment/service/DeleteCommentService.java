package com.example.dailyboramspring.domain.comment.service;

import com.example.dailyboramspring.domain.comment.domain.Comment;
import com.example.dailyboramspring.domain.comment.domain.repository.CommentRepository;
import com.example.dailyboramspring.domain.comment.facade.CommentFacade;
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

    @Transactional
    public void execute(Long commentId) {

        User user = userFacade.getCurrentUser();

        Comment comment = commentFacade.findCommentById(commentId);

        if (!comment.getUser().equals(user)) {
            throw ForbiddenUserException.EXCEPTION;
        }

        commentRepository.delete(comment);
    }
}
