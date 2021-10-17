package br.com.countcosts.countcosts.dto;

import lombok.Data;

@Data
public class MonthCostsResponse {
    private String type;
    private double totalValue;
}
