package com.example.dailyboramspring.domain.comment.domain.repository;

import com.example.dailyboramspring.domain.comment.domain.Comment;
import org.springframework.data.repository.CrudRepository;

public interface CommentRepository extends CrudRepository<Comment, Long> {
}
