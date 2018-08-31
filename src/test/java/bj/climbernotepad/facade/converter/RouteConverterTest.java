package bj.climbernotepad.facade.converter;

import bj.climbernotepad.business.Route;
import bj.climbernotepad.facade.RouteDTO;
import org.junit.Test;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;

public class RouteConverterTest {

    @Test
    public void shouldConvertRouteDTO() {
        RouteDTO routeDTO = new RouteDTO("Znikajacy punkt", "7a+/7b", "Sokoliki", "Sukiennice", LocalDate.now());

        Route route = RouteConverter.INSTANCE.fromDto(routeDTO);

        assertThat(route).isEqualToComparingOnlyGivenFields
                (routeDTO, "name", "level", "region", "crag", "finished");
    }

    @Test
    public void shouldConvertRoute() {
        Route route = new Route("Znikajacy punkt", "7a+/7b", "Sokoliki", "Sukiennice", LocalDate.now());

        RouteDTO routeDto = RouteConverter.INSTANCE.fromBO(route);

        assertThat(routeDto).isEqualToComparingOnlyGivenFields
                (route, "name", "level", "region", "crag", "finished");
    }
}