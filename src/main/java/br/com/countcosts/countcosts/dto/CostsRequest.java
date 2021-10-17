package br.com.countcosts.countcosts.dto;

import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Data
public class CostsRequest {
    private int id;
    @NotNull
    @Min(0)
    private Double value;
    @NotNull
    private LocalDate date;
    private String type;
}
