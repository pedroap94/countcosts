package br.com.countcosts.countcosts.controller;

import br.com.countcosts.countcosts.domain.MonthCosts;
import br.com.countcosts.countcosts.dto.MonthCostsRequest;
import br.com.countcosts.countcosts.service.MonthCostsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("monthcosts")
@RequiredArgsConstructor
@CrossOrigin
public class MonthCostsController {
    private final MonthCostsService monthCostsService;

    @GetMapping
    public ResponseEntity<Map<String,Double>> findValuesByMonthAndYear(@RequestParam (required = false) Integer month, @RequestParam (required = false) Integer year){
        return new ResponseEntity<Map<String,Double>>(monthCostsService.findValueByMonthAndYear(month, year), HttpStatus.OK);
    }
    
    @PostMapping
    public ResponseEntity<MonthCosts> save(@PathVariable @RequestBody MonthCostsRequest monthCostsRequest){
        monthCostsService.replace(monthCostsRequest);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
