package com.example.demo.repository;

import com.example.demo.domainModel.dongSP;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface dongSPRepository extends JpaRepository<dongSP, UUID> {
}
