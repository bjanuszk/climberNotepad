package bj.climbernotepad.facade.converter;

import bj.climbernotepad.business.Route;
import bj.climbernotepad.facade.RouteDTO;
import org.junit.Test;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;

public class RouteConverterTest {

    @Test
    public void shouldConvertRoute() {
        String name = "Znikajacy punkt";
        String level = "7a+/7b";
        String region = "Sokoliki";
        String crag = "Sukiennice";
        LocalDate finished = LocalDate.now();
        RouteDTO routeDTO = new RouteDTO(name, level, region, crag, finished);

        Route route = RouteConverter.INSTANCE.fromDto(routeDTO);

        assertThat(route).isEqualToComparingOnlyGivenFields
                (routeDTO, "name", "level", "region", "crag", "finished");
    }

}