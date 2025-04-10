import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionListener;

public class PetCareProDashboardApp extends JFrame {

    public PetCareProDashboardApp() {
        setTitle("PetCarePro Dashboard");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 650);
        setLocationRelativeTo(null);

        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBackground(new Color(240, 248, 255)); // Alice Blue

        // Top Bar
        JPanel topBar = new JPanel(new FlowLayout(FlowLayout.LEFT));
        topBar.setBackground(new Color(224, 238, 248)); // Light Cyan
        topBar.setBorder(new EmptyBorder(10, 15, 10, 15));

        JLabel petCareLabel = new JLabel("🐾 PetCare");
        petCareLabel.setFont(new Font("SansSerif", Font.BOLD, 20));

        topBar.add(petCareLabel);
        topBar.add(Box.createHorizontalGlue());

        JButton notificationButton = new JButton("🔔");
        notificationButton.setFont(new Font("SansSerif", Font.PLAIN, 20));
        notificationButton.setFocusPainted(false);
        notificationButton.setBorderPainted(false);
        notificationButton.setBackground(new Color(224, 238, 248)); // Light Cyan
        topBar.add(notificationButton);

        mainPanel.add(topBar, BorderLayout.NORTH);

        // Content Panel
        JPanel contentPanel = new JPanel();
        contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.Y_AXIS));
        contentPanel.setBorder(new EmptyBorder(20, 20, 20, 20));
        contentPanel.setBackground(Color.WHITE);

        JLabel welcomeLabel = new JLabel("Welcome to PetCarePro!");
        welcomeLabel.setFont(new Font("SansSerif", Font.BOLD, 24));
        welcomeLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
        contentPanel.add(welcomeLabel);
        contentPanel.add(Box.createVerticalStrut(20));

        // Action Buttons Grid
        JPanel actionsPanel = new JPanel(new GridLayout(2, 2, 15, 15));
        actionsPanel.setOpaque(false);
        actionsPanel.setAlignmentX(Component.CENTER_ALIGNMENT);

        actionsPanel.add(createDashboardButton("🏥 Health Records"));
        actionsPanel.add(createDashboardButton("📅 Set Reminders"));
        actionsPanel.add(createDashboardButton("📍 Find Services"));
        actionsPanel.add(createDashboardButton("🐾 Manage Pets"));

        contentPanel.add(actionsPanel);
        contentPanel.add(Box.createVerticalStrut(30));

        // Your Pets Section
        JPanel yourPetsPanel = new JPanel();
        yourPetsPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 15, 10));
        yourPetsPanel.setBackground(new Color(230, 230, 230)); // Light Gray
        yourPetsPanel.setBorder(new EmptyBorder(15, 15, 15, 15));
        yourPetsPanel.setAlignmentX(Component.LEFT_ALIGNMENT);

        JLabel yourPetsLabel = new JLabel("Your Pets");
        yourPetsLabel.setFont(new Font("SansSerif", Font.BOLD, 18));
        yourPetsLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
        yourPetsPanel.add(yourPetsLabel);
        yourPetsPanel.add(Box.createHorizontalStrut(10));

        // Pet Image Placeholders
        yourPetsPanel.add(createPetPlaceholder());
        yourPetsPanel.add(createPetPlaceholder());
        yourPetsPanel.add(createPetPlaceholder());

        contentPanel.add(yourPetsPanel);

        JScrollPane scrollPane = new JScrollPane(contentPanel);
        scrollPane.setBorder(null);
        mainPanel.add(scrollPane, BorderLayout.CENTER);

        // Bottom Navigation
        JPanel bottomNav = new JPanel(new FlowLayout(FlowLayout.LEADING, 40, 10));
        bottomNav.setBackground(new Color(224, 238, 248)); // Light Cyan
        bottomNav.setBorder(new EmptyBorder(10, 20, 10, 20));

        JButton homeButtonBottom = new JButton("🏠");
        JButton appointmentButtonBottom = new JButton("📅");
        JButton petIconBottom = new JButton("🐾");
        JButton profileButtonBottom = new JButton("👤");

        Font bottomFont = new Font("SansSerif", Font.PLAIN, 20);
        homeButtonBottom.setFont(bottomFont);
        appointmentButtonBottom.setFont(bottomFont);
        petIconBottom.setFont(bottomFont);
        profileButtonBottom.setFont(bottomFont);

        homeButtonBottom.setFocusPainted(false);
        homeButtonBottom.setBorderPainted(false);
        homeButtonBottom.setBackground(new Color(224, 238, 248));
        appointmentButtonBottom.setFocusPainted(false);
        appointmentButtonBottom.setBorderPainted(false);
        appointmentButtonBottom.setBackground(new Color(224, 238, 248));
        petIconBottom.setFocusPainted(false);
        petIconBottom.setBorderPainted(false);
        petIconBottom.setBackground(new Color(224, 238, 248));
        profileButtonBottom.setFocusPainted(false);
        profileButtonBottom.setBorderPainted(false);
        profileButtonBottom.setBackground(new Color(224, 238, 248));

        bottomNav.add(homeButtonBottom);
        bottomNav.add(appointmentButtonBottom);
        bottomNav.add(petIconBottom);
        bottomNav.add(profileButtonBottom);

        mainPanel.add(bottomNav, BorderLayout.SOUTH);

        add(mainPanel);
        setVisible(true);
    }

    private JButton createDashboardButton(String text) {
        JButton button = new JButton(text);
        button.setBackground(new Color(220, 220, 220)); // Light Gray
        button.setForeground(Color.BLACK);
        button.setFont(new Font("SansSerif", Font.BOLD, 16));
        button.setFocusPainted(false);
        button.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        button.setHorizontalTextPosition(SwingConstants.CENTER);
        button.setVerticalTextPosition(SwingConstants.BOTTOM);
        // Add icon placeholders (you can replace with actual icon drawing or labels)
        if (text.contains("Health")) button.setText("🏥\nHealth Records");
        else if (text.contains("Reminders")) button.setText("📅\nSet Reminders");
        else if (text.contains("Find")) button.setText("📍\nFind Services");
        else if (text.contains("Manage")) button.setText("🐾\nManage Pets");
        return button;
    }

    private JPanel createPetPlaceholder() {
        JPanel placeholder = new JPanel();
        placeholder.setPreferredSize(new Dimension(70, 70));
        placeholder.setMaximumSize(new Dimension(70, 70));
        placeholder.setBackground(new Color(200, 200, 200)); // Light Gray
        placeholder.setBorder(BorderFactory.createLineBorder(new Color(170, 170, 170))); // Slightly darker gray
        JLabel label = new JLabel("Pet");
        label.setForeground(Color.GRAY);
        placeholder.add(label);
        return placeholder;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(PetCareProDashboardApp::new);
    }
}