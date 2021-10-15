package br.com.countcosts.countcosts.repository;

import br.com.countcosts.countcosts.domain.MonthCosts;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MonthCostsRepository extends JpaRepository<MonthCosts, Long> {
}
