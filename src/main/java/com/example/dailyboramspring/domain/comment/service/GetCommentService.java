package com.example.dailyboramspring.domain.comment.service;

import com.example.dailyboramspring.domain.comment.facade.CommentFacade;
import com.example.dailyboramspring.domain.comment.presentation.dto.response.CommentElement;
import com.example.dailyboramspring.domain.comment.presentation.dto.response.GetCommentResponse;
import com.example.dailyboramspring.domain.episode.facade.EpisodeFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class GetCommentService {

    private final CommentFacade commentFacade;
    private final EpisodeFacade episodeFacade;

    public GetCommentResponse execute(Long episodeId) {

        List<CommentElement> commentsList = commentFacade.findAllByEpisode(episodeFacade.getEpisodeById(episodeId))
                .stream()
                .map(comment -> CommentElement.builder()
                        .id(comment.getUser().getId())
                        .image(comment.getUser().getImage())
                        .nickname(comment.getUser().getNickname())
                        .content(comment.getContent())
                        .build())
                .collect(Collectors.toList());

        return new GetCommentResponse(commentsList);
    }
}
