import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class PetHealthRecordsApp extends JFrame {

    public PetHealthRecordsApp() {
        setTitle("Pet Health Records");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 550);
        setLocationRelativeTo(null);

        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBackground(new Color(240, 248, 255)); // Alice Blue

        // Top Bar
        JPanel topBar = new JPanel(new FlowLayout(FlowLayout.LEFT));
        topBar.setBackground(new Color(224, 238, 248)); // Light Cyan
        topBar.setBorder(new EmptyBorder(10, 15, 10, 15));

        JButton backButton = new JButton("←");
        backButton.setFont(new Font("SansSerif", Font.BOLD, 20));
        backButton.setForeground(Color.BLACK);
        backButton.setBackground(new Color(224, 238, 248));
        backButton.setBorderPainted(false);
        backButton.setFocusPainted(false);

        JLabel petCareLabel = new JLabel("🐾 PetCare");
        petCareLabel.setFont(new Font("SansSerif", Font.BOLD, 20));

        topBar.add(backButton);
        topBar.add(Box.createHorizontalGlue());
        topBar.add(petCareLabel);
        topBar.add(Box.createHorizontalGlue());

        mainPanel.add(topBar, BorderLayout.NORTH);

        // Content Panel
        JPanel contentPanel = new JPanel();
        contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.Y_AXIS));
        contentPanel.setBorder(new EmptyBorder(20, 20, 20, 20));
        contentPanel.setBackground(Color.WHITE);

        JLabel vaccinationHistoryLabel = new JLabel("Vaccination History");
        vaccinationHistoryLabel.setFont(new Font("SansSerif", Font.BOLD, 18));
        vaccinationHistoryLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
        contentPanel.add(vaccinationHistoryLabel);
        contentPanel.add(Box.createVerticalStrut(10));

        contentPanel.add(createRecordItem("Rabies Vaccine", "Administered on: Feb 25, 2025", "Next due: Feb 25, 2026"));
        contentPanel.add(Box.createVerticalStrut(10));
        contentPanel.add(createRecordItem("Distemper Vaccine", "Administered on: Jan 15, 2025", "Next due: Jan 15, 2025"));
        contentPanel.add(Box.createVerticalStrut(15));

        JLabel medicationScheduleLabel = new JLabel("Medication Schedule");
        medicationScheduleLabel.setFont(new Font("SansSerif", Font.BOLD, 18));
        medicationScheduleLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
        contentPanel.add(medicationScheduleLabel);
        contentPanel.add(Box.createVerticalStrut(10));

        contentPanel.add(createRecordItem("Heartworm Prevention", "Administered on: Mar 01, 2025", "Next dose: Apr 01, 2025"));
        contentPanel.add(Box.createVerticalStrut(15));

        JLabel notesLabel = new JLabel("Notes");
        notesLabel.setFont(new Font("SansSerif", Font.BOLD, 18));
        notesLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
        contentPanel.add(notesLabel);
        contentPanel.add(Box.createVerticalStrut(10));

        JTextArea notesTextArea = new JTextArea("Enter notes here...", 3, 20);
        notesTextArea.setFont(new Font("SansSerif", Font.PLAIN, 14));
        notesTextArea.setForeground(Color.GRAY);
        JScrollPane notesScrollPane = new JScrollPane(notesTextArea);
        contentPanel.add(notesScrollPane);
        contentPanel.add(Box.createVerticalStrut(20));

        // Bottom Buttons
        JPanel bottomButtonPanel = new JPanel(new FlowLayout(FlowLayout.LEADING, 30, 15));
        bottomButtonPanel.setBackground(new Color(240, 248, 255)); // Alice Blue
        bottomButtonPanel.setBorder(new EmptyBorder(15, 15, 15, 15));

        JButton addRecordButton = new JButton("Add Record");
        addRecordButton.setBackground(new Color(70, 130, 180)); // Steel Blue
        addRecordButton.setForeground(Color.WHITE);
        addRecordButton.setFont(new Font("SansSerif", Font.BOLD, 16));
        addRecordButton.setFocusPainted(false);
        addRecordButton.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));

        JButton setReminderButton = new JButton("Set Reminder");
        setReminderButton.setBackground(new Color(70, 130, 180)); // Steel Blue
        setReminderButton.setForeground(Color.WHITE);
        setReminderButton.setFont(new Font("SansSerif", Font.BOLD, 16));
        setReminderButton.setFocusPainted(false);
        setReminderButton.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));

        bottomButtonPanel.add(addRecordButton);
        bottomButtonPanel.add(setReminderButton);

        mainPanel.add(contentPanel, BorderLayout.CENTER);
        mainPanel.add(bottomButtonPanel, BorderLayout.SOUTH);

        add(mainPanel);
        setVisible(true);
    }

    private JPanel createRecordItem(String title, String administeredDate, String dueDate) {
        JPanel recordPanel = new JPanel();
        recordPanel.setLayout(new BoxLayout(recordPanel, BoxLayout.Y_AXIS));
        recordPanel.setBackground(new Color(245, 245, 245)); // Light Gray
        recordPanel.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(220, 220, 220)), // Light Light Gray
                new EmptyBorder(15, 15, 15, 15)
        ));
        recordPanel.setAlignmentX(Component.LEFT_ALIGNMENT);

        JLabel titleLabel = new JLabel(title);
        titleLabel.setFont(new Font("SansSerif", Font.BOLD, 16));
        titleLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
        recordPanel.add(titleLabel);
        recordPanel.add(Box.createVerticalStrut(5));

        JLabel administeredLabel = new JLabel(administeredDate);
        administeredLabel.setFont(new Font("SansSerif", Font.PLAIN, 14));
        administeredLabel.setForeground(Color.GRAY);
        administeredLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
        recordPanel.add(administeredLabel);
        recordPanel.add(Box.createVerticalStrut(3));

        JLabel dueLabel = new JLabel(dueDate);
        dueLabel.setFont(new Font("SansSerif", Font.PLAIN, 14));
        dueLabel.setForeground(Color.GRAY);
        dueLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
        recordPanel.add(dueLabel);

        return recordPanel;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(PetHealthRecordsApp::new);
    }
}