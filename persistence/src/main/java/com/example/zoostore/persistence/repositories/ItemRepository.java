package com.example.zoostore.persistence.repositories;

import com.example.zoostore.persistence.entities.Item;
import com.example.zoostore.persistence.entities.Tag;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface ItemRepository extends JpaRepository<Item, UUID> {
    Page<Item> findAllByisArchivedAndTagsContaining(Boolean archived, Tag tag, Pageable page);
}