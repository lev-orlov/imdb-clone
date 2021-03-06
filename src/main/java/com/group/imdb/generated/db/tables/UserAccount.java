/*
 * This file is generated by jOOQ.
 */
package com.group.imdb.generated.db.tables;


import com.group.imdb.generated.db.Indexes;
import com.group.imdb.generated.db.Keys;
import com.group.imdb.generated.db.Public;
import com.group.imdb.generated.db.tables.records.UserAccountRecord;
import org.jooq.*;
import org.jooq.impl.DSL;
import org.jooq.impl.TableImpl;

import javax.annotation.Generated;
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
public class UserAccount extends TableImpl<UserAccountRecord> {

    private static final long serialVersionUID = 1864211806;

    /**
     * The reference instance of <code>public.user_account</code>
     */
    public static final UserAccount USER_ACCOUNT = new UserAccount();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<UserAccountRecord> getRecordType() {
        return UserAccountRecord.class;
    }

    /**
     * The column <code>public.user_account.id</code>.
     */
    public final TableField<UserAccountRecord, Long> ID = createField("id", org.jooq.impl.SQLDataType.BIGINT.nullable(false), this, "");

    /**
     * The column <code>public.user_account.login</code>.
     */
    public final TableField<UserAccountRecord, String> LOGIN = createField("login", org.jooq.impl.SQLDataType.VARCHAR(254).nullable(false), this, "");

    /**
     * The column <code>public.user_account.password</code>.
     */
    public final TableField<UserAccountRecord, String> PASSWORD = createField("password", org.jooq.impl.SQLDataType.VARCHAR(60).nullable(false), this, "");

    /**
     * Create a <code>public.user_account</code> table reference
     */
    public UserAccount() {
        this(DSL.name("user_account"), null);
    }

    /**
     * Create an aliased <code>public.user_account</code> table reference
     */
    public UserAccount(String alias) {
        this(DSL.name(alias), USER_ACCOUNT);
    }

    /**
     * Create an aliased <code>public.user_account</code> table reference
     */
    public UserAccount(Name alias) {
        this(alias, USER_ACCOUNT);
    }

    private UserAccount(Name alias, Table<UserAccountRecord> aliased) {
        this(alias, aliased, null);
    }

    private UserAccount(Name alias, Table<UserAccountRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""));
    }

    public <O extends Record> UserAccount(Table<O> child, ForeignKey<O, UserAccountRecord> key) {
        super(child, key, USER_ACCOUNT);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Schema getSchema() {
        return Public.PUBLIC;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Index> getIndexes() {
        return Arrays.<Index>asList(Indexes.UK_PLPGGM55I6UHYV404Q6PYU0UB, Indexes.USER_ACCOUNT_PKEY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UniqueKey<UserAccountRecord> getPrimaryKey() {
        return Keys.USER_ACCOUNT_PKEY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<UniqueKey<UserAccountRecord>> getKeys() {
        return Arrays.<UniqueKey<UserAccountRecord>>asList(Keys.USER_ACCOUNT_PKEY, Keys.UK_PLPGGM55I6UHYV404Q6PYU0UB);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserAccount as(String alias) {
        return new UserAccount(DSL.name(alias), this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserAccount as(Name alias) {
        return new UserAccount(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public UserAccount rename(String name) {
        return new UserAccount(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public UserAccount rename(Name name) {
        return new UserAccount(name, null);
    }
}
