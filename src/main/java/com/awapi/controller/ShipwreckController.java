package com.awapi.controller;

import com.awapi.model.Shipwreck;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by yesiome on 8/30/2016.
 */

@RestController
@RequestMapping("/api/v1/")
public class ShipwreckController {

    @RequestMapping(value="shipwrecks", method= RequestMethod.GET)
    public List<Shipwreck> list() {
        return ShipwreckStub.list();
    }

    @RequestMapping(value="shipwrecks/{id}", method=RequestMethod.GET)
    public Shipwreck get (@PathVariable long id) {
        return ShipwreckStub.get(id);
    }

    @RequestMapping(value="shipwrecks/{id}", method = RequestMethod.PUT)
    public Shipwreck update (@PathVariable long id, @RequestBody Shipwreck shipwreck) {
        return ShipwreckStub.update(id, shipwreck);
    }

    @RequestMapping(value = "shipwrecks/{id}", method=RequestMethod.DELETE)
    public Shipwreck delete (@PathVariable long id) {
        return ShipwreckStub.delete(id);

    }
}
