package com.nkita.practice.collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        PersonStatisticHandler personStatisticHandler = new PersonStatisticHandler();

        personStatisticHandler.addPersonForStatistic(new Person("Nikita", 23, 1.79, 90, Gender.MALE));
        personStatisticHandler.addPersonForStatistic(new Person("Marcus", 20, 1.70, 52, Gender.MALE));
        personStatisticHandler.addPersonForStatistic(new Person("Alina", 24, 1.60, 70, Gender.FEMALE));
        personStatisticHandler.addPersonForStatistic(new Person("Diana", 29, 1.70, 70, Gender.FEMALE));
        personStatisticHandler.addPersonForStatistic(new Person("Sasha", 40, 1.85, 80, Gender.MALE));
        personStatisticHandler.addPersonForStatistic(new Person("Maksim", 9, 1.85, 80, Gender.MALE));
        personStatisticHandler.addPersonForStatistic(new Person("Dima", 49, 1.85, 80, Gender.MALE));


        personStatisticHandler.checkOldestPerson(null);









    }
}
