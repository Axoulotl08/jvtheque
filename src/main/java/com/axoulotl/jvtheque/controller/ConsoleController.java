package com.axoulotl.jvtheque.controller;

import com.axoulotl.jvtheque.exception.JvthequeStandardError;
import com.axoulotl.jvtheque.model.dto.input.ConsoleDTO;
import com.axoulotl.jvtheque.model.entity.Console;
import com.axoulotl.jvtheque.service.ConsoleService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class ConsoleController {

    ConsoleService consoleService;

    @Autowired
    public ConsoleController(ConsoleService consoleService) {
        this.consoleService = consoleService;
    }

    @Operation(summary = "Add a new console in collection")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Successfully added the console to the collection",
                    content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = Console.class))
                    }),
            @ApiResponse(responseCode = "400",
                    content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = JvthequeStandardError.class))
                    })
    })
    @GetMapping("/console/{id}")
    public ResponseEntity<Object> getConsole(@RequestParam Integer id) {
        try {
            return consoleService.getConsole(id);
        } catch (JvthequeStandardError e) {
            return ResponseEntity.badRequest().body(e);
        }
    }

    @Operation(summary = "Add a new console in collection")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Successfully added the console to the collection",
                    content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = Console.class))
                    }),
            @ApiResponse(responseCode = "400",
                    content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = JvthequeStandardError.class))
                    })
    })
    @PostMapping("/console")
    public ResponseEntity<Object> addConsole(@RequestBody ConsoleDTO console) {
        try {
            return consoleService.addConsole(console);
        } catch (JvthequeStandardError e) {
            return ResponseEntity.badRequest().body(e);
        }
    }

}
