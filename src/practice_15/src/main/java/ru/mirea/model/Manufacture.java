package ru.mirea.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = "manufactures")
@Getter
@Setter
public class Manufacture {
    @Id
    @Column(name = "id")
    @SequenceGenerator(name = "manufacturesIdSeq", sequenceName = "manufactures_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "manufacturesIdSeq")
    private int id;

    @Column(name = "name")
    private String name;

    @ManyToOne()
    @JoinColumn(name = "worker_id", nullable = false)
    private Worker worker;
}
