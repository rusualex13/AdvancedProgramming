package com.biblio.command;

import com.biblio.exception.BibliographyException;

public interface Command {
    void execute() throws BibliographyException;
}