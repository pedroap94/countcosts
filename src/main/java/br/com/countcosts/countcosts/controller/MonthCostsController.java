package br.com.countcosts.countcosts.controller;

import br.com.countcosts.countcosts.domain.MonthCosts;
import br.com.countcosts.countcosts.service.MonthCostsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("monthcosts")
@RequiredArgsConstructor
@CrossOrigin
public class MonthCostsController {
    private final MonthCostsService monthCostsService;

    @GetMapping
    public ResponseEntity<List<MonthCosts>> findByMonthAndYear(@RequestParam (required = false) Integer month, @RequestParam (required = false) Integer year){
        return new ResponseEntity<>(monthCostsService.findValueByMonthAndYear(month, year), HttpStatus.OK);
    }
}
