package com.nkita.practice.collections;

import java.util.List;
import java.util.Objects;

public class PersonFilterRequest {

    private List<PersonFilter> personFilters;
    private boolean searchType;

    public PersonFilterRequest() {
    }

    public PersonFilterRequest(List<PersonFilter> personFilters, boolean searchType) {
        this.personFilters = personFilters;
        this.searchType = searchType;
    }

    public List<PersonFilter> getPersonFilters() {
        return personFilters;
    }

    public boolean isSearchType() {
        return searchType;
    }
}


