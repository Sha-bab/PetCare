import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class UserProfileApp extends JFrame {

    public UserProfileApp() {
        setTitle("🐶 User Profile");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(420, 680);
        setLocationRelativeTo(null);

        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBackground(new Color(232, 244, 253)); // Light sky blue tone

        // Top Bar
        JPanel topBar = new JPanel(new FlowLayout(FlowLayout.LEFT));
        topBar.setBackground(new Color(187, 222, 251)); // Soft blue
        topBar.setBorder(new EmptyBorder(12, 20, 12, 20));

        JLabel homeLabel = new JLabel("🏠 Home");
        homeLabel.setFont(new Font("SansSerif", Font.BOLD, 16));
        JLabel userProfileLabel = new JLabel(" > User Profile");
        userProfileLabel.setFont(new Font("SansSerif", Font.PLAIN, 16));

        topBar.add(homeLabel);
        topBar.add(userProfileLabel);
        mainPanel.add(topBar, BorderLayout.NORTH);

        // Content Panel
        JPanel contentPanel = new JPanel();
        contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.Y_AXIS));
        contentPanel.setBorder(new EmptyBorder(20, 20, 20, 20));
        contentPanel.setBackground(Color.WHITE);

        // Profile Header
        JPanel profileHeader = new JPanel(new FlowLayout(FlowLayout.LEFT));
        profileHeader.setOpaque(false);

        JLabel avatarIcon = new JLabel("🐶");
        avatarIcon.setFont(new Font("SansSerif", Font.PLAIN, 50));
        profileHeader.add(avatarIcon);
        profileHeader.add(Box.createHorizontalStrut(15));

        JLabel userNameLabel = new JLabel("Jessica Hart");
        userNameLabel.setFont(new Font("SansSerif", Font.BOLD, 22));
        profileHeader.add(userNameLabel);
        profileHeader.add(Box.createHorizontalGlue());

        JButton editButton = createBlueButton("✏️ Edit");
        profileHeader.add(editButton);
        profileHeader.setAlignmentX(Component.LEFT_ALIGNMENT);
        contentPanel.add(profileHeader);
        contentPanel.add(Box.createVerticalStrut(20));

        // Personal Info
        JLabel personalInfoLabel = createSectionLabel("📇 Personal Information");
        contentPanel.add(personalInfoLabel);
        contentPanel.add(Box.createVerticalStrut(10));
        contentPanel.add(createInfoItem("Name", "Jessica Hart"));
        contentPanel.add(createInfoItem("Email", "jessica.hart@example.com"));
        contentPanel.add(createInfoItem("Phone", "+1 234 567 890"));
        contentPanel.add(Box.createVerticalStrut(20));

        // My Pets Section
        JLabel myPetsLabel = createSectionLabel("🐾 My Pets");
        contentPanel.add(myPetsLabel);
        contentPanel.add(Box.createVerticalStrut(10));
        contentPanel.add(createPetItem("🐶 Buddy", "Dog, 3 years"));
        contentPanel.add(Box.createVerticalStrut(10));
        contentPanel.add(createPetItem("🐱 Whiskers", "Cat, 2 years"));

        JButton addPetButton = createBlueButton("➕ Add New Pet");
        addPetButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        contentPanel.add(Box.createVerticalStrut(10));
        contentPanel.add(addPetButton);
        contentPanel.add(Box.createVerticalStrut(20));

        // Health & Activity
        JLabel healthLogsLabel = createSectionLabel("📊 Health & Activity Logs");
        contentPanel.add(healthLogsLabel);
        contentPanel.add(Box.createVerticalStrut(10));
        contentPanel.add(createGraphPlaceholder("📈 Activity Trends"));
        contentPanel.add(Box.createVerticalStrut(10));
        contentPanel.add(createGraphPlaceholder("🩺 Health Metrics"));

        JScrollPane scrollPane = new JScrollPane(contentPanel);
        scrollPane.setBorder(null);
        mainPanel.add(scrollPane, BorderLayout.CENTER);

        // Bottom Nav
        JPanel bottomNav = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 10));
        bottomNav.setBackground(new Color(187, 222, 251)); // Soft blue
        bottomNav.setBorder(new EmptyBorder(10, 10, 10, 10));

        bottomNav.add(createNavButton("👤 Profile"));
        bottomNav.add(createNavButton("🏪 Store"));
        bottomNav.add(createNavButton("🖼️ Gallery"));

        mainPanel.add(bottomNav, BorderLayout.SOUTH);
        add(mainPanel);
        setVisible(true);
    }

    private JButton createBlueButton(String text) {
        JButton button = new JButton(text);
        button.setBackground(new Color(100, 181, 246)); // Medium Blue
        button.setForeground(Color.WHITE);
        button.setFont(new Font("SansSerif", Font.BOLD, 14));
        button.setFocusPainted(false);
        button.setBorder(BorderFactory.createEmptyBorder(8, 15, 8, 15));
        return button;
    }

    private JLabel createSectionLabel(String text) {
        JLabel label = new JLabel(text);
        label.setFont(new Font("SansSerif", Font.BOLD, 18));
        label.setAlignmentX(Component.LEFT_ALIGNMENT);
        return label;
    }

    private JPanel createInfoItem(String labelText, String valueText) {
        JPanel infoPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        infoPanel.setOpaque(false);
        JLabel label = new JLabel(labelText + ": ");
        label.setFont(new Font("SansSerif", Font.PLAIN, 16));
        JLabel value = new JLabel(valueText);
        value.setFont(new Font("SansSerif", Font.BOLD, 16));
        infoPanel.add(label);
        infoPanel.add(value);
        infoPanel.setAlignmentX(Component.LEFT_ALIGNMENT);
        return infoPanel;
    }

    private JPanel createPetItem(String name, String details) {
        JPanel petPanel = new JPanel(new BorderLayout());
        petPanel.setOpaque(false);
        JPanel infoPart = new JPanel();
        infoPart.setLayout(new BoxLayout(infoPart, BoxLayout.Y_AXIS));
        infoPart.setOpaque(false);

        JLabel nameLabel = new JLabel(name);
        nameLabel.setFont(new Font("SansSerif", Font.BOLD, 16));
        JLabel detailsLabel = new JLabel(details);
        detailsLabel.setFont(new Font("SansSerif", Font.PLAIN, 14));
        detailsLabel.setForeground(Color.GRAY);
        infoPart.add(nameLabel);
        infoPart.add(detailsLabel);

        JButton manageButton = createBlueButton("⚙️ Manage");

        petPanel.add(infoPart, BorderLayout.CENTER);
        petPanel.add(manageButton, BorderLayout.EAST);
        petPanel.setMaximumSize(new Dimension(Integer.MAX_VALUE, 60));
        return petPanel;
    }

    private JPanel createGraphPlaceholder(String title) {
        JPanel graphPanel = new JPanel(new BorderLayout());
        graphPanel.setBackground(new Color(224, 242, 254));
        graphPanel.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(187, 222, 251)),
                new EmptyBorder(10, 15, 10, 15)
        ));

        JLabel titleLabel = new JLabel(title);
        titleLabel.setFont(new Font("SansSerif", Font.BOLD, 16));
        graphPanel.add(titleLabel, BorderLayout.NORTH);

        JPanel placeholder = new JPanel();
        placeholder.setBackground(new Color(200, 230, 255));
        placeholder.setPreferredSize(new Dimension(300, 80));
        JLabel placeholderLabel = new JLabel("📉 Graph Placeholder");
        placeholderLabel.setForeground(Color.DARK_GRAY);
        placeholder.add(placeholderLabel);

        graphPanel.add(placeholder, BorderLayout.CENTER);
        return graphPanel;
    }

    private JButton createNavButton(String labelText) {
        JButton btn = new JButton(labelText);
        btn.setFont(new Font("SansSerif", Font.PLAIN, 14));
        btn.setFocusPainted(false);
        btn.setBackground(new Color(144, 202, 249)); // Blue
        btn.setForeground(Color.WHITE);
        btn.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
        return btn;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(UserProfileApp::new);
    }
}
