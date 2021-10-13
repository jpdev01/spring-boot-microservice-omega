package com.core.backend.controller;

import com.core.backend.service.NavbarService;
import com.core.components.nav.Navbar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/nav")
public class NavController {

    @Autowired
    private NavbarService navbarService;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<Navbar> get() {
        Navbar navbar = navbarService.getNavbar();
        return new ResponseEntity<Navbar>(navbar, HttpStatus.OK);
    }
}
