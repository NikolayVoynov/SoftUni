package E06StrategyPattern;

import java.util.Comparator;

public class ComparatorByName implements Comparator<Person> {
    @Override
    public int compare(Person person1, Person person2) {
        int result = person1.getName().length() - person2.getName().length();
        if (result == 0) {
            result = person1.getName().toLowerCase().charAt(0) - person2.getName().toLowerCase().charAt(0);
        }
        return result;
    }
}
