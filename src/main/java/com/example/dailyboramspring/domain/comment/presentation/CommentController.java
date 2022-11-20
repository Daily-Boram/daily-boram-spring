package com.example.dailyboramspring.domain.comment.presentation;

import com.example.dailyboramspring.domain.comment.presentation.dto.request.CreateCommentRequest;
import com.example.dailyboramspring.domain.comment.presentation.dto.response.GetCommentResponse;
import com.example.dailyboramspring.domain.comment.service.CreateCommentService;
import com.example.dailyboramspring.domain.comment.service.DeleteCommentService;
import com.example.dailyboramspring.domain.comment.service.GetCommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/comment")
public class CommentController {

    private final CreateCommentService createCommentService;
    private final DeleteCommentService deleteCommentService;
    private final GetCommentService getCommentService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/{episode-id}")
    public void createComment(@PathVariable(name = "episode-id") Long episodeId, @RequestBody @Valid CreateCommentRequest request) {
        createCommentService.execute(episodeId, request);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{comment-id}")
    public void deleteComment(@PathVariable(name = "comment-id") Long episodeId) {
        deleteCommentService.execute(episodeId);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{episode-id}")
    public GetCommentResponse getComment(@PathVariable(name = "episode-id") Long episodeId) {
        return getCommentService.execute(episodeId);
    }
}
