/*
 * This file is generated by jOOQ.
 */
package com.group.imdb.generated.db.tables.records;


import com.group.imdb.generated.db.tables.TitleBasics;
import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record9;
import org.jooq.Row9;
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
public class TitleBasicsRecord extends UpdatableRecordImpl<TitleBasicsRecord> implements Record9<String, String, String, String, Boolean, Integer, Integer, Integer, String[]> {

    private static final long serialVersionUID = -1377941297;

    /**
     * Setter for <code>public.title_basics.tconst</code>.
     */
    public void setTconst(String value) {
        set(0, value);
    }

    /**
     * Getter for <code>public.title_basics.tconst</code>.
     */
    public String getTconst() {
        return (String) get(0);
    }

    /**
     * Setter for <code>public.title_basics.title_type</code>.
     */
    public void setTitleType(String value) {
        set(1, value);
    }

    /**
     * Getter for <code>public.title_basics.title_type</code>.
     */
    public String getTitleType() {
        return (String) get(1);
    }

    /**
     * Setter for <code>public.title_basics.primary_title</code>.
     */
    public void setPrimaryTitle(String value) {
        set(2, value);
    }

    /**
     * Getter for <code>public.title_basics.primary_title</code>.
     */
    public String getPrimaryTitle() {
        return (String) get(2);
    }

    /**
     * Setter for <code>public.title_basics.original_title</code>.
     */
    public void setOriginalTitle(String value) {
        set(3, value);
    }

    /**
     * Getter for <code>public.title_basics.original_title</code>.
     */
    public String getOriginalTitle() {
        return (String) get(3);
    }

    /**
     * Setter for <code>public.title_basics.is_adult</code>.
     */
    public void setIsAdult(Boolean value) {
        set(4, value);
    }

    /**
     * Getter for <code>public.title_basics.is_adult</code>.
     */
    public Boolean getIsAdult() {
        return (Boolean) get(4);
    }

    /**
     * Setter for <code>public.title_basics.start_year</code>.
     */
    public void setStartYear(Integer value) {
        set(5, value);
    }

    /**
     * Getter for <code>public.title_basics.start_year</code>.
     */
    public Integer getStartYear() {
        return (Integer) get(5);
    }

    /**
     * Setter for <code>public.title_basics.end_year</code>.
     */
    public void setEndYear(Integer value) {
        set(6, value);
    }

    /**
     * Getter for <code>public.title_basics.end_year</code>.
     */
    public Integer getEndYear() {
        return (Integer) get(6);
    }

    /**
     * Setter for <code>public.title_basics.runtime_minutes</code>.
     */
    public void setRuntimeMinutes(Integer value) {
        set(7, value);
    }

    /**
     * Getter for <code>public.title_basics.runtime_minutes</code>.
     */
    public Integer getRuntimeMinutes() {
        return (Integer) get(7);
    }

    /**
     * Setter for <code>public.title_basics.genres</code>.
     */
    public void setGenres(String... value) {
        set(8, value);
    }

    /**
     * Getter for <code>public.title_basics.genres</code>.
     */
    public String[] getGenres() {
        return (String[]) get(8);
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
    // Record9 type implementation
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Row9<String, String, String, String, Boolean, Integer, Integer, Integer, String[]> fieldsRow() {
        return (Row9) super.fieldsRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Row9<String, String, String, String, Boolean, Integer, Integer, Integer, String[]> valuesRow() {
        return (Row9) super.valuesRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field1() {
        return TitleBasics.TITLE_BASICS.TCONST;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field2() {
        return TitleBasics.TITLE_BASICS.TITLE_TYPE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field3() {
        return TitleBasics.TITLE_BASICS.PRIMARY_TITLE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field4() {
        return TitleBasics.TITLE_BASICS.ORIGINAL_TITLE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Boolean> field5() {
        return TitleBasics.TITLE_BASICS.IS_ADULT;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field6() {
        return TitleBasics.TITLE_BASICS.START_YEAR;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field7() {
        return TitleBasics.TITLE_BASICS.END_YEAR;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field8() {
        return TitleBasics.TITLE_BASICS.RUNTIME_MINUTES;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String[]> field9() {
        return TitleBasics.TITLE_BASICS.GENRES;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component1() {
        return getTconst();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component2() {
        return getTitleType();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component3() {
        return getPrimaryTitle();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component4() {
        return getOriginalTitle();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Boolean component5() {
        return getIsAdult();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer component6() {
        return getStartYear();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer component7() {
        return getEndYear();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer component8() {
        return getRuntimeMinutes();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String[] component9() {
        return getGenres();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value1() {
        return getTconst();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value2() {
        return getTitleType();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value3() {
        return getPrimaryTitle();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value4() {
        return getOriginalTitle();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Boolean value5() {
        return getIsAdult();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value6() {
        return getStartYear();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value7() {
        return getEndYear();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value8() {
        return getRuntimeMinutes();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String[] value9() {
        return getGenres();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TitleBasicsRecord value1(String value) {
        setTconst(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TitleBasicsRecord value2(String value) {
        setTitleType(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TitleBasicsRecord value3(String value) {
        setPrimaryTitle(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TitleBasicsRecord value4(String value) {
        setOriginalTitle(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TitleBasicsRecord value5(Boolean value) {
        setIsAdult(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TitleBasicsRecord value6(Integer value) {
        setStartYear(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TitleBasicsRecord value7(Integer value) {
        setEndYear(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TitleBasicsRecord value8(Integer value) {
        setRuntimeMinutes(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TitleBasicsRecord value9(String... value) {
        setGenres(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TitleBasicsRecord values(String value1, String value2, String value3, String value4, Boolean value5, Integer value6, Integer value7, Integer value8, String[] value9) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        value5(value5);
        value6(value6);
        value7(value7);
        value8(value8);
        value9(value9);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached TitleBasicsRecord
     */
    public TitleBasicsRecord() {
        super(TitleBasics.TITLE_BASICS);
    }

    /**
     * Create a detached, initialised TitleBasicsRecord
     */
    public TitleBasicsRecord(String tconst, String titleType, String primaryTitle, String originalTitle, Boolean isAdult, Integer startYear, Integer endYear, Integer runtimeMinutes, String[] genres) {
        super(TitleBasics.TITLE_BASICS);

        set(0, tconst);
        set(1, titleType);
        set(2, primaryTitle);
        set(3, originalTitle);
        set(4, isAdult);
        set(5, startYear);
        set(6, endYear);
        set(7, runtimeMinutes);
        set(8, genres);
    }
}
