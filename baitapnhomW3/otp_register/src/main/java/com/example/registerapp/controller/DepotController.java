package com.example.registerapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.registerapp.entity.Depot;
import com.example.registerapp.service.DepotService;



@RestController
public class DepotController {

    @Autowired
    private DepotService depotService;
    
    @GetMapping("/topByQuantitySold")
    public ResponseEntity<List<Depot>> getTopByQuantitySold(@RequestParam int top) {
        return new ResponseEntity<>(depotService.findTopByQuantitySold(top), HttpStatus.OK);
    }
    
    @GetMapping("/topByRecentCreation")
    public ResponseEntity<List<Depot>> getTopByRecentCreation(@RequestParam int day, @RequestParam int top) {
        return new ResponseEntity<>(depotService.findTopByRecentCreation(day, top), HttpStatus.OK);
    }
}

