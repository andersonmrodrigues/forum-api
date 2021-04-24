package br.com.desenv.api.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public class ErroValidacaoHandler {

    @Autowired
    private MessageSource messageSource;

    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public List<ErroFormDto> handle(MethodArgumentNotValidException exception) {
        List<ErroFormDto> erroFormDtoList = new ArrayList<>();
        exception.getBindingResult().getFieldErrors().forEach(fieldError -> {
            String msg = fieldError.getDefaultMessage();
            ErroFormDto erroFormDto = new ErroFormDto(fieldError.getField(), msg);
            erroFormDtoList.add(erroFormDto);
        });
        return erroFormDtoList;
    }

}
