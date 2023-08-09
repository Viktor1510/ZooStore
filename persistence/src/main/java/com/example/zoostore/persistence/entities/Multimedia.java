package com.example.zoostore.persistence.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@Table(name = "multimedias")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Multimedia {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID multimediaId;
    private String url;

    @ManyToOne
    @JoinColumn(name = "itemId")
    private Item item;


}
