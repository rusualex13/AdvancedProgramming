import java.io.Serializable;

public class Cell implements Serializable {
    public int row, col;
    // true inseamna ca peretele exista
    public boolean top = true, right = true, bottom = true, left = true;

    public Cell(int r, int c) {
        this.row = r;
        this.col = c;
    }
}