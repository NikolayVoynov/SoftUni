import java.util.*;

public class PersonCollectionImpl implements PersonCollection {
    private Map<String, Person> peopleByEmail;
    private Map<String, TreeSet<Person>> peopleByDomain;
    private Map<String, TreeSet<Person>> peopleByNameTown;
    private TreeMap<Integer, TreeSet<Person>> peopleByAgeRange;
    private Map<String, TreeMap<Integer,TreeSet<Person>>> peopleByAgeAndTown;


    public PersonCollectionImpl() {
        this.peopleByEmail = new HashMap<>();
        this.peopleByDomain = new HashMap<>();
        this.peopleByNameTown = new HashMap<>();
        this.peopleByAgeRange = new TreeMap<>();
        this.peopleByAgeAndTown = new HashMap<>();
    }

    @Override
    public boolean add(String email, String name, int age, String town) {
        if (this.find(email) == null) {
            Person newPerson = new Person(email, name, age, town);
            this.peopleByEmail.put(email, newPerson);

            String[] splitEmail = email.split("@");
            String domain = splitEmail[1];
            if (!this.peopleByDomain.containsKey(domain)) {
                this.peopleByDomain.put(domain, new TreeSet<>());
            }
            this.peopleByDomain.get(domain).add(newPerson);

            String nameAndTown = name + town;
            if (!this.peopleByNameTown.containsKey(nameAndTown)) {
                this.peopleByNameTown.put(nameAndTown, new TreeSet<>());
            }
            this.peopleByNameTown.get(nameAndTown).add(newPerson);

            if (!this.peopleByAgeRange.containsKey(age)) {
                this.peopleByAgeRange.put(age, new TreeSet<>());
            }
            this.peopleByAgeRange.get(age).add(newPerson);

            if (!this.peopleByAgeAndTown.containsKey(town)) {
                this.peopleByAgeAndTown.put(town, new TreeMap<Integer, TreeSet<Person>>());
            }
            this.peopleByAgeAndTown.get(age).add(newPerson);

            return true;
        }

        return false;
    }

    @Override
    public int getCount() {
        return this.peopleByEmail.size();
    }

    @Override
    public boolean delete(String email) {
        if (find(email) != null) {
            String[] splitEmail = email.split("@");
            String domain = splitEmail[1];

            this.peopleByEmail.remove(email);
            this.peopleByDomain.remove(domain);
            return true;
        }

        return false;
    }

    @Override
    public Person find(String email) {
        return this.peopleByEmail.get(email);
    }

    @Override
    public Iterable<Person> findAll(String emailDomain) {
        if (this.peopleByDomain.containsKey(emailDomain)) {
            return this.peopleByDomain.get(emailDomain);
        }
        return new TreeSet<>();
    }

    @Override
    public Iterable<Person> findAll(String name, String town) {
        String nameAndTown = name + town;
        if (this.peopleByNameTown.containsKey(nameAndTown)) {
            return this.peopleByNameTown.get(nameAndTown);
        }
        return new TreeSet<>();
    }

    @Override
    public Iterable<Person> findAll(int startAge, int endAge) {
        List<Person> resultListPerson = new ArrayList<>();
        this.peopleByAgeRange.entrySet().forEach(e -> {
            if (e.getKey() >= startAge && e.getKey() <= endAge) {
                resultListPerson.addAll(e.getValue());
            }
        });

        return resultListPerson;
    }

    @Override
    public Iterable<Person> findAll(int startAge, int endAge, String town) {
        throw new UnsupportedOperationException();
    }
}
