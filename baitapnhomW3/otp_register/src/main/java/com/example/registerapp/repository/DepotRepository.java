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

    // Tìm các Depot có tổng số lượng bán cao nhất, nhóm theo Depot và InfoDetail, sắp xếp theo tổng số lượng bán giảm dần
    @Query("SELECT d FROM Depot d JOIN d.saleHistories s JOIN s.infoDetail i " +
           "GROUP BY d.id, i.id " +  // Nhóm theo cả Depot và InfoDetail
           "ORDER BY SUM(s.totalSold) DESC")
    List<Depot> findTopByQuantitySold(Pageable pageable);

    // Tìm các Depot được nhập gần đây hơn một ngày cụ thể, sắp xếp theo ngày nhập giảm dần
    @Query("SELECT d FROM Depot d WHERE d.importDate >= :DaysAgo ORDER BY d.importDate DESC")
    List<Depot> findTopByRecentCreation(@Param("DaysAgo") LocalDate DaysAgo, Pageable pageable);
}
