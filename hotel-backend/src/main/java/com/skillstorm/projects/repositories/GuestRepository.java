package com.skillstorm.projects.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.skillstorm.projects.models.Guest;

public interface GuestRepository extends JpaRepository<Guest, Long>{

}
