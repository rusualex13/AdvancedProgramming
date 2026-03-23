package com.biblio.command;

import com.biblio.repository.Catalog;
import com.biblio.model.Resource;
import java.io.*;

public class ReportCommand implements Command {
    private Catalog catalog;

    public ReportCommand(Catalog c) {
        this.catalog = c;
    }

    @Override
    public void execute() {
        try (PrintWriter out = new PrintWriter(new FileWriter("report.html"))) {
            out.println("<html><body><h1>Catalog</h1><ul>");
            for (Resource r : catalog.getResources()) {
                out.println("<li>" + r.getTitle() + " (" + r.getLocation() + ")</li>");
            }
            out.println("</ul></body></html>");
            System.out.println("Raport generat!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}