// --- BUNI ---
class Bunny extends Participant {
    public Bunny(int x, int y, Maze maze) {
        super(x, y, maze);
    }

    @Override
    public void run() {
        while (gameRunning) {
            moveRandomly();
            if (maze.getCell(x, y) == 'E') {
                System.out.println("🐰 Iepurele a găsit ieșirea! AI PIERDUT.");
                gameRunning = false;
            }
            try {
                Thread.sleep(400);
            } catch (InterruptedException e) {
            }
        }
    }

    public int getBX() {
        return x;
    }

    public int getBY() {
        return y;
    }
}
