package org.example.controllers;

import org.example.dto.StatsResponse;
import org.example.services.StatsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "/stats/")
public class StatsController {

    @Autowired
    private StatsService statsService;

    @GetMapping
    public StatsResponse getStats(){
        return statsService.getStats();
    }

}
