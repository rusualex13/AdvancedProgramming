public class Main {
    public static void main(String[] args) {
        Problem pb = new Problem();

        // Cream locatii
        City iasi = new City("Iasi", 300000);
        Airport otopeni = new Airport("Otopeni", 2);
        GasStation peco = new GasStation("Petrom", 7.2);
        City vaslui = new City("Vaslui", 5000);
        City bacau = new City("Bacau", 30000);

        // Adaugam locatii
        pb.addLocation(iasi);
        pb.addLocation(otopeni);
        pb.addLocation(peco);
        pb.addLocation(vaslui);
        pb.addLocation(bacau);
        // Adaugam drumuri

        pb.addRoad(new Road(RoadType.HIGHWAY, iasi, otopeni));
        pb.addRoad(new Road(RoadType.COUNTRY, otopeni, peco));
        pb.addRoad(new Road(RoadType.HIGHWAY, otopeni, vaslui));
        pb.addRoad(new Road(RoadType.HIGHWAY, vaslui, bacau));

        // Testam validitatea si accesibilitatea
        System.out.println("Instanta valida: " + pb.isValid());
        System.out.println("Pot ajunge de la Iasi la Bacau " + pb.canReach(iasi, bacau));
    }
}