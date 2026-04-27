import java.util.Random;

public abstract class Participant extends Thread {
    protected int x, y;
    protected Maze maze;
    protected static volatile boolean gameRunning = true;
    protected Random random = new Random();

    public Participant(int x, int y, Maze maze) {
        this.x = x; this.y = y;
        this.maze = maze;
    }

    protected void moveRandomly() {
        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};
        int dir = random.nextInt(4);
        int newX = x + dx[dir];
        int newY = y + dy[dir];

        if (maze.canMoveTo(newX, newY)) {
            this.x = newX;
            this.y = newY;
        }
    }
}