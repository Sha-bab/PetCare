import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class PetDashboardApp extends JFrame {

    public PetDashboardApp() {
        setTitle("Pet Dashboard");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 600);
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

        JButton userIcon = new JButton("👤");
        userIcon.setFont(new Font("SansSerif", Font.PLAIN, 20));
        userIcon.setFocusPainted(false);
        userIcon.setBorderPainted(false);
        userIcon.setBackground(new Color(224, 238, 248)); // Light Cyan
        topBar.add(userIcon);

        mainPanel.add(topBar, BorderLayout.NORTH);

        // Content Panel
        JPanel contentPanel = new JPanel();
        contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.Y_AXIS));
        contentPanel.setBorder(new EmptyBorder(20, 20, 20, 20));
        contentPanel.setBackground(Color.WHITE);

        JLabel dashboardOverviewLabel = new JLabel("Dashboard Overview");
        dashboardOverviewLabel.setFont(new Font("SansSerif", Font.BOLD, 22));
        dashboardOverviewLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
        contentPanel.add(dashboardOverviewLabel);
        contentPanel.add(Box.createVerticalStrut(15));

        // Pet 1: Buddy
        contentPanel.add(createPetInfoPanel("Buddy", "Health Records: Up to date", "Next Appointment: 15th Nov"));
        contentPanel.add(Box.createVerticalStrut(15));

        // Pet 2: My Boy
        contentPanel.add(createPetInfoPanel("My Boy", "Siamese Cat", "Health Records: Due for checkup", "Next Appointment: 20th Nov"));

        JScrollPane scrollPane = new JScrollPane(contentPanel);
        scrollPane.setBorder(null);
        mainPanel.add(scrollPane, BorderLayout.CENTER);

        // Bottom Buttons
        JPanel bottomButtonPanel = new JPanel(new FlowLayout(FlowLayout.LEADING, 30, 15));
        bottomButtonPanel.setBackground(new Color(240, 248, 255)); // Alice Blue
        bottomButtonPanel.setBorder(new EmptyBorder(15, 15, 15, 15));

        JButton addPetButton = new JButton("+ Add Pet");
        addPetButton.setBackground(new Color(70, 130, 180)); // Steel Blue
        addPetButton.setForeground(Color.WHITE);
        addPetButton.setFont(new Font("SansSerif", Font.BOLD, 16));
        addPetButton.setFocusPainted(false);
        addPetButton.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));

        JButton scheduleButton = new JButton("\uD83D\uDCC5 Schedule");
        scheduleButton.setBackground(new Color(70, 130, 180)); // Steel Blue
        scheduleButton.setForeground(Color.WHITE);
        scheduleButton.setFont(new Font("SansSerif", Font.BOLD, 16));
        scheduleButton.setFocusPainted(false);
        scheduleButton.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));

        bottomButtonPanel.add(addPetButton);
        bottomButtonPanel.add(scheduleButton);

        mainPanel.add(bottomButtonPanel, BorderLayout.SOUTH);

        add(mainPanel);
        setVisible(true);
    }

    private JPanel createPetInfoPanel(String petName, String healthRecord, String nextAppointment) {
        JPanel petPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        petPanel.setBackground(new Color(245, 245, 245)); // Light Gray
        petPanel.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(220, 220, 220)), // Light Light Gray
                new EmptyBorder(15, 15, 15, 15)
        ));
        petPanel.setAlignmentX(Component.LEFT_ALIGNMENT);

        // Avatar Placeholder
        JPanel avatarPlaceholder = new JPanel();
        avatarPlaceholder.setPreferredSize(new Dimension(60, 60));
        avatarPlaceholder.setMaximumSize(new Dimension(60, 60));
        avatarPlaceholder.setBackground(new Color(230, 230, 230)); // Slightly darker gray
        JLabel avatarLabel = new JLabel("Pet Image");
        avatarLabel.setForeground(Color.GRAY);
        avatarPlaceholder.add(avatarLabel);
        petPanel.add(avatarPlaceholder);
        petPanel.add(Box.createHorizontalStrut(15));

        JPanel textInfoPanel = new JPanel();
        textInfoPanel.setLayout(new BoxLayout(textInfoPanel, BoxLayout.Y_AXIS));
        textInfoPanel.setOpaque(false);

        JLabel nameLabel = new JLabel(petName);
        nameLabel.setFont(new Font("SansSerif", Font.BOLD, 18));
        nameLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
        textInfoPanel.add(nameLabel);
        textInfoPanel.add(Box.createVerticalStrut(5));

        JLabel healthLabel = new JLabel(healthRecord);
        healthLabel.setFont(new Font("SansSerif", Font.PLAIN, 14));
        healthLabel.setForeground(Color.GRAY);
        healthLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
        textInfoPanel.add(healthLabel);
        textInfoPanel.add(Box.createVerticalStrut(3));

        JLabel appointmentLabel = new JLabel(nextAppointment);
        appointmentLabel.setFont(new Font("SansSerif", Font.PLAIN, 14));
        appointmentLabel.setForeground(Color.GRAY);
        appointmentLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
        textInfoPanel.add(appointmentLabel);

        petPanel.add(textInfoPanel);

        return petPanel;
    }

    private JPanel createPetInfoPanel(String petName, String breed, String healthRecord, String nextAppointment) {
        JPanel petPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        petPanel.setBackground(new Color(245, 245, 245)); // Light Gray
        petPanel.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(220, 220, 220)), // Light Light Gray
                new EmptyBorder(15, 15, 15, 15)
        ));
        petPanel.setAlignmentX(Component.LEFT_ALIGNMENT);

        // Avatar Placeholder
        JPanel avatarPlaceholder = new JPanel();
        avatarPlaceholder.setPreferredSize(new Dimension(60, 60));
        avatarPlaceholder.setMaximumSize(new Dimension(60, 60));
        avatarPlaceholder.setBackground(new Color(230, 230, 230)); // Slightly darker gray
        JLabel avatarLabel = new JLabel("Pet Image");
        avatarLabel.setForeground(Color.GRAY);
        avatarPlaceholder.add(avatarLabel);
        petPanel.add(avatarPlaceholder);
        petPanel.add(Box.createHorizontalStrut(15));

        JPanel textInfoPanel = new JPanel();
        textInfoPanel.setLayout(new BoxLayout(textInfoPanel, BoxLayout.Y_AXIS));
        textInfoPanel.setOpaque(false);

        JLabel nameLabel = new JLabel(petName);
        nameLabel.setFont(new Font("SansSerif", Font.BOLD, 18));
        nameLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
        textInfoPanel.add(nameLabel);
        textInfoPanel.add(Box.createVerticalStrut(3));

        JLabel breedLabel = new JLabel(breed);
        breedLabel.setFont(new Font("SansSerif", Font.PLAIN, 14));
        breedLabel.setForeground(Color.GRAY);
        breedLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
        textInfoPanel.add(breedLabel);
        textInfoPanel.add(Box.createVerticalStrut(5));

        JLabel healthLabel = new JLabel(healthRecord);
        healthLabel.setFont(new Font("SansSerif", Font.PLAIN, 14));
        healthLabel.setForeground(Color.GRAY);
        healthLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
        textInfoPanel.add(healthLabel);
        textInfoPanel.add(Box.createVerticalStrut(3));

        JLabel appointmentLabel = new JLabel(nextAppointment);
        appointmentLabel.setFont(new Font("SansSerif", Font.PLAIN, 14));
        appointmentLabel.setForeground(Color.GRAY);
        appointmentLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
        textInfoPanel.add(appointmentLabel);

        petPanel.add(textInfoPanel);

        return petPanel;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(PetDashboardApp::new);
    }
}