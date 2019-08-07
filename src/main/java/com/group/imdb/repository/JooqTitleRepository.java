package com.group.imdb.repository;

import com.group.imdb.generated.db.tables.*;
import com.group.imdb.generated.db.tables.records.TitleBasicsRecord;
import com.group.imdb.service.dto.TitleDTO;
import org.jooq.*;
import org.jooq.impl.DSL;
import org.jooq.tools.StringUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static com.group.imdb.generated.db.Tables.*;
import static org.jooq.impl.DSL.*;

@Repository
public class JooqTitleRepository implements TitleRepository {

    private final TitleBasics TB = TITLE_BASICS.as("TB");
    private final TitlePrincipals TP = TITLE_PRINCIPALS.as("TP");
    private final NameBasics NB = NAME_BASICS.as("NB");
    private final TitleRatings TR = TITLE_RATINGS.as("TR");
    private final UserWatchlist UW = USER_WATCHLIST.as("UW");

    private final SelectField<?> STARS = listAgg(
            when(TP.CATEGORY.in("actor", "actress"), NB.PRIMARY_NAME), ", ")
            .withinGroupOrderBy(TP.ORDERING).as("STARS");

    private final SelectField<?>[] titleDtoFieldsForSearch = {
            TB.TCONST.as("id"),
            TB.PRIMARY_TITLE.as("title"),
            TB.TITLE_TYPE.as("type"),
            TB.START_YEAR.as("startYear"),
            TB.GENRES.as("genres"),
            TR.AVERAGE_RATING.as("rating"),
            STARS};

    private final GroupField[] groupFieldsForSearch = {
            TB.TCONST,
            TB.PRIMARY_TITLE,
            TB.TITLE_TYPE,
            TB.START_YEAR,
            TB.GENRES,
            TR.AVERAGE_RATING,
            TR.NUM_VOTES};

    private final SelectField<?>[] titleDtoFieldsForUserWatchlist = {
            TB.TCONST.as("id"),
            TB.PRIMARY_TITLE.as("title"),
            TB.TITLE_TYPE.as("type"),
            TB.START_YEAR.as("startYear"),
            TB.GENRES.as("genres"),
            TR.AVERAGE_RATING.as("rating"),
            STARS,
            UW.WATCHED.as("watched")};

    private final GroupField[] groupFieldsForUserWatchlist = {
            TB.TCONST,
            TB.PRIMARY_TITLE,
            TB.TITLE_TYPE,
            TB.START_YEAR,
            TB.GENRES,
            TR.AVERAGE_RATING,
            TR.NUM_VOTES,
            UW.WATCHED};


    private final DSLContext dslContext;

    public JooqTitleRepository(DSLContext dslContext) {
        this.dslContext = dslContext;
    }

    @Transactional(readOnly = true)
    public Page<TitleDTO> findCollaborations(@Param("name1") String name1,
                                             @Param("name2") String name2,
                                             Pageable pageable) {
        List<TitleDTO> list = dslContext
                .with("filter", "tconst", "RN")
                .as(select(TP.TCONST, rowNumber().over((partitionBy(TP.TCONST))).as("RN"))
                        .from(TP)
                        .where(TP.NCONST.in(select(NB.NCONST)
                                .from(NB)
                                .where(NB.PRIMARY_NAME.in(name1, name2)))))
                .with("movies", "tconst")
                .as(select(field(name("filter", "tconst")))
                        .from(table(name("filter")))
                        .where(field(name("filter", "RN")).eq(2)))
                .select(titleDtoFieldsForSearch)
                .from(TB)
                .innerJoin(table(name("movies")))
                .on(field(name("movies", "tconst")).eq(TB.TCONST))
                .leftJoin(TR).on(TB.TCONST.eq(TR.TCONST))
                .leftJoin(TP).on(TP.TCONST.eq(TB.TCONST))
                .leftJoin(NB).on(TP.NCONST.eq(NB.NCONST))
                .groupBy(groupFieldsForSearch)
                .orderBy(TR.NUM_VOTES.desc().nullsLast())
                .limit(pageable.getPageSize())
                .offset((int) pageable.getOffset())
                .fetch().into(TitleDTO.class);
        return new PageImpl<>(list, pageable, 0);
    }

