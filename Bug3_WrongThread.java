import javax.swing.*;
import java.awt.*;
import java.util.Date;

public class Bug3_WrongThread extends JFrame {
    private final JLabel timeLabel = new JLabel("Time: ");
    private final JButton startButton = new JButton("Start Clock");
    private volatile boolean running = false;

    public Bug3_WrongThread() {
        setTitle("Bug 3 - Fixed GUI Thread Update");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        startButton.addActionListener(e -> {
            if (running) return;
            running = true;
            startButton.setEnabled(false);

            Thread clockThread = new Thread(() -> {
                while (running) {
                    String currentTime = new Date().toString();
                    SwingUtilities.invokeLater(() ->
                        timeLabel.setText("Time: " + currentTime)
                    );
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException ex) {
                        Thread.currentThread().interrupt();
                        break;
                    }
                }
            });
            clockThread.setDaemon(true);
            clockThread.start();
        });

        add(timeLabel);
        add(startButton);
        setSize(420, 150);
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Bug3_WrongThread().setVisible(true));
    }
}
