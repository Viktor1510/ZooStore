package com.example.zoostore.repositories;

import com.example.zoostore.models.Item;
import com.example.zoostore.models.Vendor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface ItemRepository extends JpaRepository<Item, UUID> {
    @Override
    Optional<Item> findById(UUID uuid);

}