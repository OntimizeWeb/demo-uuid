package com.imatia.implatform.prototypen.ws.core.rest;

import com.imatia.implatform.prototypen.api.core.service.ILocationsService;
import com.ontimize.jee.server.rest.ORestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/locations")
@ComponentScan(basePackageClasses={com.imatia.implatform.prototypen.api.core.service.ILocationsService.class})
public class LocationsController extends ORestController<ILocationsService> {

    private final ILocationsService locationsService;

    @Autowired
    LocationsController(ILocationsService locationsService) {
        this.locationsService = locationsService;
    }

    @Override
    public ILocationsService getService() {
        return this.locationsService;
    }
}
