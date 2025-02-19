package com.example.registerapp.repository;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.registerapp.entity.Depot;
import java.time.LocalDate;
import java.util.List;

@Repository
public interface DepotRepository extends JpaRepository<Depot, Integer> {

    @Query("SELECT d FROM Depot d JOIN SaleHistoryDetail shd ON shd.depot = d " +
           "GROUP BY d.id " +  
           "ORDER BY SUM(shd.quantitySold) DESC")
    List<Depot> findTopByQuantitySold(Pageable pageable);

    @Query("SELECT d FROM Depot d WHERE d.importDate >= :DaysAgo ORDER BY d.importDate DESC")
    List<Depot> findTopByRecentCreation(@Param("DaysAgo") LocalDate DaysAgo, Pageable pageable);
}
