import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class PersonCollectionSlowImpl implements PersonCollection {
    private List<Person> personCollection;

    public PersonCollectionSlowImpl() {
        this.personCollection = new ArrayList<>();
    }

    @Override
    public boolean add(String email, String name, int age, String town) {
        Person person = this.find(email);
        if (person != null) {
            return false;
        }

        Person newPerson = new Person(email, name, age, town);
        this.personCollection.add(newPerson);

        return true;
    }

    @Override
    public int getCount() {
        return this.personCollection.size();
    }

    @Override
    public boolean delete(String email) {
        return this.personCollection.removeIf(p -> p.getEmail().equals(email));
    }

    @Override
    public Person find(String email) {
        return this.personCollection.stream().filter(p -> p.getEmail().equals(email)).findFirst().orElse(null);
    }

    @Override
    public Iterable<Person> findAll(String emailDomain) {
        return this.personCollection
                .stream()
                .filter(p -> p.getEmail().endsWith("@" + emailDomain))
                .sorted(Comparator.comparing(Person::getEmail))
                .collect(Collectors.toList());
    }

    @Override
    public Iterable<Person> findAll(String name, String town) {
        return this.personCollection
                .stream()
                .filter(p -> p.getName().equals(name) && p.getTown().equals(town))
                .sorted(Comparator.comparing(Person::getEmail))
                .collect(Collectors.toList());
    }

    @Override
    public Iterable<Person> findAll(int startAge, int endAge) {
        return this.personCollection
                .stream()
                .filter(p -> startAge <= p.getAge() && p.getAge() <= endAge)
                .sorted((p1, p2) -> {
                    int result = Integer.compare(p1.getAge(), p2.getAge());

                    if (result == 0) {
                        result = p1.getEmail().compareTo(p2.getEmail());
                    }

                    return result;
                })
                .collect(Collectors.toList());
    }

    @Override
    public Iterable<Person> findAll(int startAge, int endAge, String town) {
        return this.personCollection
                .stream()
                .filter(p -> startAge <= p.getAge() && p.getAge() <= endAge && p.getTown().equals(town))
                .sorted((p1, p2) -> {
                    int result = Integer.compare(p1.getAge(), p2.getAge());

                    if (result == 0) {
                        result = p1.getEmail().compareTo(p2.getEmail());
                    }

                    return result;
                })
                .collect(Collectors.toList());
    }
}
