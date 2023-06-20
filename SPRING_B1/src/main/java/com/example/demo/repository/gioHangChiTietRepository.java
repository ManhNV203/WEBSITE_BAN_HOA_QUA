package com.example.demo.repository;

import com.example.demo.domainModel.gioHangChiTiet;
import com.example.demo.domainModel.gioHangChiTietId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface gioHangChiTietRepository extends JpaRepository<gioHangChiTiet, gioHangChiTietId> {
}