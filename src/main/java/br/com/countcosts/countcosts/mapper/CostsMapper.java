package br.com.countcosts.countcosts.mapper;

import br.com.countcosts.countcosts.domain.Costs;
import br.com.countcosts.countcosts.dto.CostsRequest;
import br.com.countcosts.countcosts.dto.CostsResponse;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public abstract class   CostsMapper {

    public static final CostsMapper INSTANCE= Mappers.getMapper(CostsMapper.class);
    public abstract Costs toCosts(CostsRequest costsRequest);
    public abstract Costs toCosts(CostsResponse costsResponse);

}
