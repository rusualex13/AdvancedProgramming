

public class Road {
    private RoadType type;
    private Location from;
    private Location to;

    public Road(RoadType type, Location from, Location to) {
        this.type = type;
        this.from = from;
        this.to = to;
    }

    public Location getFrom() {
        return from;
    }

    public Location getTo() {
        return to;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof Road road))
            return false;
        // Doua drumuri sunt egale daca au acelasi tip si leaga aceleasi locatii
        return type == road.type && from.equals(road.from) && to.equals(road.to);
    }

    @Override
    public String toString() {
        return type + " from " + from + " to " + to;
    }
}