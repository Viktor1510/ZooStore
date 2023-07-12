package com.example.zoostore.repositories;

import com.example.zoostore.models.Multimedia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface MultimediaRepository extends JpaRepository<Multimedia, UUID> {
    @Override
    Optional<Multimedia> findById(UUID uuid);
}