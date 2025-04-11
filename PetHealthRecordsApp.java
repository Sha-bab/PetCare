import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class PetHealthRecordsApp extends JFrame {

    public PetHealthRecordsApp() {
        setTitle("🐶 Pet Health Records");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(420, 580);
        setLocationRelativeTo(null);

        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBackground(new Color(230, 245, 255)); // Soft Blue

        // Top Bar
        JPanel topBar = new JPanel(new BorderLayout());
        topBar.setBackground(new Color(190, 230, 255)); // Sky Blue
        topBar.setBorder(new EmptyBorder(10, 15, 10, 15));

        JButton backButton = new JButton("←");
        backButton.setFont(new Font("SansSerif", Font.BOLD, 18));
        backButton.setForeground(Color.DARK_GRAY);
        backButton.setBackground(new Color(190, 230, 255));
        backButton.setBorderPainted(false);
        backButton.setFocusPainted(false);

        JLabel titleLabel = new JLabel("🐾 PetCare");
        titleLabel.setFont(new Font("SansSerif", Font.BOLD, 22));
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);

        topBar.add(backButton, BorderLayout.WEST);
        topBar.add(titleLabel, BorderLayout.CENTER);

        mainPanel.add(topBar, BorderLayout.NORTH);

        // Content Panel
        JPanel contentPanel = new JPanel();
        contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.Y_AXIS));
        contentPanel.setBorder(new EmptyBorder(20, 20, 20, 20));
        contentPanel.setBackground(Color.WHITE);

        JLabel healthSection = createSectionLabel("🦴 Vaccination History");
        contentPanel.add(healthSection);
        contentPanel.add(Box.createVerticalStrut(10));
        contentPanel.add(createRecordItem("💉 Rabies Vaccine", "Administered on: Feb 25, 2025", "Next due: Feb 25, 2026"));
        contentPanel.add(Box.createVerticalStrut(10));
        contentPanel.add(createRecordItem("💉 Distemper Vaccine", "Administered on: Jan 15, 2025", "Next due: Jan 15, 2026"));

        contentPanel.add(Box.createVerticalStrut(20));
        JLabel medSection = createSectionLabel("🩺 Medication Schedule");
        contentPanel.add(medSection);
        contentPanel.add(Box.createVerticalStrut(10));
        contentPanel.add(createRecordItem("💊 Heartworm Prevention", "Administered on: Mar 01, 2025", "Next dose: Apr 01, 2025"));

        contentPanel.add(Box.createVerticalStrut(20));
        JLabel notesSection = createSectionLabel("📝 Notes");
        contentPanel.add(notesSection);
        contentPanel.add(Box.createVerticalStrut(10));

        JTextArea notesTextArea = new JTextArea("Add notes here...", 3, 20);
        notesTextArea.setFont(new Font("SansSerif", Font.PLAIN, 14));
        notesTextArea.setForeground(Color.DARK_GRAY);
        notesTextArea.setLineWrap(true);
        notesTextArea.setWrapStyleWord(true);
        JScrollPane notesScroll = new JScrollPane(notesTextArea);
        notesScroll.setPreferredSize(new Dimension(360, 80));
        contentPanel.add(notesScroll);

        JScrollPane scrollPane = new JScrollPane(contentPanel);
        scrollPane.setBorder(null);

        mainPanel.add(scrollPane, BorderLayout.CENTER);

        // Bottom Buttons
        JPanel bottomPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 15));
        bottomPanel.setBackground(new Color(230, 245, 255));

        JButton addBtn = createStyledButton("➕ Add Record");
        JButton reminderBtn = createStyledButton("⏰ Set Reminder");

        bottomPanel.add(addBtn);
        bottomPanel.add(reminderBtn);

        mainPanel.add(bottomPanel, BorderLayout.SOUTH);
        add(mainPanel);

        setVisible(true);
    }

    private JLabel createSectionLabel(String text) {
        JLabel label = new JLabel(text);
        label.setFont(new Font("SansSerif", Font.BOLD, 18));
        label.setAlignmentX(Component.LEFT_ALIGNMENT);
        return label;
    }

    private JPanel createRecordItem(String title, String date1, String date2) {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBackground(new Color(245, 250, 255)); // Very light blue
        panel.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(200, 220, 240)),
                new EmptyBorder(12, 12, 12, 12)
        ));
        panel.setAlignmentX(Component.LEFT_ALIGNMENT);

        JLabel titleLabel = new JLabel(title);
        titleLabel.setFont(new Font("SansSerif", Font.BOLD, 15));

        JLabel dateLabel1 = new JLabel(date1);
        dateLabel1.setFont(new Font("SansSerif", Font.PLAIN, 13));
        dateLabel1.setForeground(new Color(80, 80, 80));

        JLabel dateLabel2 = new JLabel(date2);
        dateLabel2.setFont(new Font("SansSerif", Font.PLAIN, 13));
        dateLabel2.setForeground(new Color(80, 80, 80));

        panel.add(titleLabel);
        panel.add(Box.createVerticalStrut(4));
        panel.add(dateLabel1);
        panel.add(dateLabel2);

        return panel;
    }

    private JButton createStyledButton(String text) {
        JButton button = new JButton(text);
        button.setBackground(new Color(100, 149, 237)); // Cornflower Blue
        button.setForeground(Color.WHITE);
        button.setFont(new Font("SansSerif", Font.BOLD, 14));
        button.setFocusPainted(false);
        button.setBorder(BorderFactory.createEmptyBorder(10, 18, 10, 18));
        return button;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(PetHealthRecordsApp::new);
    }
}
