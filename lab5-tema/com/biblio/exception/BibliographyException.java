package com.biblio.exception;

public class BibliographyException extends Exception {
    public BibliographyException(String m) {
        super(m);// merge la parint, adică la clasa de bază Exception, care are un constructor ce
                 // primește un mesaj de eroare.
    }
}