package E06StrategyPattern;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Set<Person> peopleByName = new TreeSet<>(new ComparatorByName());
        Set<Person> peopleByAge = new TreeSet<>(new ComparatorByAge());


        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            String[] personInfo = scanner.nextLine().split("\\s+");
            String name = personInfo[0];
            int age = Integer.parseInt(personInfo[1]);
            Person person = new Person(name, age);

            peopleByName.add(person);
            peopleByAge.add(person);
        }

        for (Person person : peopleByName) {
            System.out.println(person);
        }

        for (Person person : peopleByAge) {
            System.out.println(person);
        }
    }
}
