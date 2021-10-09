package br.com.countcosts.countcosts.repository;

import br.com.countcosts.countcosts.domain.Costs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CostsRepository extends JpaRepository<Costs, Long> {

    @Query(value = "select value from costs where (extract (month from date) = :month and extract (year from date) = :year)", nativeQuery = true)
    List<Double> findByMonth(Integer month, Integer year);
}