package hiberspring.repository;

import hiberspring.domain.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    @Query("SELECT concat(e.firstName, ' ', e.lastName), e.position AS position, e.card.number FROM Employee e " +
            "WHERE e.branch.id IN (SELECT p.branch.id FROM Product p) " +
    "ORDER BY concat(e.firstName, ' ', e.lastName), length(position) DESC")
    List<Object[]> findEmployeeInBranchWithAtLeastOneProduct();

}
