package com.axoulotl.jvtheque.service.validation;

import com.axoulotl.jvtheque.exception.JvthequeStandardError;
import com.axoulotl.jvtheque.model.dto.input.GameDTO;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class GameValidationService {
    public void validateGameInsert(GameDTO game) throws JvthequeStandardError {
        validateGameName(game.getName());
        validateGameConsole(game.getConsole());
        validateLaunchDate(game.getLaunchDate());
    }

    private void validateGameName(String name) throws JvthequeStandardError{
        if (StringUtils.isEmpty(name))
    }

    private void validateGameConsole(Integer consoleId) throws  JvthequeStandardError{

    }

    private void validateLaunchDate(LocalDate launchDate) throws JvthequeStandardError{

    }
}
