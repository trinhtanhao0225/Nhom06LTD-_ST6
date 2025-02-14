package com.example.registerapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.registerapp.entity.Depot;
import com.example.registerapp.repository.DepotRepository;

import java.time.LocalDate;
import java.util.List;

@Service
public class DepotService {
    @Autowired
    private DepotRepository depotRepository;

    public List<Depot> findTopByQuantitySold(int top) {
        Pageable pageable = PageRequest.of(0, top);
        List<Depot> topSellingProducts = depotRepository.findTopByQuantitySold(pageable);
        return topSellingProducts;
    }

    public List<Depot> findTopByRecentCreation(int day, int top) {
        LocalDate DaysAgo = LocalDate.now().minusDays(day);
        Pageable pageable = PageRequest.of(0, top);
        List<Depot> recentProducts = depotRepository.findTopByRecentCreation(DaysAgo, pageable);

        return recentProducts;
    }
}
