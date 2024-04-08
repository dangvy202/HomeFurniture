package com.furniture.hms.entity;

import com.furniture.hms.enums.ProcessEnum;
import jakarta.persistence.*;
import lombok.*;

import java.time.Instant;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "contact_history")
@Entity
@Builder
public class ContactHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_history")
    private int id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_client" , referencedColumnName = "id_client")
    private InformationContactClient informationContactClient;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_description" , referencedColumnName = "id_description")
    private ContactDescription contactDescription;

    @Column(name = "process")
    @Enumerated(EnumType.STRING)
    private ProcessEnum process;

    @Column(name = "message")
    private String message;

    @Column(name = "create_by")
    private String createBy;

    @Column(name = "create_date")
    private Instant createDate;

    @Column(name = "update_by")
    private String updateBy;

    @Column(name = "update_date")
    private Instant updateDate;
}
