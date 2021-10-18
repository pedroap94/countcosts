package br.com.countcosts.countcosts.service;

import br.com.countcosts.countcosts.domain.Costs;
import br.com.countcosts.countcosts.dto.CostsRequest;
import br.com.countcosts.countcosts.dto.CostsResponse;
import br.com.countcosts.countcosts.mapper.CostsMapper;
import br.com.countcosts.countcosts.repository.CostsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CostsService {
    private final CostsRepository costsRepository;

    public List<Costs> listAll() {
        return costsRepository.findAll();
    }

    public Costs save(CostsRequest costs) {
        return costsRepository.save(CostsMapper.INSTANCE.toCosts(costs));
    }

    public List<CostsResponse> findByType(Integer month, Integer year) {
        List<CostsResponse> response = new ArrayList<>();
        for (Costs costs : costsRepository.findByMonthAndYear(month, year)) {
            CostsResponse costsResponse = CostsMapper.INSTANCE.toCostsResponse(costs);
            response.add(costsResponse);
        }
        return response;
    }

}