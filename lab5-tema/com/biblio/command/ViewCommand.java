package com.biblio.command;

import com.biblio.model.Resource;
import java.awt.Desktop;
import java.net.URI;

public class ViewCommand implements Command {
    private Resource res;

    public ViewCommand(Resource r) {
        this.res = r;
    }

    @Override
    public void execute() throws com.biblio.exception.BibliographyException {
        try {
            // Deschide URL-ul sau fișierul folosind aplicația default a Windows/Mac
            Desktop.getDesktop().browse(new URI(res.getLocation()));
        } catch (Exception e) {
            throw new com.biblio.exception.BibliographyException("Nu pot deschide resursa!");
        }
    }
}