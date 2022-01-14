package com.raf.emailservice.repository;

import com.raf.emailservice.domain.Tip;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TipRepository extends JpaRepository<Tip, String> {

    Optional<Tip> findByName(String name);
}
