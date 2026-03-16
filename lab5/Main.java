import ro.uaic.info.model.Resource;
import ro.uaic.info.repository.Repository;
import ro.uaic.info.exceptions.BibliographyException;

public class Main {
    public static void main(String[] args) {
        Repository repo = new Repository();

        // Cream resursele conform exemplelor tale
        Resource res1 = new Resource("knuth67", "The Art of Computer Programming", "https://www.google.com");
        res1.addTag("author", "Donald E. Knuth");

        Resource res2 = new Resource("jvm25", "The Java Virtual Machine Specification",
                "https://docs.oracle.com/javase/specs/jvms/se25/html/index.html");
        ;

        repo.add(res1);
        repo.add(res2);

        // Afisam resursele
        System.out.println("Resurse in catalog: " + repo.getAll());

        // Incercam sa le deschidem
        try {
            System.out.println("Se deschide link-ul web...");
            repo.openResource(res1);
            repo.openResource(res2);

            // System.out.println("Se deschide fisierul local...");
            // repo.openResource(res2);
        } catch (BibliographyException e) {
            System.err.println("Eroare la executie: " + e.getMessage());
            if (e.getCause() != null) {
                System.err.println("Cauza originala: " + e.getCause().getMessage());
            }
        }
    }
}