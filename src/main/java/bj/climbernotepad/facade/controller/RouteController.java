package bj.climbernotepad.facade.controller;

import bj.climbernotepad.business.Route;
import bj.climbernotepad.business.RouteService;
import bj.climbernotepad.facade.RouteDTO;
import bj.climbernotepad.facade.converter.RouteConverter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
@RequestMapping("/routes")
@Slf4j
public class RouteController {

    private final RouteService routeService;

    @Autowired
    public RouteController(RouteService routeService) {
        this.routeService = routeService;
    }

    @RequestMapping(method = POST)
    public RouteDTO add(@RequestBody RouteDTO routeDTO) {
        log.info("Adding new route: " + routeDTO);
        Route route = RouteConverter.INSTANCE.fromDto(routeDTO);
        Route savedRoute = routeService.save(route);
        return RouteConverter.INSTANCE.fromBO(savedRoute);
    }
}
