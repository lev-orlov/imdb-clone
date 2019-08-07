/*
 * This file is generated by jOOQ.
 */
package com.group.imdb.generated.db.tables;


import com.group.imdb.generated.db.Keys;
import com.group.imdb.generated.db.Public;
import com.group.imdb.generated.db.tables.records.UserRoleRecord;
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
public class UserRole extends TableImpl<UserRoleRecord> {

    private static final long serialVersionUID = 2144599015;

    /**
     * The reference instance of <code>public.user_role</code>
     */
    public static final UserRole USER_ROLE = new UserRole();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<UserRoleRecord> getRecordType() {
        return UserRoleRecord.class;
    }

    /**
     * The column <code>public.user_role.user_id</code>.
     */
    public final TableField<UserRoleRecord, Long> USER_ID = createField("user_id", org.jooq.impl.SQLDataType.BIGINT.nullable(false), this, "");

    /**
     * The column <code>public.user_role.authorities</code>.
     */
    public final TableField<UserRoleRecord, String> AUTHORITIES = createField("authorities", org.jooq.impl.SQLDataType.VARCHAR(255), this, "");

    /**
     * Create a <code>public.user_role</code> table reference
     */
    public UserRole() {
        this(DSL.name("user_role"), null);
    }

    /**
     * Create an aliased <code>public.user_role</code> table reference
     */
    public UserRole(String alias) {
        this(DSL.name(alias), USER_ROLE);
    }

    /**
     * Create an aliased <code>public.user_role</code> table reference
     */
    public UserRole(Name alias) {
        this(alias, USER_ROLE);
    }

    private UserRole(Name alias, Table<UserRoleRecord> aliased) {
        this(alias, aliased, null);
    }

    private UserRole(Name alias, Table<UserRoleRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""));
    }

    public <O extends Record> UserRole(Table<O> child, ForeignKey<O, UserRoleRecord> key) {
        super(child, key, USER_ROLE);
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
    public List<ForeignKey<UserRoleRecord, ?>> getReferences() {
        return Arrays.<ForeignKey<UserRoleRecord, ?>>asList(Keys.USER_ROLE__FK7OJMV1M1VRXFL3KVT5BI5UR73);
    }

    public UserAccount userAccount() {
        return new UserAccount(this, Keys.USER_ROLE__FK7OJMV1M1VRXFL3KVT5BI5UR73);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserRole as(String alias) {
        return new UserRole(DSL.name(alias), this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserRole as(Name alias) {
        return new UserRole(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public UserRole rename(String name) {
        return new UserRole(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public UserRole rename(Name name) {
        return new UserRole(name, null);
    }
}
