import javax.swing.*;
import java.awt.*;

public class DrawingPanel extends JPanel {
    private int rows, cols;
    private Cell[][] cells;
    private final int cellSize = 30; 

    public DrawingPanel(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        initMaze();
        setPreferredSize(new Dimension(cols * cellSize + 20, rows * cellSize + 20));
    }

    private void initMaze() {
        cells = new Cell[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                cells[i][j] = new Cell(i, j);
            }
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int x = j * cellSize + 10;
                int y = i * cellSize + 10;

                g.setColor(Color.LIGHT_GRAY);
                g.fillRect(x, y, cellSize, cellSize);

                
                g.setColor(Color.BLACK);
                if (cells[i][j].top)
                    g.drawLine(x, y, x + cellSize, y);
                if (cells[i][j].bottom)
                    g.drawLine(x, y + cellSize, x + cellSize, y + cellSize);
                if (cells[i][j].left)
                    g.drawLine(x, y, x, y + cellSize);
                if (cells[i][j].right)
                    g.drawLine(x + cellSize, y, x + cellSize, y + cellSize);
            }
        }
    }

    
    public void randomizeWalls() {
        java.util.Random rand = new java.util.Random();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (rand.nextBoolean())
                    cells[i][j].top = false;
                if (rand.nextBoolean())
                    cells[i][j].right = false;
            }
        }
        repaint(); 
    }
}