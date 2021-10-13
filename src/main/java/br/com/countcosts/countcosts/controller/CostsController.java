package br.com.countcosts.countcosts.controller;

import br.com.countcosts.countcosts.domain.Costs;
import br.com.countcosts.countcosts.dto.CostsRequest;
import br.com.countcosts.countcosts.service.CostsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("costs")
@RequiredArgsConstructor
@CrossOrigin
public class CostsController {
    private final CostsService costsService;

    @GetMapping
    public ResponseEntity<List<Costs>> list() {
        return new ResponseEntity<>(costsService.listAll(), HttpStatus.OK);
    }

    @GetMapping(path = "total")
    public ResponseEntity<Double> sumAllValues(@RequestParam(required = true) Integer month, @RequestParam(defaultValue = "2021") Integer year) {
        return new ResponseEntity<>(costsService.total(month, year), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Costs> save(@RequestBody @Valid CostsRequest costs){
        return new ResponseEntity<>(costsService.save(costs), HttpStatus.CREATED);
    }
}
