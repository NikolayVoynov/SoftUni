package E07Google;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        Map<String, Person> persons = new HashMap<>();

        while (!input.equals("End")) {
            String[] token = input.split("\\s+");
            String personName = token[0];

            persons.putIfAbsent(personName, new Person(personName, null, null, null, null, null));

            switch (token[1]) {
                case "company":
                    Company company = new Company(token[2], token[3], Double.parseDouble(token[4]));
                    persons.get(personName).setCompany(company);
                    break;
                case "pokemon":
                    Pokemon pokemon = new Pokemon(token[2], token[3]);
                    persons.get(personName).addPokemon(pokemon);
                    break;
                case "parents":
                    Parents parent = new Parents(token[2], token[3]);
                    persons.get(personName).addParent(parent);
                    break;
                case "children":
                    Children child = new Children(token[2], token[3]);
                    persons.get(personName).addChild(child);
                    break;
                case "car":
                    Car car = new Car(token[2], Integer.parseInt(token[3]));
                    persons.get(personName).setCar(car);
                    break;
            }

            input = scanner.nextLine();
        }

        String printInfoForThisName = scanner.nextLine();

        System.out.print(persons.get(printInfoForThisName));
    }
}
