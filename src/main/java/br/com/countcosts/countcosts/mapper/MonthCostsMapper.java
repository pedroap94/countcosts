package br.com.countcosts.countcosts.mapper;

import br.com.countcosts.countcosts.domain.MonthCosts;
import br.com.countcosts.countcosts.dto.MonthCostsRequest;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
abstract class MonthCostsMapper {

    public static final MonthCostsMapper INSTANCE = Mappers.getMapper(MonthCostsMapper.class);

    public abstract MonthCosts toMonthCosts(MonthCostsRequest monthCostsRequest);

}
