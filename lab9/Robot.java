class Robot extends Participant {
    public Robot(int x, int y, Maze maze) {
        super(x, y, maze);
    }

    @Override
    public void run() {
        while (gameRunning) {
            moveRandomly();
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
            }
        }
    }

    public int getRX() {
        return x;
    }

    public int getRY() {
        return y;
    }
}