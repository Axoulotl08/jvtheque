package com.axoulotl.jvtheque.model.dto.input;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

@Getter
@Setter
@ToString
public class ConsoleDTO {
    private String name;
    private LocalDate launchDate;
    private String manufacturer;
}
