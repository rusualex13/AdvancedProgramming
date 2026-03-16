package ro.uaic.info.repository;

import ro.uaic.info.model.Resource;
import ro.uaic.info.exceptions.BibliographyException;
import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

public class Repository {
    private List<Resource> storage = new ArrayList<>();

    public void add(Resource res) {
        storage.add(res);
    }

    public void openResource(Resource res) throws BibliographyException {
        if (!Desktop.isDesktopSupported()) {
            throw new BibliographyException("Desktop class is not supported on this system.");
        }

        try {
            Desktop desktop = Desktop.getDesktop();
            if (res.getLocation().startsWith("http")) {
                desktop.browse(new URI(res.getLocation()));
            } else {
                File file = new File(res.getLocation());
                if (!file.exists()) {
                    throw new BibliographyException("File not found at: " + res.getLocation());
                }
                desktop.open(file);
            }
        } catch (IOException | URISyntaxException | UnsupportedOperationException e) {
            throw new BibliographyException("Error opening the resource: " + res.getTitle(), e);
        }
    }

    public List<Resource> getAll() {
        return storage;
    }
}