package com.group.imdb.repository;

import com.group.imdb.service.dto.TitleDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TitleRepository {


    Page<TitleDTO> findCollaborations(@Param("name1") String name1,
                                      @Param("name2") String name2,
                                      Pageable pageable);

    Page<TitleDTO> advancedSearch(@Param("title") String title,
                                  @Param("releaseDateFrom") Integer releaseDateFrom,
                                  @Param("releaseDateTo") Integer releaseDateTo,
                                  @Param("userRatingFrom") Double userRatingFrom,
                                  @Param("userRatingTo") Double userRatingTo,
                                  @Param("numOfVotesFrom") Integer numOfVotesFrom,
                                  @Param("numOfVotesTo") Integer numOfVotesTo,
                                  @Param("genres") String[] genres,
                                  @Param("titleType") String[] titleType,
                                  Pageable pageable);

    List<TitleDTO> getUserWatchlistTitles(Long userId);

    TitleDTO getTitleById(String id);

    List<String> autocompleteNameSuggestions(String name);

}
