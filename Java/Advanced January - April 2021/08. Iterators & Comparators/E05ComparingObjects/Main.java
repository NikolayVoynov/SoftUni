package E05ComparingObjects;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = "";

        List<Person> people = new ArrayList<>();

        while (!"END".equals(input = scanner.nextLine())) {
            String[] token = input.split("\\s+");
            String name = token[0];
            int age = Integer.parseInt(token[1]);
            String town = token[2];

            Person person = new Person(name, age, town);
            people.add(person);
        }

        int index = Integer.parseInt(scanner.nextLine());

        Person searchPerson = people.get(index - 1);

        int equal = 0;

        for (Person person : people) {
            if (person.compareTo(searchPerson) == 0) {
                equal++;
            }
        }

        if (equal == 1) {
            System.out.println("No matches");
        } else {
            System.out.printf("%d %d %d", equal, people.size() - equal, people.size());
        }
    }
}
