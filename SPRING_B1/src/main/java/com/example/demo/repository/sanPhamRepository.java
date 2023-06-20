package com.example.demo.repository;

import com.example.demo.domainModel.sanPham;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface sanPhamRepository extends JpaRepository<sanPham, UUID> {
}
