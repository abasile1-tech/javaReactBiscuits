package com.example.javaBiscuitsAPI.repositories;

import com.example.javaBiscuitsAPI.models.Biscuit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BiscuitRepository extends JpaRepository<Biscuit, Long> {
}
