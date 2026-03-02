public class Location {
    private double x;
    private double y;
    private String name;
    private String type;

    public Location(double x, double y, String name, String type) {
        this.x = x;
        this.y = y;
        this.name = name;
        this.type = type;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
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

    public String toString() {
        return "Location{name='" + name + "', type='" + type + "', x=" + x + ", y=" + y + "}";
    }

}
