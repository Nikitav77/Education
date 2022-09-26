package com.nkita.practice.collections;

import java.util.ArrayList;
import java.util.List;

public class PersonFilter<T> {
    private PersonProperty personProperty;
    private List<T> values;


    public PersonFilter(PersonProperty personProperty, List<T> values) {
        this.personProperty = personProperty;
        this.values = values;
    }

    public PersonProperty getPersonProperty() {
        return personProperty;
    }


    public void setPersonProperty(PersonProperty personProperty) {
        this.personProperty = personProperty;
    }


    public void setList(List<T> list) {
        this.values = list;
    }


    public List<T> getValues() {
        return values;
    }

    public void setValues(List<T> values) {
        this.values = values;
    }

    @Override
    public String toString() {
        return "PersonFilter{" +
                "personProperty=" + personProperty +
                ", values=" + values +
                '}';
    }
}
