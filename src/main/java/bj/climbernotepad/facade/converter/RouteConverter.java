package bj.climbernotepad.facade.converter;


import bj.climbernotepad.business.Route;
import bj.climbernotepad.facade.RouteDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface RouteConverter {

    RouteConverter INSTANCE = Mappers.getMapper(RouteConverter.class);

    @Mapping(source = "name", target = "name")
    Route fromDto(RouteDTO routeDTO);
}
