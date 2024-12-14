package com.axoulotl.jvtheque.model.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Data
@Getter
@Setter
@Builder
public class Game {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    @Column(name = "game_id")
    private Integer gameId;

    @Column(
            unique = true,
            nullable = false,
            name = "game_name"
    )
    private String name;

    @ManyToOne
    @JoinColumn(name = "console_id")
    private Console console;

    @Column(
            nullable = false,
            name = "game_launch_date"
    )
    private LocalDate launchDate;

    @Column(
            insertable = false,
            name = "game_modification_date",
            columnDefinition = "DATETIME ON UPDATE CURRENT_TIMESTAMP"
    )
    private LocalDateTime modificationDate;

    @Column(
            insertable = false,
            updatable = false,
            nullable = false,
            name = "game_creation_date",
            columnDefinition = "DATETIME default CURRENT_TIMESTAMP"
    )
    private LocalDateTime creationDate;

    @Column(name = "game_start_date")
    private LocalDate startDate;

    @Column(name = "game_end_date")
    private LocalDate endDate;

    @Column(name = "game_playtime")
    private Long playTime;

    @Column(
            nullable = false,
            name = "game_inbox"
    )
    private Boolean inBox;

    @Column(name = "game_trophy_pct")
    private Integer trophyPct;

    @Column(
            nullable = false,
            name = "game_collector"
    )
    private Boolean collector;
}
