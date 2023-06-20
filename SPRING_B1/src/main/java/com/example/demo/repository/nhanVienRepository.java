package com.example.demo.repository;

import com.example.demo.domainModel.nhanVien;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface nhanVienRepository extends JpaRepository<nhanVien, UUID> {

}
