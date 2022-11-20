package com.example.dailyboramspring.domain.comment.presentation;

import com.example.dailyboramspring.domain.comment.presentation.dto.request.CreateCommentRequest;
import com.example.dailyboramspring.domain.comment.service.CreateCommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
public class CommentController {

    private final CreateCommentService createCommentService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/{episode-id}")
    public void createComment(@PathVariable(name = "episode-id") Long episodeId, @RequestBody @Valid CreateCommentRequest request) {
        createCommentService.execute(episodeId, request);
    }
}
