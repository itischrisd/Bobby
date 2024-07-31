package pl.edu.pja.s25692.bobby.exception;

import lombok.Getter;

@Getter
public class DomainException extends RuntimeException {

    private String title;
    private String message;
    private String targetName;
    private String targetUrl;

    public DomainException() {
    }

    public DomainException(String title, String message, String targetName, String targetUrl) {
        super(message);
        this.title = title;
        this.message = message;
        this.targetName = targetName;
        this.targetUrl = targetUrl;
    }

    public DomainException(String title, String message) {
        super(message);
        this.title = title;
        this.message = message;
    }
}
