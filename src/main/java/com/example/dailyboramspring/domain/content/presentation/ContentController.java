package com.example.dailyboramspring.domain.content.presentation;

import com.example.dailyboramspring.domain.content.presentation.dto.request.CreateContentRequest;
import com.example.dailyboramspring.domain.content.service.CreateContentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequiredArgsConstructor
@RestController
@RequestMapping("/content")
public class ContentController {

    private final CreateContentService createContentService;

    @PostMapping("/{episode-id}/{character-id}")
    @ResponseStatus(HttpStatus.CREATED)
    public void createContent(@PathVariable("episode-id") Long episodeId, @PathVariable("character-id") Long characterId, @RequestBody @Valid CreateContentRequest request) {
        createContentService.execute(episodeId, characterId, request);
    }
}
