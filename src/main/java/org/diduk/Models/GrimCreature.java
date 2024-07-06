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
    @Table(name = "grim_creature")
    public class GrimCreature {

        @Id
        @GeneratedValue
        private int id;

        @ManyToOne
        @JoinColumn(name="grim_id",referencedColumnName = "id",nullable = false)
        private Grim grim;
        @ManyToOne
        @JoinColumn(name="creature_id",referencedColumnName = "id",nullable = false)
        private Creature creature;

    }
