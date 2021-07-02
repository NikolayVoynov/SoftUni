import entities.Address;
import entities.Employee;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.List;
import java.util.Set;

public class Engine implements Runnable {

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
                case 4 -> exerciseFourEmployeesWithSalaryOver50000();
                case 5 -> exerciseFiveEmployeesFromDepartment();
                case 6 -> exerciseSixAddingNewAddressAndUpdatingEmployee();
                case 7 -> exerciseSevenAddressesWithEmployeeCount();
                case 10 -> exerciseTenIncreaseSalaries();
                case 12 -> exerciseTwelveEmployeesMaximumSalaries();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            entityManager.close();
        }

    }

    @SuppressWarnings("unchecked")
    private void exerciseTwelveEmployeesMaximumSalaries() {
        List<Object[]> listOfDeptMaxSalary =
                entityManager.
                        createNativeQuery("SELECT d.name, max(e.salary) AS m_salary FROM departments d " +
                "JOIN employees e on d.department_id = e.department_id " +
                "GROUP BY d.name " +
                "HAVING m_salary NOT BETWEEN 30000 AND 70000;")
                .getResultList();

    }

    private void exerciseTenIncreaseSalaries() {

        entityManager.getTransaction().begin();
        entityManager
                .createQuery("UPDATE Employee e " +
                        "SET e.salary = e.salary + e.salary * 0.12 " +
                        "WHERE e.department.id IN :ids")
                .setParameter("ids", Set.of(1, 2, 4, 11))
                .executeUpdate();
        entityManager.getTransaction().commit();

        List<Employee> employeesWithIncreasedSalary = entityManager
                .createQuery("SELECT e FROM Employee e " +
                        "WHERE e.department.id IN :ids", Employee.class)
                .setParameter("ids", Set.of(1, 2, 4, 11))
                .getResultList();

        employeesWithIncreasedSalary
                .forEach(employee -> {
                    System.out.printf("%s %s ($%.2f)%n",
                            employee.getFirstName(),
                            employee.getLastName(),
                            employee.getSalary());
                });
    }

    private void exerciseSevenAddressesWithEmployeeCount() {
        List<Address> resultListOfAddresses = entityManager
                .createQuery("SELECT a FROM Address a " +
                        "ORDER BY a.employees.size DESC ", Address.class)
                .setMaxResults(10)
                .getResultList();


        resultListOfAddresses.forEach(address -> {
            System.out.printf("%s, %s - %d employees%n",
                    address.getText(),
                    address.getTown() == null ? "Unknown" : address.getTown().getName(),
                    address.getEmployees().size());
        });
    }

    private void exerciseSixAddingNewAddressAndUpdatingEmployee() throws IOException {
        System.out.println("Enter employee last name:");
        String lastName = bufferedReader.readLine();

        Employee employee = entityManager
                .createQuery("SELECT e FROM Employee e " +
                        "WHERE e.lastName = :l_name", Employee.class)
                .setParameter("l_name", lastName)
                .getSingleResult();

        Address address = createNewAddress("Vitoshka 15");

        entityManager.getTransaction().begin();
        employee.setAddress(address);
        entityManager.getTransaction().commit();
    }

    private Address createNewAddress(String newAddressText) {
        Address address = new Address();
        address.setText(newAddressText);

        entityManager.getTransaction().begin();
        entityManager.persist(address);
        entityManager.getTransaction().commit();

        return address;
    }

    private void exerciseFiveEmployeesFromDepartment() {
        entityManager
                .createQuery("SELECT e FROM Employee  e " +
                        "WHERE e.department.name = :d_name " +
                        "ORDER BY e.salary, e.id", Employee.class)
                .setParameter("d_name", "Research and Development")
                .getResultStream()
                .forEach(e -> System.out.printf("%s %s from %s - $%.2f%n",
                        e.getFirstName(),
                        e.getLastName(),
                        e.getDepartment().getName(),
                        e.getSalary()));
    }

    private void exerciseFourEmployeesWithSalaryOver50000() {

        entityManager.
                createQuery("SELECT e FROM Employee e " +
                        "WHERE e.salary > :minimum_salary ", Employee.class)
                .setParameter("minimum_salary", BigDecimal.valueOf(50000L))
                .getResultStream()
                .map(Employee::getFirstName)
                .forEach(System.out::println);
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
