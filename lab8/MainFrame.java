import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MainFrame extends JFrame {
    DrawingPanel canvas;
    JTextField rowInput, colInput;

    public MainFrame() {
        super("Maze Creator");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        setSize(600, 500);  

        JPanel configPanel = new JPanel();
        configPanel.add(new JLabel("Rows:"));
        rowInput = new JTextField("10", 5);
        configPanel.add(rowInput);
        configPanel.add(new JLabel("Cols:"));
        colInput = new JTextField("15", 5);
        configPanel.add(colInput);

        JButton btnGrid = new JButton("Draw Grid");
        configPanel.add(btnGrid);
        add(configPanel, BorderLayout.NORTH);

        
        JPanel controlPanel = new JPanel();
        JButton btnCreate = new JButton("Create Maze");
        JButton btnReset = new JButton("Reset");
        JButton btnExit = new JButton("Exit");
        controlPanel.add(btnCreate);
        controlPanel.add(btnReset);
        controlPanel.add(btnExit);
        add(controlPanel, BorderLayout.SOUTH);

        
        btnGrid.addActionListener(e -> {
            try {
                int r = Integer.parseInt(rowInput.getText());
                int c = Integer.parseInt(colInput.getText());
                
               
                if (canvas != null) {
                    remove(canvas);
                }

                canvas = new DrawingPanel(r, c);
                add(canvas, BorderLayout.CENTER);

                pack();
                setSize(800, 600);
                revalidate();
                repaint();
                
                System.out.println(" Grid " + r + "x" + c + " creat!");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, " Numere valide: " + ex.getMessage());
            }
        });

        btnCreate.addActionListener(e -> {
            if (canvas != null) {
                canvas.randomizeWalls();
                System.out.println(" Maze generat!");
            } else {
                JOptionPane.showMessageDialog(this, " Mai întâi apasă Draw Grid!");
            }
        });

        btnReset.addActionListener(e -> btnGrid.doClick());
        btnExit.addActionListener(e -> System.exit(0));

    
        setLocationRelativeTo(null);
        setVisible(true);  
    }

    public static void main(String[] args) {
        System.out.println("Pornesc Maze Creator...");
        SwingUtilities.invokeLater(() -> new MainFrame());
        System.out.println("Gata!");
    }
}