package com.desenvolvimento.nivelamento.repository;

import com.desenvolvimento.nivelamento.model.Guest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GuestRepository extends JpaRepository<Guest, Long> {
}
