import javax.swing.*;
import java.awt.*;

public class Bug1_BlockingEDT extends JFrame {
    private final JLabel statusLabel = new JLabel("Ready");
    private final JButton processButton = new JButton("Process");

    public Bug1_BlockingEDT() {
        setTitle("Bug 1 - Fixed Blocking EDT");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        processButton.addActionListener(e -> {
            processButton.setEnabled(false);
            statusLabel.setText("Processing...");
            new Thread(() -> {
                try {
                    Thread.sleep(5000); // Simulate long work off the EDT
                } catch (InterruptedException ex) {
                    Thread.currentThread().interrupt();
                }
                SwingUtilities.invokeLater(() -> {
                    statusLabel.setText("Done!");
                    processButton.setEnabled(true);
                });
            }).start();
        });

        add(statusLabel);
        add(processButton);
        setSize(320, 150);
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Bug1_BlockingEDT().setVisible(true));
    }
}
