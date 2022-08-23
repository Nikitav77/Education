package com.nkita.practice.collections;

import java.util.*;

public class PersonStatisticHandler {

    private List<Person> persons = new ArrayList<>();


    public void addPersonForStatistic(Person person) {
        persons.add(person);

    }


    public void checkStatistic() {
        List<Person> male = new ArrayList<>();
        List<Person> female = new ArrayList<>();


        for (Person person : persons) {
            if (person.getGender() == Gender.MALE) {
                male.add(person);
            } else {
                female.add(person);
            }
        }


        System.out.println("There are " + male.size() + " man");
        System.out.println(male);
        System.out.println();
        System.out.println("There are " + female.size() + " woman");
        System.out.println(female);

    }

    public void checkStatisticByAge(int age) {
        List<Person> personsList = new ArrayList<>();
        for (Person person : persons) {
            if (person.getAge() == age) {
                personsList.add(person);
            }

        }

        String goodString = String.format("There are %s persons with age = %s", persons.size(), age);
        String warning = "This age is not listed";
        printInfo(personsList, goodString, warning);

    }


    private void printInfo(List<Person> list, String goodString, String warningString) {


        if (!list.isEmpty()) {
            System.out.println(goodString);
            System.out.println(list);
        } else {
            System.out.println(warningString);
        }


    }


    public void checkStatisticByName(String name) {
        List<Person> personList1 = new ArrayList<>();
        for (Person person : persons) {
            if (person.getName().equals(name)) {
                personList1.add(person);
            }

        }

        String goodString = String.format("There are %s persons with name = %s", persons.size(), name);
        String warning = "There is no such name";

        printInfo(personList1, goodString, warning);

    }


    public void checkStatisticByAgeList(List<Integer> ageList) {
        List<Person> personList = new ArrayList<>();


        for (Person person : persons) {
            if (ageList.contains(person.getAge())) {
                personList.add(person);
            }

        }

        String goodString = "There are " + personList.size() + "-> " + ageList;
        String warningString = "This age is not listed";
        printInfo2(personList, goodString, warningString);


    }

    private void printInfo2(List<Person> list, String goodString, String warningString) {
        if (list.isEmpty()) {

            System.out.println(warningString);

        } else {
            System.out.println(goodString);
            for (Person person : list) {
                System.out.println(person);
            }
        }


    }


    public void checkStatisticByNameList(List<String> nameList) {
        List<Person> personList = new ArrayList<>();

        for (Person person : persons) {
            if (nameList.contains(person.getName())) {
                personList.add(person);

            }
        }

//        if (personList.isEmpty()) {
//            System.out.println("This name is not on the list.");
//        } else {
//            System.out.println("There are " + personList.size() + " -> " + nameList);
//            for (Person person : personList) {
//                System.out.println(person);
//            }
//        }
        String warningString = "This name is not on the list.";
        String goodString = "There are " + personList.size() + " -> " + nameList;
        printInfo2(personList, goodString, warningString);

    }


    public void printInfo3(List<Person> list, String goodString, String warningString) {

        if (!list.isEmpty()) {
            System.out.println(goodString);

        } else {
            System.out.println(warningString);
        }

    }


    public void matchByName(String string) {
        List<Person> personList = new ArrayList<>();
        for (Person person : persons) {
            if (person.getName().contains(string)) {
                personList.add(person);
            }
        }

        String warningString = "Search failed";
        String goodString = "There are " + personList.size() + " Witch name that match provided string - >" + string + "" + "\n" + personList;
        printInfo3(personList, goodString, warningString);
    }


    public void matchByNameIgnoreCase(String string) {
        List<Person> personList = new ArrayList<>();
        for (Person person : persons) {
            if (person.getName().toLowerCase().contains(string.toLowerCase())) {
                personList.add(person);
            }
        }
//        if (!personList.isEmpty()) {
//            System.out.println("There are " + personList.size() + " Witch name that match provided string - >" + string);
//            System.out.println(personList);
//        } else {
//            System.out.println("Search failed");
//        }
        String warningString = "Search failed";
        String goodString = "There are " + personList.size() + " Witch name that match provided string - >" + string + "\n" + personList;
        printInfo3(personList, goodString, warningString);
    }


    public void checkFullStatisticWithoutDuplicates() {
        Set<Person> personSet = new LinkedHashSet<>(persons);
        System.out.println("Statistics with duplicate");

        for (Person person : persons) {
            personSet.add(person);
            System.out.println(personSet);
            return;
        }

    }


//    public void removeDuplicates() {
//        Set<Person> personSet = new LinkedHashSet<>(persons);
//        for (Person person : persons) {
//            personSet.add(person);
//            persons.remove(person);
//            personSet.add(person);
//            return;
//
//        }
//
//
//    }

    public void removeDuplicates() {
        Set<Person> personSet = new LinkedHashSet<>(persons);
        persons.clear();
        persons.addAll(personSet);

        }


    }




