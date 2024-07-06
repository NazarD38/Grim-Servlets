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
@Table(name = "DangerLevel")
public class DangerLevel {

    @Id
    @GeneratedValue
    private int id;

    @Column(name = "description")
    private String description;
}
