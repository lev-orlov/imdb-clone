package com.group.imdb.controller;

import com.group.imdb.repository.TitleRepository;
import com.group.imdb.service.dto.TitleDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/search")
public class SearchController {
    private final TitleRepository titleRepository;

    public SearchController(TitleRepository titleRepository) {
        this.titleRepository = titleRepository;
    }

    @GetMapping("/name")
    public List<String> autocompleteQuery(@RequestParam String name) {
        return titleRepository.autocompleteNameSuggestions(name);
    }

    @GetMapping("/collaborations")
    public Page<TitleDTO> getCollaborations(@RequestParam String name1,
                                            @RequestParam String name2,
                                            Pageable pageable) {
        return titleRepository.findCollaborations(name1, name2, pageable);
    }

    @GetMapping("/advanced")
    public Page<TitleDTO> getAdvancedSearch(@RequestParam(required = false) String title,
                                            @RequestParam(required = false) Integer releaseDateFrom,
                                            @RequestParam(required = false) Integer releaseDateTo,
                                            @RequestParam(required = false) Double userRatingFrom,
                                            @RequestParam(required = false) Double userRatingTo,
                                            @RequestParam(required = false) Integer numOfVotesFrom,
                                            @RequestParam(required = false) Integer numOfVotesTo,
                                            @RequestParam(required = false) String[] genres,
                                            @RequestParam(required = false) String[] titleType,
                                            Pageable pageable) {
        return titleRepository.advancedSearch(
                title, releaseDateFrom,
                releaseDateTo, userRatingFrom,
                userRatingTo, numOfVotesFrom,
                numOfVotesTo, genres, titleType, pageable);
    }
}
