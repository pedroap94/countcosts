package br.com.countcosts.countcosts.mapper;

import br.com.countcosts.countcosts.domain.MonthCosts;
import br.com.countcosts.countcosts.dto.MonthCostsRequest;
import br.com.countcosts.countcosts.dto.MonthCostsResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public abstract class MonthCostsMapper {

    public static final MonthCostsMapper INSTANCE = Mappers.getMapper(MonthCostsMapper.class);

    @Mapping(target = "totalvalue", source = "totalValue")
    public abstract MonthCosts toMonthCosts(MonthCostsRequest monthCostsRequest);

    @Mapping(target = "type", source = "type")
    @Mapping(target = "totalValue", source = "totalvalue")
    public abstract MonthCostsResponse toMonthCostsResponse(MonthCosts monthCosts);

}
