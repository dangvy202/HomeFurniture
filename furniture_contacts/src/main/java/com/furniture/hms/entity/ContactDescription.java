package com.furniture.hms.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.Instant;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "contact_description")
@Entity
@Builder
public class ContactDescription {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_description")
    private Integer id;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "create_date")
    private Instant createDate;
}
