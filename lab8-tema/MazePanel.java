import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class MazePanel extends JPanel {
    private Cell[][] grid;
    private int rows, cols;
    private final int cellSize = 40;
    private final int margin = 20;

    public MazePanel(int rows, int cols) // creaza matricea de celule
    {
        this.rows = rows;
        this.cols = cols;
        initGrid();
        setPreferredSize(new Dimension(cols * cellSize + 40, rows * cellSize + 40));
    }

    public void initGrid()// initializeaza matricea de celule
    {
        grid = new Cell[rows][cols];
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                grid[r][c] = new Cell(r, c);
            }
        }
        repaint();
    }

    public void updateGridSize(int newRows, int newCols) {
        this.rows = newRows;
        this.cols = newCols;
        initGrid();
    }

    // Algoritm simplu de randomizare
    public void randomize() {
        Random rand = new Random();
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (rand.nextBoolean())
                    grid[r][c].top = false;
                if (rand.nextBoolean())
                    grid[r][c].left = false;
                if (rand.nextBoolean())
                    grid[r][c].right = false;
                if (rand.nextBoolean())
                    grid[r][c].bottom = false;
            }
        }
        repaint();
    }

    // Toggle pereti la click pe celula
    public void toggleCellWalls(int x, int y) {
        int c = (x - margin) / cellSize;
        int r = (y - margin) / cellSize;

        if (r >= 0 && r < rows && c >= 0 && c < cols) {
            grid[r][c].top = !grid[r][c].top;
            grid[r][c].bottom = !grid[r][c].bottom;
            grid[r][c].left = !grid[r][c].left;
            grid[r][c].right = !grid[r][c].right;
            repaint();
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                int x = c * cellSize + margin;
                int y = r * cellSize + margin;

                g.setColor(Color.WHITE);
                g.fillRect(x, y, cellSize, cellSize);

                g.setColor(Color.BLUE);
                if (grid[r][c].top)
                    g.drawLine(x, y, x + cellSize, y);
                if (grid[r][c].bottom)
                    g.drawLine(x, y + cellSize, x + cellSize, y + cellSize);
                if (grid[r][c].left)
                    g.drawLine(x, y, x, y + cellSize);
                if (grid[r][c].right)
                    g.drawLine(x + cellSize, y, x + cellSize, y + cellSize);
            }
        }
    }

    public boolean isTraversable() {
        boolean[][] visited = new boolean[rows][cols];
        return canReach(0, 0, visited);
    }

    private boolean canReach(int r, int c, boolean[][] visited) // dfs
    {
        if (r == rows - 1 && c == cols - 1)
            return true;

        visited[r][c] = true;

        // Sus
        if (r > 0 && !grid[r][c].top && !visited[r - 1][c])
            if (canReach(r - 1, c, visited))
                return true;
        // Jos
        if (r < rows - 1 && !grid[r][c].bottom && !visited[r + 1][c])
            if (canReach(r + 1, c, visited))
                return true;
        // Stânga
        if (c > 0 && !grid[r][c].left && !visited[r][c - 1])
            if (canReach(r, c - 1, visited))
                return true;
        // Dreapta
        if (c < cols - 1 && !grid[r][c].right && !visited[r][c + 1])
            if (canReach(r, c + 1, visited))
                return true;

        return false;
    }

    public Cell[][] getGrid() {
        return grid;
    }

    public void setGrid(Cell[][] newGrid) {
        this.grid = newGrid;
        this.rows = newGrid.length;
        this.cols = newGrid[0].length;
        repaint();
    }
}