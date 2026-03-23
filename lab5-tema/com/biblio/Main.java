package com.biblio;

import com.biblio.command.*;
import com.biblio.model.Resource;
import com.biblio.repository.Catalog;

public class Main {
    public static void main(String[] args) {
        try {
            Catalog catalog = new Catalog();

            // 1. Creăm resursele din exemplu
            Resource res1 = new Resource("knuth67", "The Art of Computer Programming", "d:/books/tacp.ps") {
            };
            Resource res2 = new Resource("java25", "Java Language Spec", "https://docs.oracle.com") {
            };

            // 2. Adăugăm folosind comanda (Homework)
            new AddCommand(catalog, res1).execute();
            new AddCommand(catalog, res2).execute();

            // 3. Generăm raportul HTML
            new ReportCommand(catalog).execute();

            // 4. Vizualizăm (deschide browserul)
            new ViewCommand(res2).execute();

            System.out.println("Totul a rulat perfect!");

        } catch (Exception e) {
            System.err.println("Eroare raportată de sistem: " + e.getMessage());
        }
    }
}