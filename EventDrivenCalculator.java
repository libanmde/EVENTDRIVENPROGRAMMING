import javax.swing.*;
import java.awt.*;

public class EventDrivenCalculator extends JFrame {
    private final JTextField display = new JTextField("0");
    private double firstOperand = 0;
    private String operator = "";
    private boolean startNewNumber = true;

    public EventDrivenCalculator() {
        setTitle("Event-Driven Calculator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout(8, 8));

        display.setHorizontalAlignment(JTextField.RIGHT);
        display.setEditable(false);
        display.setFont(new Font("Arial", Font.BOLD, 26));
        add(display, BorderLayout.NORTH);

        JPanel panel = new JPanel(new GridLayout(4, 4, 5, 5));
        String[][] keys = {
            {"7", "8", "9", "/"},
            {"4", "5", "6", "*"},
            {"1", "2", "3", "-"},
            {"0", "C", "=", "+"}
        };

        for (String[] row : keys) {
            for (String key : row) {
                JButton button = new JButton(key);
                button.setFont(new Font("Arial", Font.BOLD, 20));
                if ("+-*/".contains(key) && key.length() == 1) {
                    button.addActionListener(e -> chooseOperator(key));
                } else if ("=".equals(key)) {
                    button.addActionListener(e -> calculate());
                } else if ("C".equals(key)) {
                    button.addActionListener(e -> clear());
                } else {
                    button.addActionListener(e -> enterDigit(key));
                }
                panel.add(button);
            }
        }

        add(panel, BorderLayout.CENTER);
        setSize(350, 420);
        setLocationRelativeTo(null);
    }

    private void enterDigit(String digit) {
        if (startNewNumber || "Error".equals(display.getText())) {
            display.setText(digit);
            startNewNumber = false;
        } else {
            display.setText(display.getText() + digit);
        }
    }

    private void chooseOperator(String selectedOperator) {
        try {
            firstOperand = Double.parseDouble(display.getText());
            operator = selectedOperator;
            startNewNumber = true;
        } catch (NumberFormatException ex) {
            display.setText("Error");
            startNewNumber = true;
        }
    }

    private void calculate() {
        if (operator.isEmpty()) return;
        try {
            double secondOperand = Double.parseDouble(display.getText());
            double result;
            switch (operator) {
                case "+": result = firstOperand + secondOperand; break;
                case "-": result = firstOperand - secondOperand; break;
                case "*": result = firstOperand * secondOperand; break;
                case "/":
                    if (secondOperand == 0) {
                        display.setText("Error");
                        operator = "";
                        startNewNumber = true;
                        return;
                    }
                    result = firstOperand / secondOperand;
                    break;
                default: return;
            }
            display.setText(String.valueOf(result));
            operator = "";
            startNewNumber = true;
        } catch (NumberFormatException ex) {
            display.setText("Error");
            operator = "";
            startNewNumber = true;
        }
    }

    private void clear() {
        display.setText("0");
        firstOperand = 0;
        operator = "";
        startNewNumber = true;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new EventDrivenCalculator().setVisible(true));
    }
}
