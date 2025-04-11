import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class PetCareProDashboardApp extends JFrame {

    public PetCareProDashboardApp() {
        setTitle("🐶 PetCarePro Dashboard");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(420, 700);
        setLocationRelativeTo(null);

        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBackground(new Color(230, 245, 255)); // Soft baby blue

        // 🌟 Top Header
        JPanel topBar = new JPanel(new BorderLayout());
        topBar.setBackground(new Color(200, 230, 250)); // Light Cyan-Blue
        topBar.setBorder(new EmptyBorder(15, 20, 15, 20));

        JLabel petCareLabel = new JLabel("🐾 PetCarePro");
        petCareLabel.setFont(new Font("Segoe UI", Font.BOLD, 22));
        petCareLabel.setForeground(new Color(33, 64, 95));

        JButton notificationButton = new JButton("🔔");
        styleHeaderButton(notificationButton);

        topBar.add(petCareLabel, BorderLayout.WEST);
        topBar.add(notificationButton, BorderLayout.EAST);
        mainPanel.add(topBar, BorderLayout.NORTH);

        // 🌈 Center Content
        JPanel contentPanel = new JPanel();
        contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.Y_AXIS));
        contentPanel.setBackground(Color.WHITE);
        contentPanel.setBorder(new EmptyBorder(20, 20, 20, 20));

        JLabel welcomeLabel = new JLabel("Welcome back! 🐶");
        welcomeLabel.setFont(new Font("Segoe UI", Font.BOLD, 24));
        welcomeLabel.setForeground(new Color(30, 60, 90));
        welcomeLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
        contentPanel.add(welcomeLabel);
        contentPanel.add(Box.createVerticalStrut(20));

        // 💠 Feature Buttons Grid
        JPanel actionsPanel = new JPanel(new GridLayout(2, 2, 15, 15));
        actionsPanel.setOpaque(false);
        actionsPanel.setAlignmentX(Component.CENTER_ALIGNMENT);

        actionsPanel.add(createDashboardButton("🏥", "Health Records"));
        actionsPanel.add(createDashboardButton("📅", "Reminders"));
        actionsPanel.add(createDashboardButton("📍", "Find Services"));
        actionsPanel.add(createDashboardButton("🐾", "Manage Pets"));

        contentPanel.add(actionsPanel);
        contentPanel.add(Box.createVerticalStrut(30));

        // 🐕 "Your Pets" Section
        JLabel petsTitle = new JLabel("🐶 Your Pets");
        petsTitle.setFont(new Font("Segoe UI", Font.BOLD, 18));
        petsTitle.setForeground(new Color(45, 75, 105));
        petsTitle.setAlignmentX(Component.LEFT_ALIGNMENT);
        contentPanel.add(petsTitle);
        contentPanel.add(Box.createVerticalStrut(10));

        JPanel yourPetsPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 10));
        yourPetsPanel.setBackground(new Color(240, 250, 255));
        yourPetsPanel.setBorder(BorderFactory.createLineBorder(new Color(190, 220, 240), 1));
        yourPetsPanel.add(createPetPlaceholder("Buddy"));
        yourPetsPanel.add(createPetPlaceholder("Luna"));
        yourPetsPanel.add(createPetPlaceholder("Max"));

        contentPanel.add(yourPetsPanel);

        JScrollPane scrollPane = new JScrollPane(contentPanel);
        scrollPane.setBorder(null);
        scrollPane.setBackground(new Color(230, 245, 255));
        mainPanel.add(scrollPane, BorderLayout.CENTER);

        // 📱 Bottom Navigation Bar
        JPanel bottomNav = new JPanel(new FlowLayout(FlowLayout.CENTER, 40, 10));
        bottomNav.setBackground(new Color(200, 230, 250));
        bottomNav.setBorder(new EmptyBorder(10, 10, 10, 10));

        bottomNav.add(createNavButton("🏠", "Home"));
        bottomNav.add(createNavButton("📅", "Appointments"));
        bottomNav.add(createNavButton("🐶", "Pets"));
        bottomNav.add(createNavButton("👤", "Profile"));

        mainPanel.add(bottomNav, BorderLayout.SOUTH);

        add(mainPanel);
        setVisible(true);
    }

    private JButton createDashboardButton(String icon, String label) {
        JButton button = new JButton("<html><center>" + icon + "<br>" + label + "</center></html>");
        button.setBackground(new Color(220, 235, 250));
        button.setForeground(new Color(25, 55, 85));
        button.setFont(new Font("Segoe UI", Font.BOLD, 14));
        button.setFocusPainted(false);
        button.setBorder(BorderFactory.createLineBorder(new Color(180, 210, 235)));
        return button;
    }

    private JPanel createPetPlaceholder(String name) {
        JPanel placeholder = new JPanel();
        placeholder.setPreferredSize(new Dimension(80, 90));
        placeholder.setLayout(new BorderLayout());
        placeholder.setBackground(new Color(210, 230, 250));
        placeholder.setBorder(BorderFactory.createLineBorder(new Color(160, 190, 220)));

        JLabel icon = new JLabel("🐕", SwingConstants.CENTER);
        icon.setFont(new Font("Segoe UI", Font.PLAIN, 26));

        JLabel petName = new JLabel(name, SwingConstants.CENTER);
        petName.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        petName.setForeground(new Color(50, 70, 100));

        placeholder.add(icon, BorderLayout.CENTER);
        placeholder.add(petName, BorderLayout.SOUTH);
        return placeholder;
    }

    private JButton createNavButton(String icon, String label) {
        JButton button = new JButton("<html><center>" + icon + "<br>" + label + "</center></html>");
        button.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        button.setFocusPainted(false);
        button.setBorder(BorderFactory.createEmptyBorder(8, 15, 8, 15));
        button.setBackground(new Color(230, 245, 255));
        return button;
    }

    private void styleHeaderButton(JButton button) {
        button.setBackground(new Color(200, 230, 250));
        button.setBorderPainted(false);
        button.setFocusPainted(false);
        button.setFont(new Font("Segoe UI", Font.PLAIN, 20));
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(PetCareProDashboardApp::new);
    }
}
