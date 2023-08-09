package com.example.zoostore.persistence.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "vendors")
public class Vendor {
    @Id
    @GeneratedValue(strategy =GenerationType.UUID)
    private UUID vendorId;
    private String name;
    @OneToMany
    private Set<Item> items;

}
