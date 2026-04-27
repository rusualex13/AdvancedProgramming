import java.util.concurrent.ConcurrentHashMap;

public class Maze {
    private final int size;
    private final char[][] grid;
    public volatile int lastSeenX = -1;
    public volatile int lastSeenY = -1;

    public Maze(int size) {
        this.size = size;
        this.grid = new char[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (i == 0 || i == size - 1 || j == 0 || j == size - 1)
                    grid[i][j] = '#';
                else
                    grid[i][j] = '.';
            }
        }
        grid[size - 2][size - 2] = 'E'; // Ieșirea
    }

    public synchronized boolean canMoveTo(int x, int y) {
        if (x <= 0 || x >= size - 1 || y <= 0 || y >= size - 1)
            return false;
        return grid[x][y] != '#';
    }

    public void print(int bx, int by, java.util.List<Robot> robots) {
        StringBuilder sb = new StringBuilder("\n".repeat(5));
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                boolean isRobot = false;
                for (Robot r : robots)
                    if (r.getRX() == i && r.getRY() == j)
                        isRobot = true;

                if (i == bx && j == by)
                    sb.append("🐰 ");
                else if (isRobot)
                    sb.append("🤖 ");
                else
                    sb.append(grid[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }

    public int getSize() {
        return size;
    }

    public char getCell(int x, int y) {
        return grid[x][y];
    }
}