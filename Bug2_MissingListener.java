import javax.swing.*;
import java.awt.*;

public class Bug2_MissingListener extends JFrame {
    private final JLabel countLabel = new JLabel("Count: 0");
    private final JButton incrementButton = new JButton("Increment");
    private int count = 0;

    public Bug2_MissingListener() {
        setTitle("Bug 2 - Fixed Missing Listener");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        incrementButton.addActionListener(e -> {
            count++;
            countLabel.setText("Count: " + count);
        });

        add(countLabel);
        add(incrementButton);
        setSize(300, 150);
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Bug2_MissingListener().setVisible(true));
    }
}
