package br.com.countcosts.countcosts.service;

import br.com.countcosts.countcosts.domain.Costs;
import br.com.countcosts.countcosts.dto.CostsRequest;
import br.com.countcosts.countcosts.mapper.CostsMapper;
import br.com.countcosts.countcosts.repository.CostsRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@ExtendWith(SpringExtension.class)
class CostsServiceTest {

    @InjectMocks
    private CostsService costsService;

    @Mock
    private CostsRepository costsRepository;

    @Test
    @DisplayName("CostsService retornando lista com todos os objetos Costs disponíveis no banco")
    void get_void_returnListAllCosts() {
        //Scenario preparation
        List<Costs> list = new ArrayList<>();
        list.add(Costs.builder()
                .date(LocalDate.now())
                .id(1)
                .value(120.0)
                .type("U")
                .build());
        list.add(Costs.builder()
                .date(LocalDate.now())
                .id(2)
                .value(120.0)
                .type("M")
                .build());
        //Execution
        BDDMockito.when(costsRepository.findAll()).thenReturn(list);
        List<Costs> costsReturned = costsService.listAll();

        //Verification
        Assertions.assertThat(costsReturned).isEqualTo(list);
    }

    @Test
    @DisplayName("CostsService salvando um objeto Costs no repositório")
    void post_CostRequest_void() {
        //Scenario preparation
        CostsRequest costsRequest = new CostsRequest();
        costsRequest.setDate(LocalDate.now());
        costsRequest.setType("U");
        costsRequest.setValue(15.0);
        Costs costs = new Costs();
        costs.setId(0);
        costs.setDate(costsRequest.getDate());
        costs.setType(costsRequest.getType());
        costs.setValue(costsRequest.getValue());

        //Execution
        BDDMockito.when(costsRepository.save(CostsMapper.INSTANCE.toCosts(costsRequest))).thenReturn(costs);
        Costs costsReturned = costsService.save(costsRequest);

        //Verification
        Assertions.assertThat(costsReturned).isEqualTo(costs);
    }

//    @Test
//    @DisplayName("CostsService retornando o valor total")
//    void get_monthAndYear_returnIntegerTotalValue() {
//        //Scenario preparation
//        List<Costs> list = new ArrayList<>();
//        list.add(Costs.builder()
//                .date(LocalDate.now())
//                .id(1)
//                .value(120.0)
//                .type("U")
//                .build());
//        list.add(Costs.builder()
//                .date(LocalDate.now())
//                .id(2)
//                .value(120.0)
//                .type("M")
//                .build());
//        List<Double> values = new ArrayList<>();
//        for (Costs costsList : list) {
//            values.add(costsList.getValue());
//        }
//
//
//        //Execution
//        BDDMockito.when(costsRepository.findByMonthAndYear(LocalDate.now().getMonth().getValue(), LocalDate.now().getYear())).thenReturn(values);
//        Double totalReturned = costsService.total(LocalDate.now().getMonth().getValue(), LocalDate.now().getYear());
//
//        //Verification
//        Assertions.assertThat(totalReturned).isEqualTo(values.stream().mapToDouble(i -> i).sum());
//    }
}