public class Road {
    private Location start;
    private Location end;
    private String name;
    private String type;
    private double length;
    private int speedLimit;

    public Road(Location start, Location end, String name, String type, double length, int speedLimit) {
        this.start = start;
        this.end = end;
        this.name = name;
        this.length = length;
        this.speedLimit = speedLimit;
        this.type = type;
    }

    public Location getStart() {
        return start;
    }

    public void setStart(Location start) {
        this.start = start;
    }

    public Location getEnd() {
        return end;
    }

    public void setEnd(Location end) {
        this.end = end;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        double minLenght = Math.sqrt(Math.pow(end.getX() - start.getX(), 2) + Math.pow(end.getY() - start.getY(), 2));
        if (length < minLenght) {
            System.out.println(
                    "Atentie: Lungimea drumului " + name + " este prea mica! Se va seta distanta minima: " + minLenght
                            + "m");
            this.length = minLenght;
        } else {
            this.length = length;
        }
    }

    public int getSpeedLimit() {
        return speedLimit;
    }

    public void setSpeedLimit(int speedLimit) {
        this.speedLimit = speedLimit;
    }

    public String toString() {
        return "Road{name='" + name + "', type='" + type + "', length=" + length + "m, speedLimit=" + speedLimit
                + "km/h, start=" + start.getName() + ", end=" + end.getName() + "}";
    }

}
