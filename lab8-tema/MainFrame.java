import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.*;

public class MainFrame extends JFrame {
    private MazePanel canvas;
    private JTextField sizeField;

    public MainFrame() {
        setTitle("Maze Designer - Homework Lab 8");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        canvas = new MazePanel(10, 10);

        // Listener pentru click pe labirint
        canvas.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                canvas.toggleCellWalls(e.getX(), e.getY());
            }
        });

        setupTopPanel();
        setupBottomPanel();

        add(canvas, BorderLayout.CENTER);
        pack();
        setLocationRelativeTo(null);
    }

    private void setupTopPanel() {
        JPanel topPanel = new JPanel();
        topPanel.add(new JLabel("Size:"));
        sizeField = new JTextField("10", 5);
        JButton setBtn = new JButton("Set Grid");

        setBtn.addActionListener(e -> {
            int val = Integer.parseInt(sizeField.getText());
            canvas.updateGridSize(val, val);
        });

        topPanel.add(sizeField);
        topPanel.add(setBtn);
        add(topPanel, BorderLayout.NORTH);
    }

    private void setupBottomPanel() {
        JPanel botPanel = new JPanel();

        JButton rndBtn = new JButton("Randomize");
        rndBtn.addActionListener(e -> canvas.randomize());

        JButton saveBtn = new JButton("Save Binary");
        saveBtn.addActionListener(e -> saveAction());

        JButton loadBtn = new JButton("Load Binary");
        loadBtn.addActionListener(e -> loadAction());

        JButton pngBtn = new JButton("Export PNG");
        pngBtn.addActionListener(e -> exportAction());
        JButton validateBtn = new JButton("Validate");
        validateBtn.addActionListener(e -> {
            if (canvas.isTraversable()) {
                JOptionPane.showMessageDialog(this, "Drum găsit! Labirintul este valid.");
            } else {
                JOptionPane.showMessageDialog(this, "Nu există drum de la Start la Final!", "Eroare",
                        JOptionPane.ERROR_MESSAGE);
            }
        });
        botPanel.add(validateBtn);
        botPanel.add(rndBtn);
        botPanel.add(saveBtn);
        botPanel.add(loadBtn);
        botPanel.add(pngBtn);

        add(botPanel, BorderLayout.SOUTH);
    }

    private void saveAction() {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("maze.bin"))) {
            out.writeObject(canvas.getGrid());
            JOptionPane.showMessageDialog(this, "Salvat cu succes!");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private void loadAction() {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("maze.bin"))) {
            Cell[][] loaded = (Cell[][]) in.readObject();
            canvas.setGrid(loaded);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private void exportAction() {
        BufferedImage img = new BufferedImage(canvas.getWidth(), canvas.getHeight(), BufferedImage.TYPE_INT_RGB);
        canvas.paint(img.getGraphics());
        try {
            ImageIO.write(img, "png", new File("maze_export.png"));
            JOptionPane.showMessageDialog(this, "Imagine exportata!");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new MainFrame().setVisible(true));
    }
}