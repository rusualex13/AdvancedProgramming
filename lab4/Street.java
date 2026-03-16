public class Street {
    private String name;
    private int length;
    private Intersection from, to;

    public Street(String name, int length, Intersection from, Intersection to) {
        this.name = name;
        this.length = length;
        this.from = from;
        this.to = to;
    }

    public int getLength() {
        return length;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name + " (" + length + "m)";
    }
}