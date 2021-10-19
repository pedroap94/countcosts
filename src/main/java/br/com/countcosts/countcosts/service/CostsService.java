package br.com.countcosts.countcosts.service;

import br.com.countcosts.countcosts.domain.Costs;
import br.com.countcosts.countcosts.dto.CostsRequest;
import br.com.countcosts.countcosts.dto.CostsResponse;
import br.com.countcosts.countcosts.mapper.CostsMapper;
import br.com.countcosts.countcosts.repository.CostsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    public List<CostsResponse> findAllByType(Integer month, Integer year) {
        //utilizando map para se precisar no futuro adicionar mais types não quebrar o método
        Map<String, Double> map = new HashMap<>();
        List<CostsResponse> response = new ArrayList<>();
        for (Costs costs : costsRepository.findByMonthAndYear(month, year)){
            if (!map.containsKey(costs.getType())){
                map.put(costs.getType(), costs.getValue());
            } else {
                Double val = map.get(costs.getType());
                val += costs.getValue();
                map.put(costs.getType(), val);
            }
        }
        for (String key : map.keySet()){
            CostsResponse costsResponse = new CostsResponse();
            costsResponse.setType(key);
            costsResponse.setValue(map.get(key));
            response.add(costsResponse);
        }
        return response;
    }
}