package br.com.countcosts.countcosts.controller;

import br.com.countcosts.countcosts.domain.MonthCosts;
import br.com.countcosts.countcosts.dto.MonthCostsRequest;package br.com.countcosts.countcosts.service;

import br.com.countcosts.countcosts.domain.MonthCosts;
import br.com.countcosts.countcosts.dto.MonthCostsRequest;
import br.com.countcosts.countcosts.dto.MonthCostsResponse;
import br.com.countcosts.countcosts.mapper.MonthCostsMapper;
import br.com.countcosts.countcosts.repository.MonthCostsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
@RequiredArgsConstructor
public class MonthCostsService {
    private final MonthCostsRepository monthCostsRepository;

    public List<MonthCostsResponse> findValueByMonthAndYear(Integer month, Integer year) {
        List<MonthCostsResponse> response = new ArrayList<>();
        for (MonthCosts monthCosts : monthCostsRepository.findByMonthAndYear(month, year)) {
            MonthCostsResponse monthCostsResponse = MonthCostsMapper.INSTANCE.toMonthCostsResponse(monthCosts);
            response.add(monthCostsResponse);
        }
        return response;
    }

    public void replaceOrSave(MonthCostsRequest monthCostsRequest) {
        List<MonthCosts> meet = monthCostsRepository.findByMonthAndYearAndType(monthCostsRequest.getMonth(), monthCostsRequest.getYear(), monthCostsRequest.getType());
        if (!meet.isEmpty()) {
            Long idMeet = meet.get(0).getId();
            MonthCosts monthCosts = MonthCostsMapper.INSTANCE.toMonthCosts(monthCostsRequest);
            monthCosts.setId(idMeet);
            monthCostsRepository.save(monthCosts);
        } else {
            MonthCosts monthCosts = MonthCostsMapper.INSTANCE.toMonthCosts(monthCostsRequest);
            monthCostsRepository.save(monthCosts);
        }
    }
}

import br.com.countcosts.countcosts.dto.MonthCostsResponse;
import br.com.countcosts.countcosts.service.MonthCostsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/v1/monthcosts")
@RequiredArgsConstructor
@CrossOrigin
public class MonthCostsController {
    private final MonthCostsService monthCostsService;

    @GetMapping
    public ResponseEntity<List<MonthCostsResponse>> findValuesByMonthAndYear(@RequestParam @Valid Integer month, @RequestParam @Valid Integer year) {
        return new ResponseEntity<>(monthCostsService.findValueByMonthAndYear(month, year), HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<Void> save(@RequestBody @Valid MonthCostsRequest monthCostsRequest) {
        monthCostsService.replaceOrSave(monthCostsRequest);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
