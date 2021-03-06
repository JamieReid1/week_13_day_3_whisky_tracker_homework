package com.codeclan.example.WhiskyTracker.controllers;

import com.codeclan.example.WhiskyTracker.models.Whisky;
import com.codeclan.example.WhiskyTracker.repositories.WhiskyRepository.WhiskyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/whiskies")
public class WhiskyController {

    @Autowired
    WhiskyRepository whiskyRepository;

    @GetMapping("/year/{year}")
    public List<Whisky> getAllWhiskiesByYear(@PathVariable int year){
        return whiskyRepository.getWhiskiesByYear(year);
    }

    @GetMapping("/distillery/{distillery_id}/age/{age}")
    public List<Whisky> getAllWhiskiesFromDistilleryWithAge(@PathVariable Long distillery_id, @PathVariable int age){
        return whiskyRepository.findWhiskiesFromDistilleryWithAge(distillery_id, age);
    }

    @GetMapping("/region/{region}")
    public List<Whisky> getAllWhiskiesByRegion(@PathVariable String region){
        return whiskyRepository.findWhiskiesByRegion(region);
    }


}
