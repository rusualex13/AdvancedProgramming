
public abstract class Location {
    protected String name;

    public Location(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Location location = (Location) o;
        return name.equals(location.name);
    }

    @Override
    public String toString() {
        return name;
    }
}

/**
 * Oras cu proprietate specifica: populatie.
 */
class City extends Location {
    private int population;

    public City(String name, int population) {
        super(name); // Aici 'super' apeleaza constructorul din Location(String name)
        this.population = population;
    }

    public int getPopulation() {
        return population;
    }
}

/**
 * Aeroport cu proprietate specifica: numar de terminale.
 */
class Airport extends Location {
    private int terminals;

    public Airport(String name, int terminals) {
        super(name);
        this.terminals = terminals;
    }

    public int getTerminals() {
        return terminals;
    }
}

/**
 * Benzinarie cu proprietate specifica: pretul la benzina.
 */
class GasStation extends Location {
    private double gasPrice;

    public GasStation(String name, double gasPrice) {
        super(name);
        this.gasPrice = gasPrice;
    }

    public double getGasPrice() {
        return gasPrice;
    }
}