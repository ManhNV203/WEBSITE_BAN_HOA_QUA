package com.example.demo.repository;

import com.example.demo.domainModel.nhaSanXuat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface nhaSanXuanRepository extends JpaRepository<nhaSanXuat, UUID> {
}
