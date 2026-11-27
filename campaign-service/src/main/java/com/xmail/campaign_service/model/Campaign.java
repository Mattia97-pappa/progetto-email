package com.xmail.campaign_service.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.objenesis.instantiator.annotations.Typology;

import java.time.LocalDate;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "advertising_campaign")
public class Campaign {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "advertising_id")
    private Integer id;

    @Column(name = "advertising_uuid", nullable = false, unique = true)
    private UUID campaignUuid;

    @ManyToOne
    @JoinColumn(name = "advertising_campaign_type")
    private Typology typology;

    @Column(name = "advertising_campaign_name", length = 150)
    private String name;

    @Column(name = "advertising_campaign_desc")
    private String description;

    @Column(name = "advertising_campaign_start")
    private LocalDate startDate;

    @Column(name = "advertising_campaign_end")
    private LocalDate endDate;


}
