package com.enterprise.resale.repository;

import com.enterprise.resale.model.Reserva;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.time.LocalTime;

public interface ReservaRepository extends JpaRepository<Reserva, Long> {

    @Query("""
        SELECT CASE WHEN COUNT(r) > 0 THEN true ELSE false END
        FROM Reserva r
        WHERE r.salaId = :salaId
        AND r.data = :data
        AND r.status = 'ATIVA'
        AND (
            (:inicio BETWEEN r.horaInicio AND r.horaFim)
            OR (:fim BETWEEN r.horaInicio AND r.horaFim)
        )
    """)
    boolean existsConflito(@Param("salaId") Long salaId,
                           @Param("data") LocalDate data,
                           @Param("inicio") LocalTime inicio,
                           @Param("fim") LocalTime fim);
}