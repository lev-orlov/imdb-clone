package com.group.imdb.domain;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "user_watchlist")
public class UserTitle implements Serializable {

    @EmbeddedId
    private UserTitlePK id;

    @Column(name = "watched")
    private boolean watched;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    @MapsId("userId")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "title_id")
    @MapsId("titleId")
    private Title title;

    public UserTitle() {
    }

    public UserTitle(User user, Title title) {
        this.watched = false;
        this.user = user;
        this.title = title;
        this.id = new UserTitlePK(user.getId(), title.getId());
    }

    public UserTitlePK getId() {
        return id;
    }

    public void setId(UserTitlePK id) {
        this.id = id;
    }

    public boolean isWatched() {
        return watched;
    }

    public void setWatched(boolean watched) {
        this.watched = watched;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Title getTitle() {
        return title;
    }

    public void setTitle(Title title) {
        this.title = title;
    }
}
