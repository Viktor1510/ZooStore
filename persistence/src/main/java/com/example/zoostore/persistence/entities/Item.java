package com.example.zoostore.persistence.entities;
import jakarta.persistence.*;
import lombok.*;

import java.util.Set;
import java.util.UUID;

@Getter(AccessLevel.PUBLIC)
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder



@Entity
@Table(name = "item")
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID itemId;
    private String title;
    private String description;

    @ManyToOne
    @JoinColumn(name = "vendorId")
    private Vendor vendor;

    @ManyToMany
    private Set<Tag> tags;

    @OneToMany(mappedBy = "item", cascade = CascadeType.ALL)
    private Set<Multimedia> multimedia;

    private Boolean isArchived;

}