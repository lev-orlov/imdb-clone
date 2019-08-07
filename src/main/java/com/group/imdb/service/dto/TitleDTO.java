package com.group.imdb.service.dto;

import java.math.BigDecimal;
import java.util.Objects;
import java.util.Set;

public class TitleDTO {
    private String id;
    private String title;
    private String type;
    private Integer startYear;
    private Set<String> genres;
    private BigDecimal rating;
    private String stars;
    private Boolean watched;

    public TitleDTO() {
    }

    public TitleDTO(String id, String title, String type, Integer startYear,
                    Set<String> genres, BigDecimal rating, String stars, Boolean watched) {
        this.id = id;
        this.title = title;
        this.type = type;
        this.startYear = startYear;
        this.genres = genres;
        this.rating = rating;
        this.stars = stars;
        this.watched = watched;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getStartYear() {
        return startYear;
    }

    public void setStartYear(Integer startYear) {
        this.startYear = startYear;
    }

    public Set<String> getGenres() {
        return genres;
    }

    public void setGenres(Set<String> genres) {
        this.genres = genres;
    }

    public BigDecimal getRating() {
        return rating;
    }

    public void setRating(BigDecimal rating) {
        this.rating = rating;
    }

    public String getStars() {
        return stars;
    }

    public void setStars(String stars) {
        this.stars = stars;
    }

    public Boolean getWatched() {
        return watched;
    }

    public void setWatched(Boolean watched) {
        this.watched = watched;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TitleDTO titleDTO = (TitleDTO) o;
        return id.equals(titleDTO.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}