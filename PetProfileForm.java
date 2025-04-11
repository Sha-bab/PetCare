import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class PetProfileForm extends JFrame {

    public PetProfileForm() {
        setTitle("🐶 Pet Profile");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(380, 460);
        setLocationRelativeTo(null);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.setBackground(new Color(230, 245, 255)); // Light blue background
        mainPanel.setBorder(new EmptyBorder(20, 20, 20, 20));

        JLabel titleLabel = new JLabel("🐾 Pet Profile");
        titleLabel.setFont(new Font("SansSerif", Font.BOLD, 26));
        titleLabel.setForeground(new Color(25, 25, 112)); // Midnight Blue
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        mainPanel.add(titleLabel);
        mainPanel.add(Box.createVerticalStrut(25));

        mainPanel.add(createInputField("🐶 Pet Name", "Enter pet's name"));
        mainPanel.add(Box.createVerticalStrut(18));

        mainPanel.add(createInputField("📘 Breed", "Enter breed"));
        mainPanel.add(Box.createVerticalStrut(18));

        mainPanel.add(createAgeInputField("🎂 Age", "3"));
        mainPanel.add(Box.createVerticalStrut(18));

        mainPanel.add(createMedicalHistoryField("🩺 Medical History", "Enter medical history"));
        mainPanel.add(Box.createVerticalStrut(20));

        JButton saveButton = new JButton("💾 Save Profile");
        saveButton.setFont(new Font("SansSerif", Font.BOLD, 16));
        saveButton.setBackground(new Color(70, 130, 180)); // Steel Blue
        saveButton.setForeground(Color.WHITE);
        saveButton.setFocusPainted(false);
        saveButton.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
        saveButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        mainPanel.add(saveButton);

        JScrollPane scrollPane = new JScrollPane(mainPanel);
        scrollPane.setBorder(null);
        add(scrollPane);

        setVisible(true);
    }

    private JPanel createInputField(String labelText, String placeholderText) {
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new BoxLayout(inputPanel, BoxLayout.Y_AXIS));
        inputPanel.setOpaque(false);

        JLabel label = new JLabel(labelText);
        label.setFont(new Font("SansSerif", Font.BOLD, 16));
        label.setForeground(new Color(25, 25, 112));
        inputPanel.add(label);
        inputPanel.add(Box.createVerticalStrut(5));

        JTextField textField = new JTextField();
        textField.setText(placeholderText);
        textField.setFont(new Font("SansSerif", Font.PLAIN, 14));
        textField.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(173, 216, 230)), // Light Blue
                new EmptyBorder(8, 10, 8, 10)
        ));
        inputPanel.add(textField);

        return inputPanel;
    }

    private JPanel createAgeInputField(String labelText, String placeholderText) {
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new BoxLayout(inputPanel, BoxLayout.Y_AXIS));
        inputPanel.setOpaque(false);

        JLabel label = new JLabel(labelText);
        label.setFont(new Font("SansSerif", Font.BOLD, 16));
        label.setForeground(new Color(25, 25, 112));
        inputPanel.add(label);
        inputPanel.add(Box.createVerticalStrut(5));

        JTextField textField = new JTextField(placeholderText, 5);
        textField.setFont(new Font("SansSerif", Font.PLAIN, 14));
        textField.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(173, 216, 230)), // Light Blue
                new EmptyBorder(8, 10, 8, 10)
        ));
        inputPanel.add(textField);

        return inputPanel;
    }

    private JPanel createMedicalHistoryField(String labelText, String placeholderText) {
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new BoxLayout(inputPanel, BoxLayout.Y_AXIS));
        inputPanel.setOpaque(false);

        JLabel label = new JLabel(labelText);
        label.setFont(new Font("SansSerif", Font.BOLD, 16));
        label.setForeground(new Color(25, 25, 112));
        inputPanel.add(label);
        inputPanel.add(Box.createVerticalStrut(5));

        JTextArea textArea = new JTextArea(placeholderText, 4, 20);
        textArea.setFont(new Font("SansSerif", Font.PLAIN, 14));
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textArea.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(173, 216, 230)), // Light Blue
                new EmptyBorder(8, 10, 8, 10)
        ));
        JScrollPane scrollPane = new JScrollPane(textArea);
        inputPanel.add(scrollPane);

        return inputPanel;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(PetProfileForm::new);
    }
}
