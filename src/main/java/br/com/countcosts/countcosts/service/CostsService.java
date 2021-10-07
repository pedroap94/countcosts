package br.com.countcosts.countcosts.service;

import br.com.countcosts.countcosts.domain.Costs;
import br.com.countcosts.countcosts.repository.CostsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CostsService {
    private final CostsRepository costsRepository;

    public List<Costs> listAll() {
        return costsRepository.findAll();
    }

    public Costs save(Costs costs){
        return costsRepository.save(Costs.builder()
                        .id(costs.getId())
                        .date(costs.getDate())
                        .value(costs.getValue())
                        .build());
    }

    public Integer total(Integer month, Integer year) {
        int sum;
        List<Integer> values = costsRepository.findByMonth(month, year);
        sum = values.stream().mapToInt(n -> n).sum();
        return sum;
    }
}