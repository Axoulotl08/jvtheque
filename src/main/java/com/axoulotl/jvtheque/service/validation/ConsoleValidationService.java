package com.axoulotl.jvtheque.service.validation;

import com.axoulotl.jvtheque.exception.JvthequeStandardError;
import com.axoulotl.jvtheque.exception.StandardErrorEnum;
import com.axoulotl.jvtheque.model.dto.input.ConsoleDTO;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class ConsoleValidationService {

    public void validateAddConsoleDto(ConsoleDTO consoleDTO) throws JvthequeStandardError {
        validateName(consoleDTO.getName());
        validateManufacturer(consoleDTO.getManufacturer());
        validateLaunchDate(consoleDTO.getLaunchDate());
    }

    private void validateLaunchDate(LocalDate launchDate) throws JvthequeStandardError {
        if (LocalDate.now().isBefore(launchDate)) {
            throw new JvthequeStandardError(StandardErrorEnum.ERROR_INPUT, "La date de commercialisation est érronée");
        }
    }

    private void validateManufacturer(String manufacturer) throws JvthequeStandardError {
        if (StringUtils.isEmpty(manufacturer)){
            throw new JvthequeStandardError(StandardErrorEnum.ERROR_INPUT, "Le nom du fabricant est vide. Merci d'entrée un nom valide.");
        }
    }

    private void validateName(String name) throws JvthequeStandardError {
        if (StringUtils.isEmpty(name)){
            throw new JvthequeStandardError(StandardErrorEnum.ERROR_INPUT, "Le nom de la console est vide. Merci d'entrée un nom valide.");
        }
    }
}
