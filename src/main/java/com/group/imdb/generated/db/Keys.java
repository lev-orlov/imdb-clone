/*
 * This file is generated by jOOQ.
 */
package com.group.imdb.generated.db;


import com.group.imdb.generated.db.tables.*;
import com.group.imdb.generated.db.tables.records.*;
import org.jooq.ForeignKey;
import org.jooq.UniqueKey;
import org.jooq.impl.Internal;

import javax.annotation.Generated;


/**
 * A class modelling foreign key relationships and constraints of tables of 
 * the <code>public</code> schema.
 */
@Generated(
        value = {
                "http://www.jooq.org",
                "jOOQ version:3.11.11"
        },
        comments = "This class is generated by jOOQ"
)
@SuppressWarnings({"all", "unchecked", "rawtypes"})
public class Keys {

    // -------------------------------------------------------------------------
    // IDENTITY definitions
    // -------------------------------------------------------------------------


    // -------------------------------------------------------------------------
    // UNIQUE and PRIMARY KEY definitions
    // -------------------------------------------------------------------------

    public static final UniqueKey<FlywaySchemaHistoryRecord> FLYWAY_SCHEMA_HISTORY_PK = UniqueKeys0.FLYWAY_SCHEMA_HISTORY_PK;
    public static final UniqueKey<NameBasicsRecord> NAME_BASICS_PK = UniqueKeys0.NAME_BASICS_PK;
    public static final UniqueKey<PasswordResetTokenRecord> PASSWORD_RESET_TOKEN_PKEY = UniqueKeys0.PASSWORD_RESET_TOKEN_PKEY;
    public static final UniqueKey<PasswordResetTokenRecord> UK_G0GUO4K8KRGPWUAGOS61OC06J = UniqueKeys0.UK_G0GUO4K8KRGPWUAGOS61OC06J;
    public static final UniqueKey<TitleRecord> TITLE_PKEY = UniqueKeys0.TITLE_PKEY;
    public static final UniqueKey<TitleBasicsRecord> TITLE_BASICS_PK = UniqueKeys0.TITLE_BASICS_PK;
    public static final UniqueKey<UserAccountRecord> USER_ACCOUNT_PKEY = UniqueKeys0.USER_ACCOUNT_PKEY;
    public static final UniqueKey<UserAccountRecord> UK_PLPGGM55I6UHYV404Q6PYU0UB = UniqueKeys0.UK_PLPGGM55I6UHYV404Q6PYU0UB;
    public static final UniqueKey<UserWatchlistRecord> USER_WATCHLIST_PKEY = UniqueKeys0.USER_WATCHLIST_PKEY;

    // -------------------------------------------------------------------------
    // FOREIGN KEY definitions
    // -------------------------------------------------------------------------

    public static final ForeignKey<PasswordResetTokenRecord, UserAccountRecord> PASSWORD_RESET_TOKEN__FKNS9Q9F0F318UAOXIQN6LKA9UX = ForeignKeys0.PASSWORD_RESET_TOKEN__FKNS9Q9F0F318UAOXIQN6LKA9UX;
    public static final ForeignKey<TitleRatingsRecord, TitleBasicsRecord> TITLE_RATINGS__TITLE_RATINGS_TITLE_BASICS_TCONST_FK = ForeignKeys0.TITLE_RATINGS__TITLE_RATINGS_TITLE_BASICS_TCONST_FK;
    public static final ForeignKey<UserRoleRecord, UserAccountRecord> USER_ROLE__FK7OJMV1M1VRXFL3KVT5BI5UR73 = ForeignKeys0.USER_ROLE__FK7OJMV1M1VRXFL3KVT5BI5UR73;
    public static final ForeignKey<UserWatchlistRecord, TitleRecord> USER_WATCHLIST__FK9VCLDKKC9X334ANSVBUUR8OG7 = ForeignKeys0.USER_WATCHLIST__FK9VCLDKKC9X334ANSVBUUR8OG7;
    public static final ForeignKey<UserWatchlistRecord, UserAccountRecord> USER_WATCHLIST__FKQNUWA9S0V864VFHGGF79AR3QY = ForeignKeys0.USER_WATCHLIST__FKQNUWA9S0V864VFHGGF79AR3QY;

    // -------------------------------------------------------------------------
    // [#1459] distribute members to avoid static initialisers > 64kb
    // -------------------------------------------------------------------------

