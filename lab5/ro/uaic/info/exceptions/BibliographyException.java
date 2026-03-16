package ro.uaic.info.exceptions;

public class BibliographyException extends Exception {
    public BibliographyException(String message) {
        super(message);
    }

    public BibliographyException(String message, Throwable cause) {
        super(message, cause);
    }
}