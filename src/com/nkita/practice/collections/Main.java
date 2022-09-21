package com.nkita.practice.collections;

import com.nkita.practice.collections.PersonFilter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        PersonStatisticHandler personStatisticHandler = new PersonStatisticHandler();

        personStatisticHandler.addPersonForStatistic(new Person("Nikita", 23, 1.79, 90.0, Gender.MALE));
        personStatisticHandler.addPersonForStatistic(new Person("Marcus", 20, 1.70, 52, Gender.MALE));
        personStatisticHandler.addPersonForStatistic(new Person("Alina", 24, 1.60, 70, Gender.FEMALE));
        personStatisticHandler.addPersonForStatistic(new Person("Diana", 29, 1.70, 70, Gender.FEMALE));
        personStatisticHandler.addPersonForStatistic(new Person("Sasha", 40, 1.85, 80, Gender.MALE));
        personStatisticHandler.addPersonForStatistic(new Person("Maksim", 9, 1.85, 80, Gender.MALE));
        personStatisticHandler.addPersonForStatistic(new Person("Dima", 49, 1.85, 80, Gender.MALE));
        personStatisticHandler.addPersonForStatistic(new Person("Dima", 20, 1.85, 80, Gender.MALE));
        personStatisticHandler.addPersonForStatistic(new Person("Dima", 30, 1.85, 80, Gender.MALE));

        PersonFilter<String> filterByName = new PersonFilter<>(PersonProperty.NAME, Arrays.asList("Nikita", "Ilya"));
        PersonFilter<Integer> filterByAge = new PersonFilter<>(PersonProperty.AGE, Arrays.asList(23, 25, 54));
        PersonFilter<Double> filterHeight = new PersonFilter<>(PersonProperty.HEIGHT, Arrays.asList(1.79, 1.60));
        PersonFilter<Double> filterWeight = new PersonFilter<>(PersonProperty.WEIGHT, Arrays.asList(90.0, 100.0, 9.0));
        PersonFilter<Gender> filterGender = new PersonFilter<>(PersonProperty.GENDER, Arrays.asList(Gender.MALE));



        List<PersonFilter> filters = new ArrayList<>();
        filters.add(filterByName);
        filters.add(filterByAge);
        filters.add(filterHeight);
        filters.add(filterWeight);
        filters.add(filterGender);


      personStatisticHandler.checkFilteredStatistic(filters);
    }
}
