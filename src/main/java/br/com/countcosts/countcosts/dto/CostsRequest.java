package br.com.countcosts.countcosts.dto;

import lombok.Data;
import org.springframework.lang.Nullable;

import javax.validation.constraints.Min;
import java.time.LocalDate;

@Data
public class CostsRequest {
    private int id;
    @Nullable
    @Min(0)
    private Double value;
    @Nullable
    private LocalDate date;
    private String type;
}
