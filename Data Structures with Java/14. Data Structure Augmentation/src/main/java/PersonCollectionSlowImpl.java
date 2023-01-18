import java.util.ArrayList;
import java.util.List;

public class PersonCollectionSlowImpl implements PersonCollection {
    private List<Person> personCollection;

    public PersonCollectionSlowImpl() {
        this.personCollection = new ArrayList<>();
    }

    @Override
    public boolean add(String email, String name, int age, String town) {
        throw new UnsupportedOperationException();
    }

    @Override
    public int getCount() {
        return this.personCollection.size();
    }

    @Override
    public boolean delete(String email) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Person find(String email) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Iterable<Person> findAll(String emailDomain) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Iterable<Person> findAll(String name, String town) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Iterable<Person> findAll(int startAge, int endAge) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Iterable<Person> findAll(int startAge, int endAge, String town) {
        throw new UnsupportedOperationException();
    }
}
