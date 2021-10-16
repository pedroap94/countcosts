package br.com.countcosts.countcosts.dto;

import lombok.Data;

@Data
public class MonthCostsRequest {
    private Integer month;
    private Integer year;
    private String type;
    private double totalvalue;
}
