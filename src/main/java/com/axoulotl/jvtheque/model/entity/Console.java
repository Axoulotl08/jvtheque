package com.axoulotl.jvtheque.model.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Data
@Getter
@Builder
public class Console {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "console_id")
    private Integer id;

    @Column(unique = true,
            nullable = false,
            name = "console_game"
    )
    private String name;

    @OneToMany(mappedBy = "console")
    @Column(name = "console_games")
    private List<Game> listOfGame;

    @Column(nullable = false,
            name = "console_launch_date"
    )
    private LocalDate launchDate;

    @Column(insertable = false,
            updatable = false,
            nullable = false,
            name = "console_creation_date",
            columnDefinition = "DATETIME default CURRENT_TIMESTAMP"
    )
    private LocalDateTime creationDate;

    @Column(name = "console_manufacturer",
            nullable = false,
            updatable = false)
    private String manufacturer;
}
