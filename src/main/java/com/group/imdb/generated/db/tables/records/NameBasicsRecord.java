/*
 * This file is generated by jOOQ.
 */
package com.group.imdb.generated.db.tables.records;


import com.group.imdb.generated.db.tables.NameBasics;
import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record6;
import org.jooq.Row6;
import org.jooq.impl.UpdatableRecordImpl;

import javax.annotation.Generated;


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
public class NameBasicsRecord extends UpdatableRecordImpl<NameBasicsRecord> implements Record6<String, String, Integer, Integer, String, String> {

    private static final long serialVersionUID = 1777343953;

    /**
     * Setter for <code>public.name_basics.nconst</code>.
     */
    public void setNconst(String value) {
        set(0, value);
    }

    /**
     * Getter for <code>public.name_basics.nconst</code>.
     */
    public String getNconst() {
        return (String) get(0);
    }

    /**
     * Setter for <code>public.name_basics.primary_name</code>.
     */
    public void setPrimaryName(String value) {
        set(1, value);
    }

    /**
     * Getter for <code>public.name_basics.primary_name</code>.
     */
    public String getPrimaryName() {
        return (String) get(1);
    }

    /**
     * Setter for <code>public.name_basics.birth_year</code>.
     */
    public void setBirthYear(Integer value) {
        set(2, value);
    }

    /**
     * Getter for <code>public.name_basics.birth_year</code>.
     */
    public Integer getBirthYear() {
        return (Integer) get(2);
    }

    /**
     * Setter for <code>public.name_basics.death_year</code>.
     */
    public void setDeathYear(Integer value) {
        set(3, value);
    }

    /**
     * Getter for <code>public.name_basics.death_year</code>.
     */
    public Integer getDeathYear() {
        return (Integer) get(3);
    }

    /**
     * Setter for <code>public.name_basics.primary_profession</code>.
     */
    public void setPrimaryProfession(String value) {
        set(4, value);
    }

    /**
     * Getter for <code>public.name_basics.primary_profession</code>.
     */
    public String getPrimaryProfession() {
        return (String) get(4);
    }

    /**
     * Setter for <code>public.name_basics.known_for_titles</code>.
     */
    public void setKnownForTitles(String value) {
        set(5, value);
    }

    /**
     * Getter for <code>public.name_basics.known_for_titles</code>.
     */
    public String getKnownForTitles() {
        return (String) get(5);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Record1<String> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record6 type implementation
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Row6<String, String, Integer, Integer, String, String> fieldsRow() {
        return (Row6) super.fieldsRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Row6<String, String, Integer, Integer, String, String> valuesRow() {
        return (Row6) super.valuesRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field1() {
        return NameBasics.NAME_BASICS.NCONST;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field2() {
        return NameBasics.NAME_BASICS.PRIMARY_NAME;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field3() {
        return NameBasics.NAME_BASICS.BIRTH_YEAR;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field4() {
        return NameBasics.NAME_BASICS.DEATH_YEAR;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field5() {
        return NameBasics.NAME_BASICS.PRIMARY_PROFESSION;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field6() {
        return NameBasics.NAME_BASICS.KNOWN_FOR_TITLES;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component1() {
        return getNconst();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component2() {
        return getPrimaryName();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer component3() {
        return getBirthYear();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer component4() {
        return getDeathYear();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component5() {
        return getPrimaryProfession();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component6() {
        return getKnownForTitles();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value1() {
        return getNconst();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value2() {
        return getPrimaryName();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value3() {
        return getBirthYear();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value4() {
        return getDeathYear();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value5() {
        return getPrimaryProfession();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value6() {
        return getKnownForTitles();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public NameBasicsRecord value1(String value) {
        setNconst(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public NameBasicsRecord value2(String value) {
        setPrimaryName(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public NameBasicsRecord value3(Integer value) {
        setBirthYear(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public NameBasicsRecord value4(Integer value) {
        setDeathYear(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public NameBasicsRecord value5(String value) {
        setPrimaryProfession(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public NameBasicsRecord value6(String value) {
        setKnownForTitles(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public NameBasicsRecord values(String value1, String value2, Integer value3, Integer value4, String value5, String value6) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        value5(value5);
        value6(value6);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached NameBasicsRecord
     */
    public NameBasicsRecord() {
        super(NameBasics.NAME_BASICS);
    }

    /**
     * Create a detached, initialised NameBasicsRecord
     */
    public NameBasicsRecord(String nconst, String primaryName, Integer birthYear, Integer deathYear, String primaryProfession, String knownForTitles) {
        super(NameBasics.NAME_BASICS);

        set(0, nconst);
        set(1, primaryName);
        set(2, birthYear);
        set(3, deathYear);
        set(4, primaryProfession);
        set(5, knownForTitles);
    }
}
