package br.com.countcosts.countcosts.service;

import br.com.countcosts.countcosts.domain.MonthCosts;
import br.com.countcosts.countcosts.repository.MonthCostsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MonthCostsService {
    private final MonthCostsRepository monthCostsRepository;

    public List<MonthCosts> findValueByMonthAndYear(Integer month, Integer year) {
        LocalDate date = LocalDate.now();
        Integer monthLocal;
        Integer yearLocal;

        if (month == null) {
            monthLocal = date.getMonth().getValue();
        } else {
            monthLocal = month;
        }
        if (year == null) {
            yearLocal = date.getYear();
        } else {
            yearLocal = year;
        }

        return monthCostsRepository.findByMonthAndYear(monthLocal, yearLocal);
    }

}
