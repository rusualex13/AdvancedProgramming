import java.util.Objects;

public class Intersection { // Am scos "implements Comparable"
    private String name;

    public Intersection(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o)// identice din punct de vedere al numelui
    {
        if (this == o)
            return true;
        if (!(o instanceof Intersection))
            return false;
        Intersection that = (Intersection) o;
        return Objects.equals(name, that.name);
    }

    @Override
    public int hashCode()// intersecțiile cu același nume vor avea același hashcode
    {
        return Objects.hash(name);

    }

    @Override
    public String toString() {
        return name;
    }
}