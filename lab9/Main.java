import java.util.*;

public class Main {
    public static void main(String[] args) {
        Maze maze = new Maze(12);
        Bunny bunny = new Bunny(1, 1, maze);

        List<Robot> robots = new ArrayList<>();
        robots.add(new Robot(10, 1, maze));
        robots.add(new Robot(1, 10, maze));
        robots.add(new Robot(5, 5, maze));

        bunny.start();
        for (Robot r : robots)
            r.start();

        while (Participant.gameRunning) {
            maze.print(bunny.getBX(), bunny.getBY(), robots);

            for (Robot r : robots) {
                if (r.getRX() == bunny.getBX() && r.getRY() == bunny.getBY()) {
                    System.out.println("🤖 ROBOTII AU CASTIGAT! Iepurele a fost prins.");
                    Participant.gameRunning = false;
                }
            }

            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
            }
        }
    }
}