package com.awapi.controller;

import com.awapi.model.Shipwreck;
import com.awapi.repository.ShipwreckRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/v1/")
public class ShipwreckController {

    @Autowired
    private ShipwreckRepository _shipwreckRepository;

    @RequestMapping(value="shipwrecks", method= RequestMethod.GET)
    public List<Shipwreck> list() {
        return _shipwreckRepository.findAll();
    }

    @RequestMapping(value="shipwrecks/{id}", method=RequestMethod.GET)
    public Shipwreck get (@PathVariable long id) {
        return _shipwreckRepository.findOne(id);
    }

    @RequestMapping(value="shipwrecks/{id}", method = RequestMethod.PUT)
    public Shipwreck update (@PathVariable long id, @RequestBody Shipwreck shipwreck) {
        Shipwreck existing = _shipwreckRepository.findOne(id);
        BeanUtils.copyProperties(shipwreck, existing);

        return _shipwreckRepository.saveAndFlush(existing);
    }

    @RequestMapping(value="shipwrecks", method=RequestMethod.POST)
    public Shipwreck create (@RequestBody Shipwreck shipwreck) {
        return _shipwreckRepository.saveAndFlush(shipwreck);
    }

    @RequestMapping(value = "shipwrecks/{id}", method=RequestMethod.DELETE)
    public Shipwreck delete (@PathVariable long id) {
        Shipwreck existing = _shipwreckRepository.findOne(id);
        _shipwreckRepository.delete(id);

        return existing;
    }
}
