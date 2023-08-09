package com.example.zoostore.persistence.repositories;

import com.example.zoostore.persistence.entities.Multimedia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface MultimediaRepository extends JpaRepository<Multimedia, UUID> {
    @Override
    Optional<Multimedia> findById(UUID uuid);
}