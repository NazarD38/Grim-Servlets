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
@Table(name="grim")
public class Grim {

    @Id
    @GeneratedValue
    private int id;

    @ManyToOne
    @JoinColumn(name = "person_id",referencedColumnName = "id",nullable = false)
   private Person person;

    @Column(name = "killed",nullable = false)
    private int  killed;

    @Column(name="country",nullable = false)
    private String country;

}
