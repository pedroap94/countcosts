package br.com.countcosts.countcosts.service;

import br.com.countcosts.countcosts.domain.MonthCosts;
import br.com.countcosts.countcosts.dto.MonthCostsRequest;
import br.com.countcosts.countcosts.repository.MonthCostsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;


@Service
@RequiredArgsConstructor
public class MonthCostsService {
    private final MonthCostsRepository monthCostsRepository;

    public Map<String,Double> findValueByMonthAndYear(Integer month, Integer year) {
        LocalDate date = LocalDate.now();
        Integer monthLocal;
        Integer yearLocal;

        monthLocal = Objects.requireNonNullElseGet(month, () -> date.getMonth().getValue());
        yearLocal = Objects.requireNonNullElseGet(year, date::getYear);

        Map<String, Double> response = new HashMap<>();
        for(MonthCosts monthCostsResponses : monthCostsRepository.findByMonthAndYear(monthLocal, yearLocal)){
            response.put(monthCostsResponses.getType(), monthCostsResponses.getTotalvalue());
        }
        return response;
    }

    public void replace(MonthCostsRequest monthCostsRequest){
        List<MonthCosts> meet = monthCostsRepository.findByMonthAndYear(monthCostsRequest.getMonth(), monthCostsRequest.getYear());
        if (!meet.isEmpty()){
            Long idMeet = meet.get(0).getId();
        }
        MonthCosts monthCosts = MonthCostsMap
    }

}
