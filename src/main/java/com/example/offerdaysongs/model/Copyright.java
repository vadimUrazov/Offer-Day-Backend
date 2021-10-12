package com.example.offerdaysongs.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Copyright {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id", insertable = false, updatable = false)
    TimeValidate timeValidate;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id", insertable = false, updatable = false)
    Company company;

    Integer pay;



}
