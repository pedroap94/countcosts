package br.com.countcosts.countcosts.service;

import br.com.countcosts.countcosts.domain.MonthCosts;
import br.com.countcosts.countcosts.repository.MonthCostsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class MonthCostsService {
    private final MonthCostsRepository monthCostsRepository;

    public List<MonthCosts> findValueByMonthAndYear(Integer month, Integer year) {
        LocalDate date = LocalDate.now();
        Integer monthLocal;
        Integer yearLocal;

        monthLocal = Objects.requireNonNullElseGet(month, () -> date.getMonth().getValue());
        yearLocal = Objects.requireNonNullElseGet(year, date::getYear);

        return monthCostsRepository.findByMonthAndYear(monthLocal, yearLocal);
    }

}
