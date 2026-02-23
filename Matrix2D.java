public class Matrix2D // clasa principala
{
    public static void main(String[] args) {
        // verificarea argumentelor din linia de comanda
        if (args.length != 2) {
            System.out.println("Please provide two arguments: <size> <shape>");
            return;
        }
        int n = Integer.parseInt(args[0]);// numarul matricei
        String shape = args[1].toLowerCase();// daca vrei cerc sau dreptunghi

        long startTime = System.nanoTime();// timpul de rulare al programului

        try {
            int[][] matrix = new int[n][n];// crearea matricei
            if (shape.equals("rectangle")) {
                generateRectangle(matrix, n);
            } else if (shape.equals("circle")) {
                generateCircle(matrix, n);
            } else {
                System.out.println("Invalid shape. Use 'rectangle' or 'circle'.");
                return;
            }
            if (n <= 50) {
                printMatrix(matrix);
            }
            long endTime = System.nanoTime();
            long durationMs = (endTime - startTime) / 1_000_000;
            System.out.println("Execution time: " + durationMs + " ms");
        } catch (NumberFormatException e) {
            System.out.println("Invalid number format.");
        }

    }

    private static void generateRectangle(int[][] matrix, int n) {
        // Fundal alb (255), Dreptunghi negru (0) în mijloc
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i > n / 4 && i < 3 * n / 4 && j > n / 4 && j < 3 * n / 4)// formula sa vedem daca e in mijlcul
                                                                             // matricei pt a forma dreptunghiul
                {
                    matrix[i][j] = 0;
                } else {
                    matrix[i][j] = 255;
                }
            }
        }
    }

    private static void generateCircle(int[][] matrix, int n) {
        // Fundal negru (0), Cerc alb (255)
        double center = n / 2.0;
        double radius = n / 3.0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                // Calculăm distanța de la centru și setăm valoarea în funcție de aceasta
                // formula lui pitagora pentru a desena un cerc
                double distance = Math.sqrt(Math.pow(i - center, 2) + Math.pow(j - center, 2));
                matrix[i][j] = (distance < radius) ? 255 : 0;
            }
        }
    }

    private static void printMatrix(int[][] matrix) {
        StringBuilder sb = new StringBuilder();
        for (int[] row : matrix) {
            for (int pixel : row) {
                // Folosim Unicode: Bloc plin pentru alb, spațiu pentru negru
                sb.append(pixel == 255 ? "██" : "  ");
            }
            sb.append("\n");
        }
        System.out.print(sb.toString());
    }
}