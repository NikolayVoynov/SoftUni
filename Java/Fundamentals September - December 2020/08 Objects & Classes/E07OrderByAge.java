import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class E07OrderByAge {
    static class Person {
        String name;
        String id;
        int age;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public Person(String name, String id, int age) {
            this.name = name;
            this.id = id;
            this.age = age;
        }

        public String toString() {
            return String.format("%s with ID: %s is %d years old.", getName(), getId(), getAge());
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        List<Person> allPerson = new ArrayList<>();

        while (!input.equals("End")) {
            String[] data = input.split(" ");
            String name = data[0];
            String id = data[1];
            int age = Integer.parseInt(data[2]);

            Person person = new Person(name, id, age);

            allPerson.add(person);

            input = scanner.nextLine();
        }

        allPerson
                .stream()
                .sorted((person1, person2) -> Integer.compare(person1.getAge(), person2.getAge()))
                .forEach(person -> System.out.println(person.toString()));

    }
}
