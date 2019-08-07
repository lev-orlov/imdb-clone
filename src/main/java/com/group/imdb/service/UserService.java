package com.group.imdb.service;

import com.group.imdb.domain.*;
import com.group.imdb.repository.PasswordResetTokenRepository;
import com.group.imdb.repository.UserRepository;
import com.group.imdb.repository.UserTitleRepository;
import com.group.imdb.service.dto.UserDTO;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Optional;

@Service
@Transactional
public class UserService {

    private final UserRepository userRepo;
    private final UserTitleRepository userTitleRepo;
    private final PasswordEncoder passwordEncoder;
    private final PasswordResetTokenRepository pwResetTokenRepo;

    public UserService(UserRepository userRepo, UserTitleRepository userTitleRepo,
                       PasswordEncoder passwordEncoder, PasswordResetTokenRepository pwResetTokenRepo) {
        this.userRepo = userRepo;
        this.userTitleRepo = userTitleRepo;
        this.passwordEncoder = passwordEncoder;
        this.pwResetTokenRepo = pwResetTokenRepo;
    }

    public void markUnmarkAsWatched(User user, Title title) {
        UserTitle ut = new UserTitle(user, title);
        UserTitle utFromDb = userTitleRepo.findById(ut.getId()).orElse(ut);
        utFromDb.setWatched(!utFromDb.isWatched());
    }

    public void addToWatchlist(User user, Title title) {
        UserTitle ut = new UserTitle(user, title);
        ut.setWatched(false);
        userTitleRepo.save(ut);
    }

    public void removeFromWatchlist(User user, Title title) {
        UserTitle ut = new UserTitle(user, title);
        userTitleRepo.delete(ut);
    }

    public void createPasswordResetTokenForUser(User user, String token) {
        PasswordResetToken myToken = new PasswordResetToken();
        myToken.setUser(user);
        myToken.setTokenExpiryDate(token);
        pwResetTokenRepo.save(myToken);
    }

    public void resetPassword(String token, String password) {
        PasswordResetToken resetToken = pwResetTokenRepo.findByToken(token);
        if (resetToken == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Could not find password reset token.");
        } else if (resetToken.isExpired()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Token has expired, please request a new password reset.");
        }
        User user = resetToken.getUser();
        String newPassword = passwordEncoder.encode(password);
        userRepo.updatePassword(newPassword, user.getId());
        pwResetTokenRepo.delete(resetToken);
    }

    public UserDTO registerAndLoginUser(UserDTO userDTO, HttpServletRequest httpServletRequest) {

        String password = userDTO.getPassword();
        String login = userDTO.getLogin();

        if (isEmailExist(login.toLowerCase())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, login + " email already exists.");
        }
        User newUser = new User();
        newUser.setLogin(login);
        newUser.setPassword(passwordEncoder.encode(password));
        newUser.setAuthorities(Collections.singleton(Authority.USER));

        save(newUser);

        userDTO.setAuthorities(newUser.getAuthorities());
        userDTO.setWatchlist(new ArrayList<>());

        loginUser(httpServletRequest, password, login);

        return userDTO;
    }

    private boolean isEmailExist(String email) {
        return userRepo.findByLogin(email).isPresent();
    }

    private void loginUser(HttpServletRequest httpServletRequest, String password, String email) {
        try {
            httpServletRequest.login(email, password);
        } catch (ServletException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
    }

    public void save(User newUser) {
        userRepo.save(newUser);
    }

    public Optional<User> findByLogin(String login) {
        return userRepo.findByLogin(login);
    }

    public Optional<User> findOneWithAuthoritiesByLogin(String login) {
        return userRepo.findOneWithAuthoritiesByLogin(login);
    }
}
