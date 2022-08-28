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

        String warningString = "Search failed";
        String goodString = "There are " + personList.size() + " Witch name that match provided string - >" + string + "\n" + personList;
        printInfo3(personList, goodString, warningString);
    }

    public void checkFullStatisticWithoutDuplicates() {
        Set<Person> personSet = new LinkedHashSet<>(persons);
        System.out.println("Statistics with duplicate");

        for (Person person : personSet) {
            System.out.println(person);
        }


    }


    public void removeDuplicates() {
        Set<Person> personSet = new LinkedHashSet<>(persons);
        persons.clear();
        persons.addAll(personSet);

    }


    public void checkOldestPerson(Gender original) {

        List<Person> female = new ArrayList<>();
        List<Person> femaleAge = new ArrayList<>();
        List<Person> male = new ArrayList<>();
        List<Person> maleAge = new ArrayList<>();
        List<Person> genderMaleAndFemale = new ArrayList<>();
        List<Person> genderMaleAgeAndGenderFemaleAge = new ArrayList<>();


        int max = 0;


        for (Person person : persons) {

            if (original == null) {
                genderMaleAndFemale.add(person);
            }
        }

        for (Person person : genderMaleAndFemale) {
            if (person.getAge() > max)
                max = person.getAge();
        }

        for (Person person : genderMaleAndFemale) {
            if (person.getAge() == max) {
                genderMaleAgeAndGenderFemaleAge.add(person);
            }

        }


        for (Person person : persons) {
            if (person.getGender() == Gender.FEMALE) {
                female.add(person);

            }
        }

        for (Person person1 : female) {
            if (person1.getAge() > max)
                max = person1.getAge();
        }

        for (Person personAge : female) {
            if (personAge.getAge() == max) {
                femaleAge.add(personAge);
            }

        }


        for (Person person : persons) {
            if (person.getGender() == Gender.MALE) {
                male.add(person);

            }
        }

        for (Person person1 : male) {
            if (person1.getAge() > max)
                max = person1.getAge();
        }

        for (Person personAge : male) {
            if (personAge.getAge() == max) {
                maleAge.add(personAge);
            }

        }


        if (original == Gender.FEMALE) {
            System.out.println("The oldest Person(s) witch gender FEMALE");
            System.out.println(femaleAge);
        } else if (original == Gender.MALE) {
            System.out.println("The oldest Person(s) witch gender MALE");
            System.out.println(maleAge);
        } else {
            System.out.println("The oldest Person(s) number of people => " + genderMaleAgeAndGenderFemaleAge.size());
            System.out.println(genderMaleAgeAndGenderFemaleAge);
        }

    }
}














