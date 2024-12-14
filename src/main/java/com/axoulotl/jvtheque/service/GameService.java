package com.axoulotl.jvtheque.service;

import com.axoulotl.jvtheque.exception.JvthequeStandardError;
import com.axoulotl.jvtheque.exception.StandardErrorEnum;
import com.axoulotl.jvtheque.model.entity.Console;
import com.axoulotl.jvtheque.model.entity.Game;
import com.axoulotl.jvtheque.model.dto.input.GameDTO;
import com.axoulotl.jvtheque.repository.ConsoleRepository;
import com.axoulotl.jvtheque.repository.GameRepository;
import com.axoulotl.jvtheque.service.validation.GameValidationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
public class GameService {

    ConsoleRepository consoleRepository;
    GameRepository gameRepository;
    GameValidationService gameValidationService;

    @Autowired
    public GameService(GameRepository gameRepository,
                       ConsoleRepository consoleRepository,
                       GameValidationService gameValidationService){
        this.gameRepository = gameRepository;
        this.consoleRepository = consoleRepository;
        this.gameValidationService = gameValidationService;
    }

    /**
     * Ajout d'un jeu dans la base de données après vérification
     * des informations en entrée.
     *
     * @param gameDTO
     * @throws JvthequeStandardError si l'ID pour la console n'est pas présente
     * en base de données
     * @return l'entité créer en base de donnée
     */
    public ResponseEntity<Object> addGame(GameDTO gameDTO) throws JvthequeStandardError {
        Optional<Console> console = consoleRepository.findById(gameDTO.getConsole());
        gameValidationService.validateGameInsert(gameDTO);

        if(console.isPresent()) {
            Game game = Game.builder()
                    .name(gameDTO.getName())
                    .collector(gameDTO.getCollector())
                    .inBox(gameDTO.getInBox())
                    .launchDate(gameDTO.getLaunchDate())
                    .console(console.get())
                    .build();

            gameRepository.save(game);
            return ResponseEntity.ok(game);
        }
        else{
            throw new JvthequeStandardError(StandardErrorEnum.ERROR_DATABASE_NOTFOUND, "Console with id ["+ gameDTO.getConsole() + "] doesn't exist");
        }
    }
}
