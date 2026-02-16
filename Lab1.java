public class Lab1 {
    public static void main(String[] args) {
        System.out.println("Hello, World!");
        String[] languages = { "C", "C++", "C#", "Python", "Go", "Rust", "JavaScript", "PHP", "Swift", "Java" };
        int n = (int) (Math.random() * 1_000_000);
        System.out.println("Random number: " + n);
        n = n * 3;
        n = n + 0b10101;
        n = n + 0xFF;
        n = n * 6;
        System.out.println("Final number: " + n);
        while (n > 10) {
            int newn = n;
            int s = 0;
            while (newn != 0) {
                s += newn % 10;
                newn /= 10;
            }
            n = s;
        }
        System.out.println("Final single-digit number: " + n);
        for (int i = 0; i < languages.length; i++) {
            System.out.println("Willy-nilly, this semester I will learn " + languages[i]);
        }
    }
}