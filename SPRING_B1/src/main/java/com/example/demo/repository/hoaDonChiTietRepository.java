package com.example.demo.repository;

import com.example.demo.domainModel.hoaDonChiTIet;
import com.example.demo.domainModel.hoaDonChiTietId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface hoaDonChiTietRepository extends JpaRepository<hoaDonChiTIet, hoaDonChiTietId> {
}