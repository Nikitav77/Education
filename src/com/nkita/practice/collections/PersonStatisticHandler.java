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
        List<Person> personsList = getPersonsListByAge(age, null);

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

    private List<Person> getPersonsListByAge(int age, Gender gender) {

        List<Person> personsList = new ArrayList<>();

        for (Person person : persons) {
            if (person.getAge() == age && (gender == null || gender == person.getGender())) {
                personsList.add(person);
            }

        }
        return personsList;

    }


    public void checkOldestPerson(Gender gender) {

        int maxAge = 0;
        boolean ignoreGender = gender == null;
        for (Person person : persons) {
            if (person.getAge() > maxAge && (ignoreGender || person.getGender() == gender)) {
                maxAge = person.getAge();
            }
        }

        List<Person> oldestPersons = getPersonsListByAge(maxAge, gender);

        if (ignoreGender) {
            System.out.println("The oldest Person(s) number of people => " + oldestPersons.size() + "\n" + oldestPersons);

        } else {
            System.out.println("The oldest Person(s) witch gender " + gender + "\n" + oldestPersons);
        }
    }

    public void checkSortedStatistic() {
        List<Person> personList = new ArrayList<>(persons);
        personList.sort(new Comparator<Person>() {
            @Override
            public int compare(Person age1, Person age2) {
                if (age1.getAge() > age2.getAge()) {
                    return -1;
                } else if (age1.getAge() < age2.getAge()) {
                    return 1;
                } else {
                    return 0;
                }

            }
        });
        Collections.sort(personList);

        for (Person o : personList) {
            System.out.println(o.getName() + " | " + o.getAge());
        }
    }


    public void checkFilteredStatistic(PersonFilterRequest personFilterRequest) {
        List<Person> personList = new ArrayList<>();
        for (Person person : persons) {

            if (isPersonValidForFilters(personFilterRequest, person)) {
                personList.add(person);
            }
        }
        printInfo(personList);
    }

    private boolean isPersonValidForFilters(PersonFilterRequest personFilterRequest, Person person) {
        List<Boolean> inspectionResults = new ArrayList<>();
        for (PersonFilter personFilter : personFilterRequest.getPersonFilters()) {
            boolean getResultOfChecking = isPersonValidForFilter(personFilter, person);
            inspectionResults.add(getResultOfChecking);
        }

        if (personFilterRequest.isSearchType()) {
            return inspectionResults.contains(true);
        } else {
            return !inspectionResults.contains(false);
        }
    }

    private boolean isPersonValidForFilter(PersonFilter personFilter, Person person) {
        PersonProperty personProperty = personFilter.getPersonProperty();

        switch (personProperty) {
            case NAME:
                return personFilter.getValues().contains(person.getName());
            case AGE:
                return personFilter.getValues().contains(person.getAge());
            case HEIGHT:
                return personFilter.getValues().contains(person.getHeight());
            case WEIGHT:
                return personFilter.getValues().contains(person.getWeight());
            case GENDER:
                return personFilter.getValues().contains(person.getGender());
            default:
                return false;
        }

    }

    public void printInfo(List<Person> personList) {

        if (!personList.isEmpty()) {
            System.out.println("Search successful found Person(s)");
            System.out.println(personList);
        } else
            System.out.println("Search failed no Person(s) found");

    }

    public void checkByGenderMap() {
        List<String> male = new ArrayList<>();
        List<String> female = new ArrayList<>();

        for (Person person : persons) {
            if (person.getGender() == Gender.MALE) {
                male.add(person.getName());
            } else {
                female.add(person.getName());
            }
        }

        Map<Gender, List<String>> genderListMapMale = new HashMap<>();
        Map<Gender, List<String>> genderListMapFemale = new HashMap<>();

        genderListMapMale.put(Gender.MALE, male);
        genderListMapFemale.put(Gender.FEMALE, female);

        if (female.size() > 0 && male.size() > 0) {
            System.out.println(genderListMapFemale + " " + genderListMapMale);
        } else if (female.size() != 0) {
            System.out.println(genderListMapFemale);
        } else if (male.size() != 0) {
            System.out.println(genderListMapMale);
        } else {
            System.out.println("Statistics is empty");
        }

    }

    public void checkMapByPersonProperty(PersonProperty personProperty) {
        Map<String, List<Person>> stringListMap = new HashMap<>();

        for (Person person : persons) {
            String key = generateKey(personProperty, person);

            List<Person> personList = new ArrayList<>();
            personList.add(person);

            List<Person> personListGetKey = stringListMap.get(key);

            if (stringListMap.containsKey(key)) {
                personListGetKey.add(person);
                stringListMap.put(key, personListGetKey);
            } else {
                stringListMap.put(key, personList);
            }
        }
        System.out.println(stringListMap);
    }

    public String generateKey(PersonProperty personProperty, Person person) {
        switch (personProperty) {
            case AGE:
                return String.valueOf(person.getAge());
            case GENDER:
                return String.valueOf(person.getGender());
            case NAME:
                return person.getName();
            case HEIGHT:
                return String.valueOf(person.getHeight());
            default:
                return String.valueOf(person.getWeight());
        }
    }

}

