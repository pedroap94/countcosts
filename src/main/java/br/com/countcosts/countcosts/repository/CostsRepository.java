package br.com.countcosts.countcosts.repository;

import br.com.countcosts.countcosts.domain.Costs;
import br.com.countcosts.countcosts.dto.CostsResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CostsRepository extends JpaRepository<Costs, Long> {

    @Query(value = "select * from costs where (extract (month from date) = :month and extract (year from date) = :year)", nativeQuery = true)
    List<Costs> findByMonthAndYear(Integer month, Integer year);
}