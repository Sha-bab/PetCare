import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class UserProfileApp extends JFrame {

    public UserProfileApp() {
        setTitle("User Profile");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 650);
        setLocationRelativeTo(null);

        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBackground(new Color(240, 248, 255)); // Alice Blue

        // Top Bar
        JPanel topBar = new JPanel(new FlowLayout(FlowLayout.LEFT));
        topBar.setBackground(new Color(224, 238, 248)); // Light Cyan
        topBar.setBorder(new EmptyBorder(10, 15, 10, 15));

        JLabel homeLabel = new JLabel("🏠 Home");
        homeLabel.setFont(new Font("SansSerif", Font.BOLD, 16));
        JLabel userProfileLabel = new JLabel("User Profile");
        userProfileLabel.setFont(new Font("SansSerif", Font.PLAIN, 16));

        topBar.add(homeLabel);
        topBar.add(Box.createHorizontalStrut(10));
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
        JPanel avatarPlaceholder = new JPanel();
        avatarPlaceholder.setPreferredSize(new Dimension(60, 60));
        avatarPlaceholder.setMaximumSize(new Dimension(60, 60));
        avatarPlaceholder.setBackground(new Color(200, 200, 200)); // Light Gray
        JLabel avatarLabel = new JLabel("Avatar");
        avatarPlaceholder.add(avatarLabel);
        profileHeader.add(avatarPlaceholder);
        profileHeader.add(Box.createHorizontalStrut(15));
        JLabel userNameLabel = new JLabel("Jessica Hart");
        userNameLabel.setFont(new Font("SansSerif", Font.BOLD, 20));
        profileHeader.add(userNameLabel);
        profileHeader.add(Box.createHorizontalGlue());
        JButton editButton = new JButton("Edit");
        editButton.setBackground(new Color(173, 216, 230)); // Light Blue
        editButton.setForeground(Color.BLACK);
        editButton.setFont(new Font("SansSerif", Font.PLAIN, 14));
        editButton.setFocusPainted(false);
        editButton.setBorder(BorderFactory.createEmptyBorder(8, 15, 8, 15));
        profileHeader.add(editButton);
        profileHeader.setAlignmentX(Component.LEFT_ALIGNMENT);
        contentPanel.add(profileHeader);
        contentPanel.add(Box.createVerticalStrut(20));

        // Personal Information
        JLabel personalInfoLabel = new JLabel("Personal Information");
        personalInfoLabel.setFont(new Font("SansSerif", Font.BOLD, 18));
        personalInfoLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
        contentPanel.add(personalInfoLabel);
        contentPanel.add(Box.createVerticalStrut(10));

        contentPanel.add(createInfoItem("Name", "Jessica Hart"));
        contentPanel.add(Box.createVerticalStrut(5));
        contentPanel.add(createInfoItem("Email", "jessica.hart@example.com"));
        contentPanel.add(Box.createVerticalStrut(5));
        contentPanel.add(createInfoItem("Contact Number", "+1 234 567 890"));
        contentPanel.add(Box.createVerticalStrut(15));

        // My Pets
        JLabel myPetsLabel = new JLabel("My Pets");
        myPetsLabel.setFont(new Font("SansSerif", Font.BOLD, 18));
        myPetsLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
        contentPanel.add(myPetsLabel);
        contentPanel.add(Box.createVerticalStrut(10));

        contentPanel.add(createPetItem("Buddy", "Dog, 3 years"));
        contentPanel.add(Box.createVerticalStrut(10));
        contentPanel.add(createPetItem("Whiskers", "Cat, 2 years"));
        contentPanel.add(Box.createVerticalStrut(10));

        JButton addNewPetButton = new JButton("Add New Pet");
        addNewPetButton.setBackground(new Color(173, 216, 230)); // Light Blue
        addNewPetButton.setForeground(Color.BLACK);
        addNewPetButton.setFont(new Font("SansSerif", Font.PLAIN, 14));
        addNewPetButton.setFocusPainted(false);
        addNewPetButton.setBorder(BorderFactory.createEmptyBorder(8, 15, 8, 15));
        addNewPetButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        contentPanel.add(addNewPetButton);
        contentPanel.add(Box.createVerticalStrut(15));

        // Health & Activity Logs
        JLabel healthLogsLabel = new JLabel("Health & Activity Logs");
        healthLogsLabel.setFont(new Font("SansSerif", Font.BOLD, 18));
        healthLogsLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
        contentPanel.add(healthLogsLabel);
        contentPanel.add(Box.createVerticalStrut(10));

        contentPanel.add(createGraphPlaceholder("Activity Trends"));
        contentPanel.add(Box.createVerticalStrut(10));
        contentPanel.add(createGraphPlaceholder("Health Metrics"));

        JScrollPane scrollPane = new JScrollPane(contentPanel);
        scrollPane.setBorder(null);
        mainPanel.add(scrollPane, BorderLayout.CENTER);

        // Bottom Navigation
        JPanel bottomNav = new JPanel(new FlowLayout(FlowLayout.LEADING));
        bottomNav.setBackground(new Color(224, 238, 248)); // Light Cyan
        bottomNav.setBorder(new EmptyBorder(10, 30, 10, 30));

        JButton profileButtonBottom = new JButton("Profile");
        JButton storeButtonBottom = new JButton("Store");
        JButton galleryButtonBottom = new JButton("Gallery");

        Font bottomFont = new Font("SansSerif", Font.PLAIN, 14);
        profileButtonBottom.setFont(bottomFont);
        storeButtonBottom.setFont(bottomFont);
        galleryButtonBottom.setFont(bottomFont);

        bottomNav.add(profileButtonBottom);
        bottomNav.add(storeButtonBottom);
        bottomNav.add(galleryButtonBottom);

        mainPanel.add(bottomNav, BorderLayout.SOUTH);

        add(mainPanel);
        setVisible(true);
    }

    private JPanel createInfoItem(String labelText, String valueText) {
        JPanel infoPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        infoPanel.setOpaque(false);
        JLabel label = new JLabel(labelText);
        label.setFont(new Font("SansSerif", Font.PLAIN, 16));
        infoPanel.add(label);
        infoPanel.add(Box.createHorizontalStrut(10));
        JLabel value = new JLabel(valueText);
        value.setFont(new Font("SansSerif", Font.BOLD, 16));
        infoPanel.add(value);
        infoPanel.setAlignmentX(Component.LEFT_ALIGNMENT);
        return infoPanel;
    }

    private JPanel createPetItem(String name, String details) {
        JPanel petPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        petPanel.setOpaque(false);
        JPanel petAvatarPlaceholder = new JPanel();
        petAvatarPlaceholder.setPreferredSize(new Dimension(40, 40));
        petAvatarPlaceholder.setMaximumSize(new Dimension(40, 40));
        petAvatarPlaceholder.setBackground(new Color(220, 220, 220)); // Light Light Gray
        JLabel petAvatarLabel = new JLabel("Pet");
        petAvatarPlaceholder.add(petAvatarLabel);
        petPanel.add(petAvatarPlaceholder);
        petPanel.add(Box.createHorizontalStrut(10));
        // Fix: Initialize petInfo before using BoxLayout
        JPanel petInfo = new JPanel();
        petInfo.setLayout(new BoxLayout(petInfo, BoxLayout.Y_AXIS)); // Proper initialization
        petInfo.setOpaque(false);
        JLabel nameLabel = new JLabel(name);
        nameLabel.setFont(new Font("SansSerif", Font.BOLD, 16));
        nameLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
        petInfo.add(nameLabel);
        JLabel detailsLabel = new JLabel(details);
        detailsLabel.setFont(new Font("SansSerif", Font.PLAIN, 14));
        detailsLabel.setForeground(Color.GRAY);
        detailsLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
        petInfo.add(detailsLabel);
        petPanel.add(petInfo);
        petPanel.add(Box.createHorizontalGlue());
        JButton manageButton = new JButton("Manage");
        manageButton.setBackground(new Color(173, 216, 230)); // Light Blue
        manageButton.setForeground(Color.BLACK);
        manageButton.setFont(new Font("SansSerif", Font.PLAIN, 14));
        manageButton.setFocusPainted(false);
        manageButton.setBorder(BorderFactory.createEmptyBorder(8, 15, 8, 15));
        petPanel.add(manageButton);
        petPanel.setAlignmentX(Component.LEFT_ALIGNMENT);
        return petPanel;
    }

    private JPanel createGraphPlaceholder(String title) {
        JPanel graphPanel = new JPanel(new BorderLayout());
        graphPanel.setBackground(new Color(245, 245, 245)); // Light Gray
        graphPanel.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(220, 220, 220)), // Light Light Gray
                new EmptyBorder(10, 15, 10, 15)
        ));
        JLabel titleLabel = new JLabel(title);
        titleLabel.setFont(new Font("SansSerif", Font.BOLD, 16));
        graphPanel.add(titleLabel, BorderLayout.NORTH);
        JPanel placeholder = new JPanel();
        placeholder.setBackground(new Color(230, 230, 230)); // Slightly darker gray
        placeholder.setPreferredSize(new Dimension(300, 80));
        JLabel placeholderLabel = new JLabel("Graph Placeholder");
        placeholderLabel.setForeground(Color.GRAY);
        placeholder.add(placeholderLabel);
        graphPanel.add(placeholder, BorderLayout.CENTER);
        graphPanel.setAlignmentX(Component.LEFT_ALIGNMENT);
        return graphPanel;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(UserProfileApp::new);
    }
}
