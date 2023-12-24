package com.example.tp.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.tp.model.AddressRepository;

@Controller
public class AddressController {

    @Autowired
    AddressRepository addressRepository;

    @GetMapping("/adresses")
    public String showAddresses(Model model) {
        model.addAttribute("allAddresses", addressRepository.findAll());
        return "addresses";
    }

        @GetMapping("/address")
    public String Address(@RequestParam(name = "nameGET", required = true, defaultValue = "World") String nameGET,
            Model model) {
        model.addAttribute("nomTemplate", nameGET);
        return "adress";
    }

}
