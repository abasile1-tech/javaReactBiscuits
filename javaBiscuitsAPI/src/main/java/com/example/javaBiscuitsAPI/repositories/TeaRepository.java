package com.example.javaBiscuitsAPI.repositories;

import com.example.javaBiscuitsAPI.models.Tea;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeaRepository extends JpaRepository<Tea, Long> {
}
