public class Program {
    public static void main(String[] args) {
        // 1. Cream locatii
        Location v1 = new Location(0, 0, "Iasi", "City");
        Location v2 = new Location(0, 30, "Vaslui", "City");

        // 2. Cream un drum corect
        Road r1 = new Road(v1, v2, "DN24", "Express", 40, 100);
        // 3. Cream un drum gresit (lungime prea mica)
        Road r2 = new Road(v1, v2, "DrumGresit", "Country", 10, 50);

        // 4. Afisare
        System.out.println(v1);
        System.out.println(v2);
        System.out.println(r1);
        System.out.println(r2);
    }
}