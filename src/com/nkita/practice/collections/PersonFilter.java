package com.nkita.practice.collections;

import java.util.ArrayList;
import java.util.List;

public class PersonFilter <T>{
    private PersonProperty personProperty;
    List<T> list = new ArrayList<T>();


    public PersonFilter(PersonProperty personProperty, List<T> list) {
        this.personProperty = personProperty;
        this.list = list;
    }


    public PersonProperty getPersonProperty() {
        return personProperty;
    }


    public void setPersonProperty(PersonProperty personProperty) {
        this.personProperty = personProperty;
    }


    public List<T> getList() {
        return list;
    }


    public void setList(List<T> list) {
        this.list = list;
    }


    @Override
    public String toString() {
        return "PersonFilter{" +
                "list=" + list +
                '}';
    }
}
