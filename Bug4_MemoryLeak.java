import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Bug4_MemoryLeak extends JFrame {
    private final List<JButton> createdButtons = new ArrayList<>();
    private final JPanel buttonPanel = new JPanel(new FlowLayout());

    public Bug4_MemoryLeak() {
        setTitle("Bug 4 - Fixed Button Cleanup");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JButton addButton = new JButton("Add Button");
        addButton.addActionListener(e -> {
            JButton newButton = new JButton("Button " + (createdButtons.size() + 1));
            createdButtons.add(newButton);
            buttonPanel.add(newButton);
            buttonPanel.revalidate();
            buttonPanel.repaint();
        });

        JButton removeButton = new JButton("Remove All");
        removeButton.addActionListener(e -> {
            buttonPanel.removeAll();
            createdButtons.clear(); // Release references to removed buttons
            buttonPanel.revalidate();
            buttonPanel.repaint();
        });

        JPanel controls = new JPanel();
        controls.add(addButton);
        controls.add(removeButton);

        add(buttonPanel, BorderLayout.CENTER);
        add(controls, BorderLayout.SOUTH);
        setSize(500, 300);
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Bug4_MemoryLeak().setVisible(true));
    }
}
