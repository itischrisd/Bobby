package pl.edu.pja.s25692.bobby.handler;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import pl.edu.pja.s25692.bobby.exception.DomainException;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(Exception.class)
    public String handleException(Exception e, Model model) {
        model.addAttribute("errorMessage", e.getMessage());
        return "error";
    }

    @ExceptionHandler(DomainException.class)
    public String handleDomainException(DomainException e, Model model) {
        model.addAttribute("errorTitle", e.getTitle());
        model.addAttribute("errorMessage", e.getMessage());
        model.addAttribute("targetUrl", e.getTargetUrl());
        model.addAttribute("targetName", e.getTargetName());
        return "error";
    }
}
