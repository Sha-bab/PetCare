import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class ProductDetailsApp extends JFrame {

    public ProductDetailsApp() {
        setTitle("Product Details");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 600);
        setLocationRelativeTo(null);

        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBackground(new Color(240, 248, 255)); // Alice Blue

        // Top Bar
        JPanel topBar = new JPanel(new FlowLayout(FlowLayout.LEFT));
        topBar.setBackground(new Color(224, 238, 248)); // Light Cyan
        topBar.setBorder(new EmptyBorder(10, 15, 10, 15));

        JLabel backArrow = new JLabel("←");
        backArrow.setFont(new Font("SansSerif", Font.BOLD, 20));
        JLabel productDetailsLabel = new JLabel("Product Details");
        productDetailsLabel.setFont(new Font("SansSerif", Font.BOLD, 16));

        topBar.add(backArrow);
        topBar.add(Box.createHorizontalStrut(10));
        topBar.add(productDetailsLabel);
        topBar.add(Box.createHorizontalGlue());
        topBar.add(new JLabel("\u2630")); // Hamburger menu

        mainPanel.add(topBar, BorderLayout.NORTH);

        // Content Panel
        JPanel contentPanel = new JPanel();
        contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.Y_AXIS));
        contentPanel.setBorder(new EmptyBorder(20, 20, 20, 20));
        contentPanel.setBackground(Color.WHITE);

        // Pet Wellness Section
        JPanel petWellnessPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        petWellnessPanel.setOpaque(false);
        JPanel avatarPlaceholder = new JPanel();
        avatarPlaceholder.setPreferredSize(new Dimension(40, 40));
        avatarPlaceholder.setMaximumSize(new Dimension(40, 40));
        avatarPlaceholder.setBackground(new Color(200, 200, 200)); // Light Gray
        JLabel avatarLabel = new JLabel("Avatar");
        avatarPlaceholder.add(avatarLabel);
        petWellnessPanel.add(avatarPlaceholder);
        petWellnessPanel.add(Box.createHorizontalStrut(10));
        JLabel petWellnessLabel = new JLabel("Pet Wellness");
        petWellnessLabel.setFont(new Font("SansSerif", Font.BOLD, 16));
        petWellnessPanel.add(petWellnessLabel);
        petWellnessPanel.setAlignmentX(Component.LEFT_ALIGNMENT);
        contentPanel.add(petWellnessPanel);
        contentPanel.add(Box.createVerticalStrut(15));

        // Today's Section
        JLabel todaysLabel = new JLabel("Today's");
        todaysLabel.setFont(new Font("SansSerif", Font.BOLD, 18));
        todaysLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
        contentPanel.add(todaysLabel);
        contentPanel.add(Box.createVerticalStrut(10));

        JPanel manageHealthPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        manageHealthPanel.setBackground(new Color(220, 230, 241)); // Light Blue-Gray
        manageHealthPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
        JLabel checkbox = new JLabel("✓");
        checkbox.setFont(new Font("SansSerif", Font.BOLD, 16));
        manageHealthPanel.add(checkbox);
        manageHealthPanel.add(Box.createHorizontalStrut(5));
        JLabel manageLabel = new JLabel("Manage Pet's Health");
        manageLabel.setFont(new Font("SansSerif", Font.PLAIN, 16));
        manageHealthPanel.add(manageLabel);
        manageHealthPanel.setAlignmentX(Component.LEFT_ALIGNMENT);
        contentPanel.add(manageHealthPanel);
        contentPanel.add(Box.createVerticalStrut(10));

        // Monthly Health Log Section
        JLabel logTitleLabel = new JLabel("Manage Pet's Monthly Health Log");
        logTitleLabel.setFont(new Font("SansSerif", Font.BOLD, 18));
        logTitleLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
        contentPanel.add(logTitleLabel);
        contentPanel.add(Box.createVerticalStrut(5));

        JLabel logDescriptionLabel = new JLabel("Record pet's health updates for a happy and healthy companion");
        logDescriptionLabel.setFont(new Font("SansSerif", Font.PLAIN, 14));
        logDescriptionLabel.setForeground(Color.GRAY);
        logDescriptionLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
        contentPanel.add(logDescriptionLabel);
        contentPanel.add(Box.createVerticalStrut(15));

        // Input Fields
        contentPanel.add(createInputField("Type of Pet", "Log"));
        contentPanel.add(Box.createVerticalStrut(10));
        contentPanel.add(createInputField("Health Priority", "High"));
        contentPanel.add(Box.createVerticalStrut(10));
        contentPanel.add(createInputField("Health", "Add"));
        contentPanel.add(Box.createVerticalStrut(20));

        // Uploads Section
        JLabel uploadsLabel = new JLabel("Uploads");
        uploadsLabel.setFont(new Font("SansSerif", Font.BOLD, 18));
        uploadsLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
        contentPanel.add(uploadsLabel);
        contentPanel.add(Box.createVerticalStrut(10));

        contentPanel.add(createUploadItem("📄 Nutrition Log Sheet"));
        contentPanel.add(Box.createVerticalStrut(5));
        contentPanel.add(createUploadItem("\uD83D\uDC3E Pet Health"));

        // Submit Button
        JButton submitButton = new JButton("Submit");
        submitButton.setBackground(new Color(70, 130, 180)); // Steel Blue
        submitButton.setForeground(Color.WHITE);
        submitButton.setFont(new Font("SansSerif", Font.BOLD, 16));
        submitButton.setFocusPainted(false);
        submitButton.setBorder(BorderFactory.createEmptyBorder(10, 30, 10, 30));
        submitButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        contentPanel.add(Box.createVerticalStrut(30));
        contentPanel.add(submitButton);

        JScrollPane scrollPane = new JScrollPane(contentPanel);
        scrollPane.setBorder(null);
        mainPanel.add(scrollPane, BorderLayout.CENTER);

        add(mainPanel);
        setVisible(true);
    }

    private JPanel createInputField(String labelText, String buttonText) {
        JPanel inputPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        inputPanel.setOpaque(false);
        JLabel label = new JLabel(labelText);
        label.setFont(new Font("SansSerif", Font.PLAIN, 16));
        inputPanel.add(label);
        inputPanel.add(Box.createHorizontalGlue());
        JButton button = new JButton(buttonText);
        button.setBackground(new Color(220, 220, 220)); // Light Gray
        button.setForeground(Color.BLACK);
        button.setFont(new Font("SansSerif", Font.PLAIN, 14));
        button.setFocusPainted(false);
        button.setBorder(BorderFactory.createEmptyBorder(8, 15, 8, 15));
        inputPanel.add(button);
        inputPanel.setAlignmentX(Component.LEFT_ALIGNMENT);
        return inputPanel;
    }

    private JPanel createUploadItem(String text) {
        JPanel uploadPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        uploadPanel.setOpaque(false);
        JLabel itemLabel = new JLabel(text);
        itemLabel.setFont(new Font("SansSerif", Font.PLAIN, 16));
        uploadPanel.add(itemLabel);
        uploadPanel.setAlignmentX(Component.LEFT_ALIGNMENT);
        return uploadPanel;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(ProductDetailsApp::new);
    }
}