    private static class UniqueKeys0 {
        public static final UniqueKey<FlywaySchemaHistoryRecord> FLYWAY_SCHEMA_HISTORY_PK = Internal.createUniqueKey(FlywaySchemaHistory.FLYWAY_SCHEMA_HISTORY, "flyway_schema_history_pk", FlywaySchemaHistory.FLYWAY_SCHEMA_HISTORY.INSTALLED_RANK);
        public static final UniqueKey<NameBasicsRecord> NAME_BASICS_PK = Internal.createUniqueKey(NameBasics.NAME_BASICS, "name_basics_pk", NameBasics.NAME_BASICS.NCONST);
        public static final UniqueKey<PasswordResetTokenRecord> PASSWORD_RESET_TOKEN_PKEY = Internal.createUniqueKey(PasswordResetToken.PASSWORD_RESET_TOKEN, "password_reset_token_pkey", PasswordResetToken.PASSWORD_RESET_TOKEN.ID);
        public static final UniqueKey<PasswordResetTokenRecord> UK_G0GUO4K8KRGPWUAGOS61OC06J = Internal.createUniqueKey(PasswordResetToken.PASSWORD_RESET_TOKEN, "uk_g0guo4k8krgpwuagos61oc06j", PasswordResetToken.PASSWORD_RESET_TOKEN.TOKEN);
        public static final UniqueKey<TitleRecord> TITLE_PKEY = Internal.createUniqueKey(Title.TITLE, "title_pkey", Title.TITLE.TCONST);
        public static final UniqueKey<TitleBasicsRecord> TITLE_BASICS_PK = Internal.createUniqueKey(TitleBasics.TITLE_BASICS, "title_basics_pk", TitleBasics.TITLE_BASICS.TCONST);
        public static final UniqueKey<UserAccountRecord> USER_ACCOUNT_PKEY = Internal.createUniqueKey(UserAccount.USER_ACCOUNT, "user_account_pkey", UserAccount.USER_ACCOUNT.ID);
        public static final UniqueKey<UserAccountRecord> UK_PLPGGM55I6UHYV404Q6PYU0UB = Internal.createUniqueKey(UserAccount.USER_ACCOUNT, "uk_plpggm55i6uhyv404q6pyu0ub", UserAccount.USER_ACCOUNT.LOGIN);
        public static final UniqueKey<UserWatchlistRecord> USER_WATCHLIST_PKEY = Internal.createUniqueKey(UserWatchlist.USER_WATCHLIST, "user_watchlist_pkey", UserWatchlist.USER_WATCHLIST.TITLE_ID, UserWatchlist.USER_WATCHLIST.USER_ID);
    }

    private static class ForeignKeys0 {
        public static final ForeignKey<PasswordResetTokenRecord, UserAccountRecord> PASSWORD_RESET_TOKEN__FKNS9Q9F0F318UAOXIQN6LKA9UX = Internal.createForeignKey(com.group.imdb.generated.db.Keys.USER_ACCOUNT_PKEY, PasswordResetToken.PASSWORD_RESET_TOKEN, "password_reset_token__fkns9q9f0f318uaoxiqn6lka9ux", PasswordResetToken.PASSWORD_RESET_TOKEN.USER_ID);
        public static final ForeignKey<TitleRatingsRecord, TitleBasicsRecord> TITLE_RATINGS__TITLE_RATINGS_TITLE_BASICS_TCONST_FK = Internal.createForeignKey(com.group.imdb.generated.db.Keys.TITLE_BASICS_PK, TitleRatings.TITLE_RATINGS, "title_ratings__title_ratings_title_basics_tconst_fk", TitleRatings.TITLE_RATINGS.TCONST);
        public static final ForeignKey<UserRoleRecord, UserAccountRecord> USER_ROLE__FK7OJMV1M1VRXFL3KVT5BI5UR73 = Internal.createForeignKey(com.group.imdb.generated.db.Keys.USER_ACCOUNT_PKEY, UserRole.USER_ROLE, "user_role__fk7ojmv1m1vrxfl3kvt5bi5ur73", UserRole.USER_ROLE.USER_ID);
        public static final ForeignKey<UserWatchlistRecord, TitleRecord> USER_WATCHLIST__FK9VCLDKKC9X334ANSVBUUR8OG7 = Internal.createForeignKey(com.group.imdb.generated.db.Keys.TITLE_PKEY, UserWatchlist.USER_WATCHLIST, "user_watchlist__fk9vcldkkc9x334ansvbuur8og7", UserWatchlist.USER_WATCHLIST.TITLE_ID);
        public static final ForeignKey<UserWatchlistRecord, UserAccountRecord> USER_WATCHLIST__FKQNUWA9S0V864VFHGGF79AR3QY = Internal.createForeignKey(com.group.imdb.generated.db.Keys.USER_ACCOUNT_PKEY, UserWatchlist.USER_WATCHLIST, "user_watchlist__fkqnuwa9s0v864vfhggf79ar3qy", UserWatchlist.USER_WATCHLIST.USER_ID);
    }
}
