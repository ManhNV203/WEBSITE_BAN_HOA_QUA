package com.example.demo.repository;

import com.example.demo.domainModel.khachHang;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface khachHangRepository extends JpaRepository<khachHang, UUID> {
}
