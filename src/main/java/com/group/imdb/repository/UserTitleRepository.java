package com.group.imdb.repository;

import com.group.imdb.domain.UserTitle;
import com.group.imdb.domain.UserTitlePK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserTitleRepository extends JpaRepository<UserTitle, UserTitlePK> {

}
