package com.axoulotl.jvtheque.service;

import com.axoulotl.jvtheque.exception.JvthequeStandardError;
import com.axoulotl.jvtheque.model.entity.Console;
import com.axoulotl.jvtheque.model.dto.input.ConsoleDTO;
import com.axoulotl.jvtheque.repository.ConsoleRepository;
import com.axoulotl.jvtheque.service.validation.ConsoleValidationService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ConsoleService {

    ConsoleRepository consoleRepository;
    ConsoleValidationService consoleValidationService;

    @Autowired
    public ConsoleService(ConsoleRepository consoleRepository,
                          ConsoleValidationService consoleValidationService){
        this.consoleRepository = consoleRepository;
        this.consoleValidationService = consoleValidationService;

    }

    /**
     *
     * @param consoleDTO
     * @return
     * @throws JvthequeStandardError
     */
    public ResponseEntity<Object> addConsole(ConsoleDTO consoleDTO) throws JvthequeStandardError {
        consoleValidationService.validateAddConsoleDto(consoleDTO);
        Console console = Console.builder()
                .name(consoleDTO.getName())
                .launchDate(consoleDTO.getLaunchDate())
                .manufacturer(consoleDTO.getManufacturer())
                .build();

        consoleRepository.save(console);
        System.out.println(console);
        return ResponseEntity.ok(console);
    }

    /**
     * This method 
     *
     * @param id - This technical ID of the console to return
     * @return the console data from the database
     * @throws JvthequeStandardError if there are an error about the technical ID
     */
    public ResponseEntity<Object> getConsole(Integer id) throws JvthequeStandardError{
        return null;
    }
}
