import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class E03OpinionPoll {

    static class Person {
        String name;
        int age;

        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public String toString() {
            return String.format("%s - %d", getName(), getAge());
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        List<Person> allPersons = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] data = scanner.nextLine().split(" ");
            String name = data[0];
            int age = Integer.parseInt(data[1]);

            Person person = new Person(name, age);

            allPersons.add(person);
        }

        allPersons
                .stream()
                .filter(person -> person.getAge() > 30)
                .sorted((person1, person2) -> person1.getName().compareTo(person2.getName()))
                .forEach(person -> System.out.println(person.toString()));
    }
}
