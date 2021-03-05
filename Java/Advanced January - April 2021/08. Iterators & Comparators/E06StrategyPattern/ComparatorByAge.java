package E06StrategyPattern;

import java.util.Comparator;

public class ComparatorByAge implements Comparator<Person> {
    @Override
    public int compare(Person person1, Person person2) {
        int result = person1.getAge() - person2.getAge();
        return result;
    }
}
