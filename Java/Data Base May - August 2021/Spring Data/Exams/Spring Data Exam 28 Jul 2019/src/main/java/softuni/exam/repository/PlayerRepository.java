package softuni.exam.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import softuni.exam.domain.entities.Player;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface PlayerRepository extends JpaRepository<Player,Long> {


    List<Player> findPlayerByTeamNameOrderById(String team_name);

    List<Player> findAllBySalaryGreaterThanOrderBySalaryDesc(BigDecimal salary);
}
