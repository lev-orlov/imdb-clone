package com.group.imdb.service.dto;

import com.group.imdb.domain.Authority;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.List;
import java.util.Set;


public class UserDTO {

    private Long id;

    @Email
    @NotBlank
    @Size(min = 7, max = 254)
    private String login;

    @Size(min = 4, max = 100)
    private String password;

    private List<TitleDTO> watchlist;
    private Set<Authority> authorities;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<TitleDTO> getWatchlist() {
        return watchlist;
    }

    public void setWatchlist(List<TitleDTO> watchlist) {
        this.watchlist = watchlist;
    }

    public Set<Authority> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(Set<Authority> authorities) {
        this.authorities = authorities;
    }

    @Override
    public String toString() {
        return "UserDTO{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", watchlist=" + watchlist +
                ", authorities=" + authorities +
                '}';
    }
}
