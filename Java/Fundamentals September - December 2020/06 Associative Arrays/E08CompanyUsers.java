import java.util.*;

public class E08CompanyUsers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, List<String>> companiesInfo = new TreeMap<>();

        String input = scanner.nextLine();

        while (!input.equals("End")) {
            String[] data = input.split(" -> ");
            String company = data[0];
            String employee = data[1];

            companiesInfo.putIfAbsent(company, new ArrayList<>());
            if (!companiesInfo.get(company).contains(employee)) {
                companiesInfo.get(company).add(employee);
            }


            input = scanner.nextLine();
        }

        companiesInfo.entrySet()
                .forEach(e -> {
                    System.out.println(e.getKey());
                    e.getValue()
                            .stream()
                            .forEach(employee -> System.out.println("-- " + employee));
                });
    }
}
