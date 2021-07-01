import entities.Employee;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Engine implements Runnable{

    private final EntityManager entityManager;
    private BufferedReader bufferedReader;

    public Engine(EntityManager entityManager) {
        this.entityManager = entityManager;
        this.bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    }


    @Override
    public void run() {
        System.out.println("Enter exercise number:");
        try {
            int exerciseNumber = Integer.parseInt(bufferedReader.readLine());

            switch (exerciseNumber) {
                case 2 -> exerciseTwoChangeCasing();
                case 3 -> exerciseThreeContainsEmployee();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            entityManager.close();
        }

    }

    private void exerciseThreeContainsEmployee() throws IOException {
        System.out.println("Enter employee full name:");
        String[] fullName = bufferedReader.readLine().split("\\s+");
        String firstName = fullName[0];
        String lastName = fullName[1];

        Long singleResult = entityManager.createQuery("SELECT count(e) FROM Employee e " +
                        "WHERE e.firstName = :f_name AND e.lastName = :l_name", Long.class)
                .setParameter("f_name", firstName)
                .setParameter("l_name", lastName)
                .getSingleResult();

        System.out.println(singleResult == 0 ? "No" : "Yes");
    }

    private void exerciseTwoChangeCasing() {

        entityManager.getTransaction().begin();

        Query query = entityManager.createQuery("UPDATE Town t " +
                " SET t.name = UPPER(t.name) " +
                "WHERE LENGTH(t.name) <= 5 ");

        System.out.println(query.executeUpdate());

        entityManager.getTransaction().commit();
    }

}
