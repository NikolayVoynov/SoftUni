package E06StrategyPattern;

import java.util.Comparator;

public class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        setAge(age);
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age < 0) {
            throw new IllegalArgumentException("You can not set negative age on person!");
        }
        this.age = age;
    }

    @Override
    public String toString() {
        String printPerson = String.format("%s %s", this.name, this.age);
        return printPerson.toString();
    }
}
