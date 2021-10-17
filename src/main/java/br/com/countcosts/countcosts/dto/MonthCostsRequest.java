package br.com.countcosts.countcosts.dto;

import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Data
public class MonthCostsRequest {
    @NotNull
    private Integer month;
    @NotNull
    private Integer year;
    @NotNull
    private String type;
    @NotNull
    @Min(0)
    private double totalValue;
}
