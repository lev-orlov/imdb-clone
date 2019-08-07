package com.group.imdb.service.mapper;

import com.group.imdb.domain.Authority;
import com.group.imdb.domain.User;
import com.group.imdb.repository.TitleRepository;
import com.group.imdb.service.dto.UserDTO;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class UserMapper {

    private final TitleRepository titleRepository;

    public UserMapper(TitleRepository titleRepository) {
        this.titleRepository = titleRepository;
    }

    public UserDTO userToUserDTO(User user) {
        UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setLogin(user.getLogin());
        userDTO.setAuthorities(user.getAuthorities());
        userDTO.setWatchlist(titleRepository.getUserWatchlistTitles(user.getId()));

        return userDTO;
    }


    private Set<Authority> authoritiesFromStrings(Set<String> authoritiesAsString) {
        Set<Authority> authorities = new HashSet<>();

        if (authoritiesAsString != null) {
            authorities = authoritiesAsString.stream().map(Authority::valueOf).collect(Collectors.toSet());
        }

        return authorities;
    }
}
