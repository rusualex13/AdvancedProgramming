package com.biblio.command;

import com.biblio.model.Resource;
import com.biblio.repository.Catalog;
import com.biblio.exception.BibliographyException;

public class AddCommand implements Command {
    private Catalog catalog;
    private Resource res;

    public AddCommand(Catalog c, Resource r) {
        this.catalog = c;
        this.res = r;
    }

    @Override
    public void execute() throws BibliographyException {
        if (res == null)
            throw new BibliographyException("Resursa e null!");
        catalog.getResources().add(res);
    }
}