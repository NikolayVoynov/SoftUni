import entities.Address;
import entities.Employee;
import entities.Project;
import entities.Town;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.time.format.DateTimeFormatter;
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
                case 8 -> exerciseEightGetEmployeeWithProject();
                case 9 -> exerciseNineFindLatest10Projects();
                case 10 -> exerciseTenIncreaseSalaries();
                case 11 -> exerciseElevenFindEmployeesByFirstName();
                case 12 -> exerciseTwelveEmployeesMaximumSalaries();
                case 13 -> exerciseThirteenRemoveTowns();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            entityManager.close();
        }
    }

    private void exerciseThirteenRemoveTowns() throws IOException {
        System.out.println("Enter town name:");
        String townName = bufferedReader.readLine();

        Town town = entityManager
                .createQuery("SELECT t FROM Town t " +
                        "WHERE t.name = :t_name", Town.class)
                .setParameter("t_name", townName)
                .getSingleResult();


        List<Address> addresses = entityManager
                .createQuery("SELECT a FROM Address a " +
                        "WHERE a.town.id = :t_id", Address.class)
                .setParameter("t_id",town.getId())
                .getResultList();

        entityManager.createQuery("SELECT e FROM Employee e " +
                "WHERE e.address.town.name = :town_name", Employee.class)
                .setParameter("town_name", townName)
                .getResultStream()
                .forEach(e -> e.setAddress(null));

        System.out.printf("%d addresses in %s deleted", addresses.size(), townName);
    }

    private void exerciseElevenFindEmployeesByFirstName() throws IOException {
        System.out.println("Enter pattern for first name of employee:");
        String pattern = bufferedReader.readLine();
        String resultPattern = pattern + "%";

        List<Employee> listEmployeesByPattern = entityManager
                .createQuery("SELECT e FROM Employee e " +
                        "WHERE e.firstName LIKE :n_pattern", Employee.class)
                        .setParameter("n_pattern", resultPattern)
                .getResultList();

        for (Employee employee : listEmployeesByPattern) {
            System.out.printf("%s %s - %s - ($%.2f)%n",
                    employee.getFirstName(), employee.getLastName(), employee.getJobTitle(), employee.getSalary());
        }
    }

    private void exerciseNineFindLatest10Projects() {
        List<Project> projectList =
                entityManager
                .createQuery("SELECT p FROM Project p " +
                        "ORDER BY p.startDate DESC, p.name", Project.class)
                        .setMaxResults(10)
                .getResultList();

        StringBuilder resultList10Projects = new StringBuilder();
        for (Project project : projectList) {
            resultList10Projects
                    .append(String.format("Project name: %s", project.getName()))
                    .append(System.lineSeparator())
                    .append(String.format("       Project Description: %s", project.getDescription()))
                    .append(System.lineSeparator())
                    .append(String.format("       Project Start Date: %s",  project.getStartDate()
                            .format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.s"))))
                    .append(System.lineSeparator())
                    .append(String.format("       Project End Date: %s",project.getEndDate()))
                    .append(System.lineSeparator());
        }

        System.out.print(resultList10Projects.toString().trim());
    }

    @SuppressWarnings("unchecked")
    private void exerciseEightGetEmployeeWithProject() throws IOException {
        System.out.println("Enter employee id:");
        int idEmployee = Integer.parseInt(bufferedReader.readLine());

        Employee employee =
                entityManager
                .createQuery("SELECT e FROM Employee e " +
                        "WHERE e.id = :e_id", Employee.class)
                .setParameter("e_id", idEmployee)
                .getSingleResult();

       List<String> list = entityManager
               .createNativeQuery("SELECT p.name FROM projects p " +
                       "JOIN employees_projects ep on p.project_id = ep.project_id " +
                       "WHERE employee_id = :e_id " +
                       "ORDER BY p.name ASC")
               .setParameter("e_id", idEmployee)
               .getResultList();


        System.out.printf("%s %s - %s%n", employee.getFirstName(), employee.getLastName(), employee.getJobTitle());

        for (String s : list) {
            System.out.printf("      %s%n", s);
        }

    }

    @SuppressWarnings("unchecked")
    private void exerciseTwelveEmployeesMaximumSalaries() {
        List<Object[]> listOfDeptMaxSalary =
                entityManager.
                        createNativeQuery("SELECT d.name, MAX(e.salary) AS `m_salary` FROM departments d " +
                                "JOIN employees e on d.department_id = e.department_id " +
                                "GROUP BY d.name " +
                                "HAVING m_salary NOT BETWEEN 30000 AND 70000;")
                .getResultList();

        listOfDeptMaxSalary.forEach(objects -> {
            System.out.printf("%s %s%n", objects[0],objects[1]);
        });

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
