package com.nkita.practice.collections;

public class Main {
    public static void main(String[] args) {
        PersonStatisticHandler personStatisticHandler = new PersonStatisticHandler();

        personStatisticHandler.addPersonForStatistic(new Person("Nikita", 23, 1.79, 90, Gender.MALE));
        personStatisticHandler.addPersonForStatistic(new Person("Nikita", 23, 1.79, 90, Gender.MALE));
        personStatisticHandler.addPersonForStatistic(new Person("Marcus", 20, 1.70, 52, Gender.MALE));
        personStatisticHandler.addPersonForStatistic(new Person("Alina", 24, 1.60, 70, Gender.FEMALE));
        personStatisticHandler.addPersonForStatistic(new Person("Alina", 24, 1.60, 70, Gender.FEMALE));
        personStatisticHandler.addPersonForStatistic(new Person("Maksim", 40, 1.85, 80, Gender.MALE));
        personStatisticHandler.addPersonForStatistic(new Person("Dasha", 40, 1.85, 80, Gender.MALE));
        personStatisticHandler.addPersonForStatistic(new Person("Dasha", 40, 1.85, 80, Gender.MALE));




            personStatisticHandler.checkFullStatisticWithoutDuplicates();
        System.out.println();
            personStatisticHandler.checkStatisticByName("Nikita");
        System.out.println();
        personStatisticHandler.removeDuplicates();
        System.out.println();
        personStatisticHandler.checkStatisticByName("Nikita");
        personStatisticHandler.checkStatisticByName("Marcus");
        personStatisticHandler.checkStatisticByName("Alina");
        personStatisticHandler.checkStatisticByName("Maksim");
        personStatisticHandler.checkStatisticByName("Dasha");




    }
}
