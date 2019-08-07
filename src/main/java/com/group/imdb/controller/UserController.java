package com.group.imdb.controller;

import com.group.imdb.domain.Title;
import com.group.imdb.domain.User;
import com.group.imdb.repository.TitleRepository;
import com.group.imdb.service.MailService;
import com.group.imdb.service.UserService;
import com.group.imdb.service.dto.TitleDTO;
import com.group.imdb.service.dto.UserDTO;
import com.group.imdb.service.mapper.UserMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.UUID;

@RestController
@RequestMapping("/user")
public class UserController {
    private final UserService userService;
    private final MailService mailService;
    private final UserMapper userMapper;
    private final TitleRepository titleRepository;

    public UserController(UserService userService, MailService mailService, UserMapper userMapper, TitleRepository titleRepository) {
        this.userService = userService;
        this.mailService = mailService;
        this.userMapper = userMapper;
        this.titleRepository = titleRepository;
    }

    @GetMapping
    public ResponseEntity<UserDTO> getAuthenticatedUser(@AuthenticationPrincipal UserDetails userDetails) {
        if (userDetails == null) {
            return ResponseEntity.ok(null);
        }
        User user = userService.findOneWithAuthoritiesByLogin(userDetails.getUsername()).get();
        UserDTO userDTO = userMapper.userToUserDTO(user);

        return ResponseEntity.ok(userDTO);
    }

    @PostMapping("/registration")
    public ResponseEntity<UserDTO> registerUser(@RequestBody @Valid UserDTO userDTO, HttpServletRequest httpServletRequest) {
        UserDTO u = userService.registerAndLoginUser(userDTO, httpServletRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(u);
    }

    @PutMapping("/resetpassword")
    public void resetPassword(@RequestParam String token, @RequestParam String password) {
        userService.resetPassword(token, password);
    }

    @PostMapping("/resetpassword")
    public void resetPasswordRequest(@RequestParam String email) {
        User user = userService.findByLogin(email)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, email + " email not found"));
        String token = UUID.randomUUID().toString();
        userService.createPasswordResetTokenForUser(user, token);
        mailService.sendEmail(user.getLogin(), "Password Reset", token);
    }

    @PostMapping("/watchlist")
    public ResponseEntity<TitleDTO> addToWatchlist(@AuthenticationPrincipal UserDetails userDetails,
                                         @RequestBody Title title) {
        if (userDetails == null) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED);
        }
        User user = userService.findByLogin(userDetails.getUsername()).get();
        userService.addToWatchlist(user, title);
        TitleDTO titleDTO = titleRepository.getTitleById(title.getId());
        return ResponseEntity.ok(titleDTO);
    }

    @PutMapping("/watchlist")
    public void markAsWatched(@AuthenticationPrincipal UserDetails userDetails,
                              @RequestBody Title title) {
        if (userDetails == null) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED);
        }
        User user = userService.findByLogin(userDetails.getUsername()).get();
        userService.markUnmarkAsWatched(user, title);
    }

    @DeleteMapping("/watchlist")
    public void deleteFromWatchlist(@AuthenticationPrincipal UserDetails userDetails,
                                    @RequestBody Title title) {
        if (userDetails == null) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED);
        }
        User user = userService.findByLogin(userDetails.getUsername()).get();
        userService.removeFromWatchlist(user, title);
    }
}
