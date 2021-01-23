package com.group.hackethon.controllers;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @RequestMapping(name="/requestcarbonfootprint", method= RequestMethod.POST)
    public void footprint(@RequestBody Object body) {

    }
}
