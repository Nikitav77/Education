package com.nkita.practice.collections;

import java.util.Objects;

public class Person implements Comparable<Person> {
    private String name;
    private int age;
    private double height;
    private  double weight;
    private  Gender gender;


    public Person(String name, int age, double height, double weight, Gender gender) {
        this.name = name;
        this.age = age;
        this.height = height;
        this.weight = weight;
        this.gender = gender;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return age == person.age && Double.compare(person.height, height) == 0 && Double.compare(person.weight, weight) == 0 && Objects.equals(name, person.name) && gender == person.gender;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, height, weight, gender);
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", height=" + height +
                ", weight=" + weight +
                ", gender=" + gender +
                '}';
    }

    public Gender getGender() {
        return gender;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public double getHeight() {
        return height;
    }

    public double getWeight() {
        return weight;
    }

    @Override
    public int compareTo(Person o) {
        return this.name.compareTo(o.getName());
    }
}
