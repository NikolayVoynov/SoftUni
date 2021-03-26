package harvestingFields;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Field[] declaredFields = RichSoilLand.class.getDeclaredFields();

        String line;

        while (!"HARVEST".equals(line = scanner.nextLine())) {
            String modifier = line;

            Field[] fieldsFiltered = Arrays.stream(declaredFields)
                    .filter(field -> Modifier.toString(field.getModifiers()).equals(modifier))
                    .toArray(Field[]::new);

            if (fieldsFiltered.length == 0) {
                printFields(declaredFields);

            } else {
                printFields(fieldsFiltered);
            }
        }
    }

    private static void printFields(Field[] fields) {
        Arrays.stream(fields)
                .forEach(field -> System.out.println(String.format("%s %s %s", Modifier.toString(field.getModifiers()),
                        field.getType().getSimpleName(), field.getName())));
    }


}
