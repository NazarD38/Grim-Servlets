package org.diduk.Models;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
@Table(name = "Creature")
public class Creature {

    @Id
    @GeneratedValue
    private int id;

    @ManyToOne
    @JoinColumn(name = "person_id",referencedColumnName = "id",nullable = false)
    private Person person;

    @ManyToOne
    @JoinColumn(name = "danger_level",referencedColumnName = "id",nullable = false)
    private DangerLevel dangerLevel;

    @Column(name = "type",nullable = false)
    private String type;

    @Column(name="country",nullable = false)
    private String country;

}
