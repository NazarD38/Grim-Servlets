package org.diduk.Models;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
@Table(name="person")
public class Person {

    @Id
    @GeneratedValue
    private int id;

    @Column(name = "name",nullable = false)
    private String name;

    @Column(name = "surname",nullable = false)
    private String surname;
    @Column(name = "birthday",nullable = false)
    private LocalDate birthday;
    @Column(name = "status",nullable = false)
    private String status;

}
