package br.com.countcosts.countcosts.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class CostsResponse {
    private Double value;
    private String type;
}
