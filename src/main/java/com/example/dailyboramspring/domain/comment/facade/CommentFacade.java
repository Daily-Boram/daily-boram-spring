package com.example.dailyboramspring.domain.comment.facade;

import com.example.dailyboramspring.domain.comment.domain.Comment;
import com.example.dailyboramspring.domain.comment.domain.repository.CommentRepository;
import com.example.dailyboramspring.domain.comment.exception.CommentNotFoundException;
import com.example.dailyboramspring.domain.episode.domain.Episode;
import com.example.dailyboramspring.domain.user.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@RequiredArgsConstructor
@Component
public class CommentFacade {

    private final CommentRepository commentRepository;

    public Comment findCommentByEpisodeAndUser(Episode episode, User user) {
        return commentRepository.findCommentByEpisodeAndUser(episode, user);
    }

    public Comment findCommentById(Long id) {
        return commentRepository.findCommentById(id)
                .orElseThrow(() -> CommentNotFoundException.EXCEPTION);
    }

    public List<Comment> findAllByEpisode(Episode episode) {
        return commentRepository.findAllByEpisode(episode);
    }
}
