package com.sogne.repository;

import com.sogne.models.Commune;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommuneRepository extends JpaRepository<Commune,Long> {
}
