package com.example.dailyboramspring.domain.comment.domain.repository;

import com.example.dailyboramspring.domain.comment.domain.Comment;
import com.example.dailyboramspring.domain.episode.domain.Episode;
import com.example.dailyboramspring.domain.user.domain.User;
import org.springframework.data.repository.CrudRepository;

public interface CommentRepository extends CrudRepository<Comment, Long> {
    Comment findCommentByEpisodeAndUser(Episode episode, User user);
    Boolean existsCommentByEpisodeAndUser(Episode episode, User user);
}
