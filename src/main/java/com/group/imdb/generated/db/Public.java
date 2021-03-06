/*
 * This file is generated by jOOQ.
 */
package com.group.imdb.generated.db;


import com.group.imdb.generated.db.tables.*;
import org.jooq.Catalog;
import org.jooq.Sequence;
import org.jooq.Table;
import org.jooq.impl.SchemaImpl;

import javax.annotation.Generated;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * This class is generated by jOOQ.
 */
@Generated(
        value = {
                "http://www.jooq.org",
                "jOOQ version:3.11.11"
        },
        comments = "This class is generated by jOOQ"
)
@SuppressWarnings({"all", "unchecked", "rawtypes"})
public class Public extends SchemaImpl {

    private static final long serialVersionUID = 1606194617;

    /**
     * The reference instance of <code>public</code>
     */
    public static final Public PUBLIC = new Public();

    /**
     * The table <code>public.flyway_schema_history</code>.
     */
    public final FlywaySchemaHistory FLYWAY_SCHEMA_HISTORY = com.group.imdb.generated.db.tables.FlywaySchemaHistory.FLYWAY_SCHEMA_HISTORY;

    /**
     * The table <code>public.name_basics</code>.
     */
    public final NameBasics NAME_BASICS = com.group.imdb.generated.db.tables.NameBasics.NAME_BASICS;

    /**
     * The table <code>public.password_reset_token</code>.
     */
    public final PasswordResetToken PASSWORD_RESET_TOKEN = com.group.imdb.generated.db.tables.PasswordResetToken.PASSWORD_RESET_TOKEN;

    /**
     * The table <code>public.title</code>.
     */
    public final Title TITLE = com.group.imdb.generated.db.tables.Title.TITLE;

    /**
     * The table <code>public.title_basics</code>.
     */
    public final TitleBasics TITLE_BASICS = com.group.imdb.generated.db.tables.TitleBasics.TITLE_BASICS;

    /**
     * The table <code>public.title_principals</code>.
     */
    public final TitlePrincipals TITLE_PRINCIPALS = com.group.imdb.generated.db.tables.TitlePrincipals.TITLE_PRINCIPALS;

    /**
     * The table <code>public.title_ratings</code>.
     */
    public final TitleRatings TITLE_RATINGS = com.group.imdb.generated.db.tables.TitleRatings.TITLE_RATINGS;

    /**
     * The table <code>public.user_account</code>.
     */
    public final UserAccount USER_ACCOUNT = com.group.imdb.generated.db.tables.UserAccount.USER_ACCOUNT;

    /**
     * The table <code>public.user_role</code>.
     */
    public final UserRole USER_ROLE = com.group.imdb.generated.db.tables.UserRole.USER_ROLE;

    /**
     * The table <code>public.user_watchlist</code>.
     */
    public final UserWatchlist USER_WATCHLIST = com.group.imdb.generated.db.tables.UserWatchlist.USER_WATCHLIST;

    /**
     * No further instances allowed
     */
    private Public() {
        super("public", null);
    }


    /**
     * {@inheritDoc}
     */
    @Override
    public Catalog getCatalog() {
        return DefaultCatalog.DEFAULT_CATALOG;
    }

    @Override
    public final List<Sequence<?>> getSequences() {
        List result = new ArrayList();
        result.addAll(getSequences0());
        return result;
    }

    private final List<Sequence<?>> getSequences0() {
        return Arrays.<Sequence<?>>asList(
                Sequences.TOKEN_SEQUENCE,
                Sequences.USER_SEQUENCE);
    }

    @Override
    public final List<Table<?>> getTables() {
        List result = new ArrayList();
        result.addAll(getTables0());
        return result;
    }

    private final List<Table<?>> getTables0() {
        return Arrays.<Table<?>>asList(
                FlywaySchemaHistory.FLYWAY_SCHEMA_HISTORY,
                NameBasics.NAME_BASICS,
                PasswordResetToken.PASSWORD_RESET_TOKEN,
                Title.TITLE,
                TitleBasics.TITLE_BASICS,
                TitlePrincipals.TITLE_PRINCIPALS,
                TitleRatings.TITLE_RATINGS,
                UserAccount.USER_ACCOUNT,
                UserRole.USER_ROLE,
                UserWatchlist.USER_WATCHLIST);
    }
}
