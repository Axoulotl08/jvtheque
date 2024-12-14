package com.axoulotl.jvtheque.model.dto.input;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class GameDTO {
    private String name;
    private Integer console;
    private Boolean inBox;
    private Boolean collector;
    private LocalDate launchDate;
}

