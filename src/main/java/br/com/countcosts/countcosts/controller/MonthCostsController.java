package br.com.countcosts.countcosts.controller;

import br.com.countcosts.countcosts.dto.MonthCostsRequest;
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
