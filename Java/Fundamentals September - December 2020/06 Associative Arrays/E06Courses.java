import java.util.*;

public class E06Courses {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, List<String>> courses = new LinkedHashMap<>();

        String input = scanner.nextLine();

        while (!input.equals("end")) {
            String[] data = input.split(" : ");
            String course = data[0];
            String student = data[1];

            if (!courses.containsKey(course)) {
                courses.put(course, new LinkedList<>());
            }

            courses.get(course).add(student);

            input = scanner.nextLine();
        }

        courses.entrySet()
                .stream()
                .sorted((f, s) -> s.getValue().size() - f.getValue().size())
                .forEach(e -> {
                    System.out.println(e.getKey() + ": " + e.getValue().size());
                    e.getValue()
                            .stream()
                            .sorted((f, s) -> f.compareTo(s))
                            .forEach(student -> System.out.println("-- " + student));
                });
    }
}
