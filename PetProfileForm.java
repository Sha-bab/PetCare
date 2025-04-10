import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class PetProfileForm extends JFrame {

    public PetProfileForm() {
        setTitle("Pet Profile");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(350, 400);
        setLocationRelativeTo(null);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.setBackground(new Color(47, 79, 79)); // Dark Slate Gray
        mainPanel.setBorder(new EmptyBorder(20, 20, 20, 20));

        JLabel titleLabel = new JLabel("Pet Profile");
        titleLabel.setFont(new Font("SansSerif", Font.BOLD, 24));
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
        mainPanel.add(titleLabel);
        mainPanel.add(Box.createVerticalStrut(20));

        mainPanel.add(createInputField("Pet Name", "Enter pet's name"));
        mainPanel.add(Box.createVerticalStrut(15));

        mainPanel.add(createInputField("Breed", "Enter breed"));
        mainPanel.add(Box.createVerticalStrut(15));

        mainPanel.add(createAgeInputField("Age", "138"));
        mainPanel.add(Box.createVerticalStrut(15));

        mainPanel.add(createMedicalHistoryField("Medical History", "Enter medical history"));

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
        label.setFont(new Font("SansSerif", Font.PLAIN, 16));
        label.setForeground(Color.WHITE);
        label.setAlignmentX(Component.LEFT_ALIGNMENT);
        inputPanel.add(label);
        inputPanel.add(Box.createVerticalStrut(5));
        JTextField textField = new JTextField(placeholderText);
        textField.setFont(new Font("SansSerif", Font.PLAIN, 14));
        inputPanel.add(textField);
        inputPanel.setAlignmentX(Component.LEFT_ALIGNMENT);
        return inputPanel;
    }

    private JPanel createAgeInputField(String labelText, String placeholderText) {
        JPanel inputPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        inputPanel.setOpaque(false);
        JLabel label = new JLabel(labelText);
        label.setFont(new Font("SansSerif", Font.PLAIN, 16));
        label.setForeground(Color.WHITE);
        inputPanel.add(label);
        inputPanel.add(Box.createHorizontalStrut(10));
        JTextField textField = new JTextField(placeholderText, 5);
        textField.setFont(new Font("SansSerif", Font.PLAIN, 14));
        inputPanel.add(textField);
        // Placeholder for the spinner icon
        JLabel spinnerIcon = new JLabel("⚙");
        spinnerIcon.setFont(new Font("SansSerif", Font.PLAIN, 16));
        inputPanel.add(spinnerIcon);
        inputPanel.setAlignmentX(Component.LEFT_ALIGNMENT);
        return inputPanel;
    }

    private JPanel createMedicalHistoryField(String labelText, String placeholderText) {
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new BoxLayout(inputPanel, BoxLayout.Y_AXIS));
        inputPanel.setOpaque(false);
        JLabel label = new JLabel(labelText);
        label.setFont(new Font("SansSerif", Font.PLAIN, 16));
        label.setForeground(Color.WHITE);
        label.setAlignmentX(Component.LEFT_ALIGNMENT);
        inputPanel.add(label);
        inputPanel.add(Box.createVerticalStrut(5));
        JTextArea textArea = new JTextArea(placeholderText, 3, 20);
        textArea.setFont(new Font("SansSerif", Font.PLAIN, 14));
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        JScrollPane scrollPane = new JScrollPane(textArea);
        inputPanel.add(scrollPane);
        inputPanel.setAlignmentX(Component.LEFT_ALIGNMENT);
        return inputPanel;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(PetProfileForm::new);
    }
}