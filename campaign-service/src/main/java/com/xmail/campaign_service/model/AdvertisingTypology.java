package com.xmail.campaign_service.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "advertising_typology")
public class AdvertisingTypology {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "typology_id")
    private Integer id;

private String typologyName;

private String typologyDescription;


}
