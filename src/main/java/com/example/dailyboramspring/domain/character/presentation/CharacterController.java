package com.example.dailyboramspring.domain.character.presentation;

import com.example.dailyboramspring.domain.character.presentation.dto.request.CreateCharacterRequest;
import com.example.dailyboramspring.domain.character.service.CreateCharacterService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequiredArgsConstructor
@RestController
@RequestMapping("/character")
public class CharacterController {

    private final CreateCharacterService createCharacterService;

    @PostMapping("/{series-id}")
    @ResponseStatus(HttpStatus.CREATED)
    public void createCharacter(@PathVariable("series-id") Long seriesId, @RequestBody @Valid CreateCharacterRequest request) {
        createCharacterService.execute(seriesId, request);
    }
}