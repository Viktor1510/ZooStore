package com.example.zoostore.persistence.repositories;

import com.example.zoostore.persistence.entities.Tag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface TagRepository extends JpaRepository<Tag, UUID> {
    @Override
    Optional<Tag> findById(UUID id);

}