    @Transactional(readOnly = true)
    public Page<TitleDTO> advancedSearch(@Param("title") String title,
                                         @Param("releaseDateFrom") Integer releaseDateFrom,
                                         @Param("releaseDateTo") Integer releaseDateTo,
                                         @Param("userRatingFrom") Double userRatingFrom,
                                         @Param("userRatingTo") Double userRatingTo,
                                         @Param("numOfVotesFrom") Integer numOfVotesFrom,
                                         @Param("numOfVotesTo") Integer numOfVotesTo,
                                         @Param("genres") String[] genres,
                                         @Param("titleType") String[] titleType,
                                         Pageable pageable) {
        Condition titleCondition = trueCondition();
        Condition ratingCondition = trueCondition();
        if (!StringUtils.isBlank(title)) {
            String wildcardTitle = splitWithWildcard(title);
            titleCondition = titleCondition.and((TB.PRIMARY_TITLE).likeIgnoreCase(wildcardTitle));
        }
        if (releaseDateFrom != null) {
            titleCondition = titleCondition.and(TB.START_YEAR.ge(releaseDateFrom));
        }
        if (releaseDateTo != null) {
            titleCondition = titleCondition.and(TB.START_YEAR.le(releaseDateTo));
        }
        if (titleType != null) {
            titleCondition = titleCondition.and(TB.TITLE_TYPE.in(titleType));
        }
        if (genres != null) {
            titleCondition = titleCondition.and(contains(TB.GENRES, genres));
        }
        if (userRatingFrom != null) {
            ratingCondition = ratingCondition.and(TR.AVERAGE_RATING.ge(userRatingFrom));
        }
        if (userRatingTo != null) {
            ratingCondition = ratingCondition.and(TR.AVERAGE_RATING.le(userRatingTo));
        }
        if (numOfVotesFrom != null) {
            ratingCondition = ratingCondition.and(TR.NUM_VOTES.ge(numOfVotesFrom));
        }
        if (numOfVotesTo != null) {
            ratingCondition = ratingCondition.and(TR.NUM_VOTES.le(numOfVotesTo));
        }

        List<TitleDTO> list = dslContext
                .with("ratingFilter", "tconst")
                .as(select(TR.TCONST)
                        .from(TR)
                        .where(ratingCondition)
                        .orderBy(TR.NUM_VOTES.desc(), TR.AVERAGE_RATING.desc()))
                .with("titleFilter", "tconst")
                .as(select(TB.TCONST)
                        .from(TB)
                        .innerJoin(table(name("ratingFilter")))
                        .on(field(name("ratingFilter", "tconst")).eq(TB.TCONST))
                        .where(titleCondition)
                        .limit(pageable.getPageSize())
                        .offset((int) pageable.getOffset()))
                .select(titleDtoFieldsForSearch)
                .from(TB)
                .innerJoin(table(name("titleFilter")))
                .on(field(name("titleFilter", "tconst")).eq(TB.TCONST))
                .leftJoin(TR).on(TB.TCONST.eq(TR.TCONST))
                .leftJoin(TP).on(TP.TCONST.eq(TB.TCONST))
                .leftJoin(NB).on(TP.NCONST.eq(NB.NCONST))
                .groupBy(groupFieldsForSearch)
                .orderBy(TR.NUM_VOTES.desc())
                .fetch().into(TitleDTO.class);
        return new PageImpl<>(list, pageable, 0);
    }

    private static Condition contains(
            TableField<TitleBasicsRecord, String[]> left,
            String[] right
    ) {
        return DSL.condition("{0} @> {1}::text[]", left, DSL.val(right, left.getDataType()));
    }

    private String splitWithWildcard(String name) {
        String[] split = name.split("\\s");
        StringBuilder sb = new StringBuilder("%");
        for (String s : split) {
            sb.append(s).append("%");
        }
        return sb.toString();
    }

    public List<String> autocompleteNameSuggestions(String name) {
        String wildcardName = splitWithWildcard(name);
        return dslContext.select(NB.PRIMARY_NAME)
                .from(NB)
                .where(NB.PRIMARY_NAME.likeIgnoreCase(wildcardName))
                .limit(6)
                .fetch().into(String.class);
    }

    public List<TitleDTO> getUserWatchlistTitles(Long userId) {
        return dslContext
                .select(titleDtoFieldsForUserWatchlist)
                .from(TB)
                .leftJoin(TR).on(TB.TCONST.eq(TR.TCONST))
                .leftJoin(TP).on(TP.TCONST.eq(TB.TCONST))
                .leftJoin(NB).on(TP.NCONST.eq(NB.NCONST))
                .leftJoin(UW).on(UW.TITLE_ID.eq(TB.TCONST))
                .where(UW.USER_ID.eq(userId))
                .groupBy(groupFieldsForUserWatchlist)
                .fetch().into(TitleDTO.class);
    }

    public TitleDTO getTitleById(String id) {
        return dslContext.select(titleDtoFieldsForSearch)
                .from(TB)
                .leftJoin(TR).on(TB.TCONST.eq(TR.TCONST))
                .leftJoin(TP).on(TP.TCONST.eq(TB.TCONST))
                .leftJoin(NB).on(TP.NCONST.eq(NB.NCONST))
                .where(TB.TCONST.eq(id))
                .groupBy(groupFieldsForSearch).fetchOne().into(TitleDTO.class);
    }


}
