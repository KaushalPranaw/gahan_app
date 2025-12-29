package com.gahan.gahan_app.repository;

import com.gahan.gahan_app.entity.Gahan;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GahanRepository extends JpaRepository<Gahan, Long> {
}