package com.scosm.repository;

import com.scosm.model.Zone;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ZoneRepository extends JpaRepository<Zone, Long> {
    Zone getByName(String name);
}
