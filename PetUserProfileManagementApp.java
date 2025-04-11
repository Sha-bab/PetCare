import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import javax.swing.ImageIcon;

public class PetUserProfileManagementApp extends JFrame {

    public PetUserProfileManagementApp() {
        setTitle("Pet and User Profile Management");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 650);
        setLocationRelativeTo(null);

        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBackground(new Color(240, 248, 255)); // Alice Blue

        // Top Bar with Dog Icon
        JPanel topBar = new JPanel(new FlowLayout(FlowLayout.LEFT));
        topBar.setBackground(new Color(70, 130, 180)); // Steel Blue
        topBar.setBorder(new EmptyBorder(10, 15, 10, 15));

        JLabel petCareLabel = new JLabel("🐾 PetCare");
        petCareLabel.setFont(new Font("SansSerif", Font.BOLD, 20));
        petCareLabel.setForeground(Color.WHITE);

        topBar.add(petCareLabel);
        topBar.add(Box.createHorizontalGlue());

        // Adding dog icon to the top bar
        ImageIcon dogIcon = new ImageIcon("path_to_dog_icon.png"); // Add path to dog icon
        JLabel dogLabel = new JLabel(dogIcon);
        topBar.add(dogLabel);

        JButton saveButton = new JButton("Save");
        saveButton.setBackground(new Color(176, 224, 230)); // Powder Blue
        saveButton.setForeground(Color.BLACK);
        saveButton.setFont(new Font("SansSerif", Font.BOLD, 16));
        saveButton.setFocusPainted(false);
        saveButton.setBorder(BorderFactory.createEmptyBorder(8, 15, 8, 15));
        topBar.add(saveButton);

        mainPanel.add(topBar, BorderLayout.NORTH);

        // Tab Buttons
        JPanel tabPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        tabPanel.setBackground(new Color(173, 216, 230)); // Light Steel Blue
        tabPanel.setBorder(new EmptyBorder(10, 15, 10, 15));

        JButton petProfileTab = new JButton("Pet Profile");
        petProfileTab.setBackground(new Color(70, 130, 180)); // Steel Blue
        petProfileTab.setForeground(Color.WHITE);
        petProfileTab.setFont(new Font("SansSerif", Font.BOLD, 16));
        petProfileTab.setFocusPainted(false);
        petProfileTab.setBorder(BorderFactory.createEmptyBorder(8, 20, 8, 20));

        JButton userProfileTab = new JButton("User Profile");
        userProfileTab.setBackground(new Color(135, 206, 235)); // Sky Blue
        userProfileTab.setForeground(Color.BLACK);
        userProfileTab.setFont(new Font("SansSerif", Font.PLAIN, 16));
        userProfileTab.setFocusPainted(false);
        userProfileTab.setBorder(BorderFactory.createEmptyBorder(8, 20, 8, 20));

        tabPanel.add(petProfileTab);
        tabPanel.add(userProfileTab);

        mainPanel.add(tabPanel, BorderLayout.CENTER);

        // Pet Profile Form
        JPanel petProfilePanel = new JPanel();
        petProfilePanel.setLayout(new BoxLayout(petProfilePanel, BoxLayout.Y_AXIS));
        petProfilePanel.setBackground(new Color(70, 130, 180)); // Steel Blue
        petProfilePanel.setBorder(new EmptyBorder(20, 20, 20, 20));

        JLabel petProfileTitle = new JLabel("Pet Profile");
        petProfileTitle.setFont(new Font("SansSerif", Font.BOLD, 20));
        petProfileTitle.setForeground(Color.WHITE);
        petProfileTitle.setAlignmentX(Component.LEFT_ALIGNMENT);
        petProfilePanel.add(petProfileTitle);
        petProfilePanel.add(Box.createVerticalStrut(15));

        petProfilePanel.add(createInputField("Pet Name", "Enter pet's name"));
        petProfilePanel.add(Box.createVerticalStrut(10));
        petProfilePanel.add(createInputField("Breed", "Enter breed"));
        petProfilePanel.add(Box.createVerticalStrut(10));
        petProfilePanel.add(createAgeInputField("Age", "138"));
        petProfilePanel.add(Box.createVerticalStrut(10));
        petProfilePanel.add(createMedicalHistoryField("Medical History", "Enter medical history"));

        JScrollPane scrollPane = new JScrollPane(petProfilePanel);
        scrollPane.setBorder(null);
        mainPanel.add(scrollPane, BorderLayout.SOUTH);

        // Bottom Navigation with Dog and Cart Icons
        JPanel bottomNav = new JPanel(new FlowLayout(FlowLayout.CENTER, 30, 10));
        bottomNav.setBackground(new Color(173, 216, 230)); // Light Steel Blue
        bottomNav.setBorder(new EmptyBorder(10, 20, 10, 20));

        JButton homeButton = new JButton("🏠");
        JButton cartButton = new JButton("🛒");
        JButton chatButton = new JButton("💬");
        JButton heartButton = new JButton("❤️");

        Font bottomFont = new Font("SansSerif", Font.PLAIN, 20);
        homeButton.setFont(bottomFont);
        cartButton.setFont(bottomFont);
        chatButton.setFont(bottomFont);
        heartButton.setFont(bottomFont);

        homeButton.setFocusPainted(false);
        homeButton.setBorderPainted(false);
        homeButton.setBackground(new Color(173, 216, 230));
        cartButton.setFocusPainted(false);
        cartButton.setBorderPainted(false);
        cartButton.setBackground(new Color(173, 216, 230));
        chatButton.setFocusPainted(false);
        chatButton.setBorderPainted(false);
        chatButton.setBackground(new Color(173, 216, 230));
        heartButton.setFocusPainted(false);
        heartButton.setBorderPainted(false);
        heartButton.setBackground(new Color(173, 216, 230));

        bottomNav.add(homeButton);
        bottomNav.add(cartButton);
        bottomNav.add(chatButton);
        bottomNav.add(heartButton);

        mainPanel.add(bottomNav, BorderLayout.PAGE_END);

        add(mainPanel);
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
        SwingUtilities.invokeLater(PetUserProfileManagementApp::new);
    }
}
