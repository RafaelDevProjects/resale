package com.enterprise.resale.repository;

import com.enterprise.resale.model.Sala;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SalaRepository extends JpaRepository<Sala, Long> {
}