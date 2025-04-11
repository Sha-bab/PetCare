import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class PetDashboardApp extends JFrame {

    public PetDashboardApp() {
        setTitle("🐶 PetCare Dashboard");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 620);
        setLocationRelativeTo(null);

        // Main Panel
        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBackground(new Color(225, 245, 255)); // Light baby blue

        // Top Bar
        JPanel topBar = new JPanel(new BorderLayout());
        topBar.setBackground(new Color(180, 210, 255)); // Soft blue
        topBar.setBorder(new EmptyBorder(15, 20, 15, 20));

        JLabel petCareLabel = new JLabel("🐾 PetCare Dashboard");
        petCareLabel.setFont(new Font("SansSerif", Font.BOLD, 20));
        petCareLabel.setForeground(new Color(30, 60, 90));

        JButton userIcon = new JButton("👤");
        userIcon.setFont(new Font("SansSerif", Font.PLAIN, 18));
        userIcon.setFocusPainted(false);
        userIcon.setBorderPainted(false);
        userIcon.setContentAreaFilled(false);
        userIcon.setForeground(new Color(30, 60, 90));

        topBar.add(petCareLabel, BorderLayout.WEST);
        topBar.add(userIcon, BorderLayout.EAST);

        mainPanel.add(topBar, BorderLayout.NORTH);

        // Content Panel
        JPanel contentPanel = new JPanel();
        contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.Y_AXIS));
        contentPanel.setBackground(new Color(245, 250, 255));
        contentPanel.setBorder(new EmptyBorder(20, 20, 20, 20));

        JLabel dashboardOverviewLabel = new JLabel("🐶 My Pets");
        dashboardOverviewLabel.setFont(new Font("SansSerif", Font.BOLD, 22));
        dashboardOverviewLabel.setForeground(new Color(40, 70, 110));
        dashboardOverviewLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
        contentPanel.add(dashboardOverviewLabel);
        contentPanel.add(Box.createVerticalStrut(20));

        // Add pet cards
        contentPanel.add(createPetInfoPanel("Buddy", "Golden Retriever", "Health Records: ✅ Up to date", "Next Appointment: 🗓️ 15th Nov"));
        contentPanel.add(Box.createVerticalStrut(15));
        contentPanel.add(createPetInfoPanel("My Boy", "Siamese Cat", "Health Records: ⚠️ Due for checkup", "Next Appointment: 🗓️ 20th Nov"));

        JScrollPane scrollPane = new JScrollPane(contentPanel);
        scrollPane.setBorder(null);
        scrollPane.getVerticalScrollBar().setUnitIncrement(12);
        mainPanel.add(scrollPane, BorderLayout.CENTER);

        // Bottom Button Panel
        JPanel bottomPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 10));
        bottomPanel.setBackground(new Color(200, 230, 255));
        bottomPanel.setBorder(new EmptyBorder(10, 20, 10, 20));

        JButton addPetButton = new JButton("➕ Add Pet");
        styleButton(addPetButton);

        JButton scheduleButton = new JButton("📅 Schedule");
        styleButton(scheduleButton);

        bottomPanel.add(addPetButton);
        bottomPanel.add(scheduleButton);

        mainPanel.add(bottomPanel, BorderLayout.SOUTH);

        add(mainPanel);
        setVisible(true);
    }

    private void styleButton(JButton button) {
        button.setBackground(new Color(70, 130, 180)); // Steel blue
        button.setForeground(Color.WHITE);
        button.setFont(new Font("SansSerif", Font.BOLD, 16));
        button.setFocusPainted(false);
        button.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }

    private JPanel createPetInfoPanel(String petName, String breed, String healthRecord, String nextAppointment) {
        JPanel petPanel = new JPanel(new BorderLayout());
        petPanel.setBackground(new Color(230, 240, 255)); // Light pastel blue
        petPanel.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(180, 210, 240), 1),
                new EmptyBorder(15, 15, 15, 15)
        ));
        petPanel.setMaximumSize(new Dimension(Integer.MAX_VALUE, 100));

        // Left avatar section
        JPanel avatarPanel = new JPanel();
        avatarPanel.setPreferredSize(new Dimension(60, 60));
        avatarPanel.setBackground(new Color(200, 220, 255));
        avatarPanel.setLayout(new BorderLayout());

        JLabel avatar = new JLabel("🐕", SwingConstants.CENTER);
        avatar.setFont(new Font("SansSerif", Font.PLAIN, 28));
        avatarPanel.add(avatar, BorderLayout.CENTER);

        petPanel.add(avatarPanel, BorderLayout.WEST);
        petPanel.add(Box.createHorizontalStrut(15), BorderLayout.CENTER);

        // Right text info
        JPanel infoPanel = new JPanel();
        infoPanel.setLayout(new BoxLayout(infoPanel, BoxLayout.Y_AXIS));
        infoPanel.setOpaque(false);

        JLabel nameLabel = new JLabel(petName + " - " + breed);
        nameLabel.setFont(new Font("SansSerif", Font.BOLD, 16));
        nameLabel.setForeground(new Color(30, 60, 90));

        JLabel healthLabel = new JLabel(healthRecord);
        healthLabel.setFont(new Font("SansSerif", Font.PLAIN, 13));
        healthLabel.setForeground(new Color(60, 90, 110));

        JLabel appointmentLabel = new JLabel(nextAppointment);
        appointmentLabel.setFont(new Font("SansSerif", Font.PLAIN, 13));
        appointmentLabel.setForeground(new Color(60, 90, 110));

        infoPanel.add(nameLabel);
        infoPanel.add(Box.createVerticalStrut(5));
        infoPanel.add(healthLabel);
        infoPanel.add(Box.createVerticalStrut(3));
        infoPanel.add(appointmentLabel);

        petPanel.add(infoPanel, BorderLayout.EAST);

        return petPanel;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(PetDashboardApp::new);
    }
}
