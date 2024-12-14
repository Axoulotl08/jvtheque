package com.axoulotl.jvtheque.controller;

import com.axoulotl.jvtheque.exception.JvthequeStandardError;
import com.axoulotl.jvtheque.model.dto.input.GameDTO;
import com.axoulotl.jvtheque.service.GameService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
@Slf4j
public class GameController {

    GameService gameService;

    @Autowired
    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    @Operation(summary = "Add a new game in collection")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Successfully added the game to the collection",
                    content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = GameDTO.class))
                    }),
            @ApiResponse(responseCode = "400",
            description = "An error occured while trying to add the game",
            content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = JvthequeStandardError.class))
            })
    })
    @PostMapping("/game")
    public ResponseEntity<Object> addGame(@RequestBody GameDTO game) {
        try {
            return gameService.addGame(game);
        }
        catch (JvthequeStandardError ex){
            log.warn("[AddGame] Error while adding a game, {}", ex.getComment());
            return ResponseEntity.badRequest().build();
        }
    }
}