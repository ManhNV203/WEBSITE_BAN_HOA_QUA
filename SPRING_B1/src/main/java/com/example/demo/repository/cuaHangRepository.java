package com.example.demo.repository;
import com.example.demo.domainModel.cuaHang;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;


@Repository
public interface cuaHangRepository extends JpaRepository<cuaHang, UUID> {
}
