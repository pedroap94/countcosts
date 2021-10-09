package br.com.countcosts.countcosts.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class CostsRequest {
    private int id;
    private Double value;
    private LocalDate date;
    private String type;
}
