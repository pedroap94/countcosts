package br.com.countcosts.countcosts.repository;

import br.com.countcosts.countcosts.domain.MonthCosts;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MonthCostsRepository extends JpaRepository<MonthCosts, Long> {

    List<MonthCosts> findByMonthAndYear(Integer month, Integer year);
}
