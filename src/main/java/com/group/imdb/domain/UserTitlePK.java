package com.group.imdb.domain;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;


@Embeddable
public class UserTitlePK implements Serializable {
    @Column(name = "user_id")
    private Long userId;
    @Column(name = "title_id")
    private String titleId;

    public UserTitlePK() {
    }

    public UserTitlePK(Long userId, String titleId) {
        this.userId = userId;
        this.titleId = titleId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getTitleId() {
        return titleId;
    }

    public void setTitleId(String titleId) {
        this.titleId = titleId;
    }
}
