import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class UpcomingVetVisitsApp extends JFrame {

    public UpcomingVetVisitsApp() {
        setTitle("PetCare - Upcoming Vet Visits");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(420, 700);
        setLocationRelativeTo(null);

        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBackground(new Color(245, 250, 255));

        // Top Navigation Bar
        JPanel topBar = new JPanel(new BorderLayout());
        topBar.setBackground(new Color(200, 230, 255));
        topBar.setBorder(new EmptyBorder(10, 20, 10, 20));

        JLabel titleLabel = new JLabel("🏠 Home");
        titleLabel.setFont(new Font("SansSerif", Font.BOLD, 18));

        JButton addVisitBtn = new JButton("+");
        styleRoundButton(addVisitBtn, 30);

        topBar.add(titleLabel, BorderLayout.WEST);
        topBar.add(addVisitBtn, BorderLayout.EAST);

        // Main Content
        JPanel contentPanel = new JPanel();
        contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.Y_AXIS));
        contentPanel.setBackground(Color.WHITE);
        contentPanel.setBorder(new EmptyBorder(20, 20, 20, 20));

        JLabel heading = new JLabel("📅 Upcoming Vet Visits");
        heading.setFont(new Font("SansSerif", Font.BOLD, 22));
        heading.setAlignmentX(Component.LEFT_ALIGNMENT);
        contentPanel.add(heading);
        contentPanel.add(Box.createVerticalStrut(15));

        // Add Event Cards
        contentPanel.add(createEventCard("🩺 Vet Check-up", "9:00 AM"));
        contentPanel.add(Box.createVerticalStrut(20));

        // Add Dates with activities
        contentPanel.add(createDateHeading(18, "DEC"));
        contentPanel.add(createActivityCard("1:00 - 2:00 PM", "Pet Fitness", new String[]{"Exercise", "Health"}));
        contentPanel.add(createActivityCard("7:00 - 9:00 PM", "Feeding Time", new String[]{"Mealtime"}));

        contentPanel.add(createDateHeading(19, "DEC"));
        contentPanel.add(createActivityCard("10:00 - 11:30 AM", "Playtime with Pets", new String[]{"Fun"}));
        contentPanel.add(createActivityCard("7:00 - 9:00 PM", "Pet Playdate", new String[]{"Friends"}));

        contentPanel.add(createDateHeading(20, "DEC"));
        contentPanel.add(createActivityCard("Quality time", "Outdoor Adventures", new String[]{"Nature"}));

        JScrollPane scrollPane = new JScrollPane(contentPanel);
        scrollPane.setBorder(null);
        scrollPane.getVerticalScrollBar().setUnitIncrement(16);

        // Bottom Navigation Bar
        JPanel bottomNav = new JPanel(new GridLayout(1, 5, 15, 0));
        bottomNav.setBackground(new Color(200, 230, 255));
        bottomNav.setBorder(new EmptyBorder(10, 30, 10, 30));

        bottomNav.add(new JLabel("🏠"));
        bottomNav.add(new JLabel("🔍"));
        JButton middleBtn = new JButton("+");
        styleRoundButton(middleBtn, 40);
        bottomNav.add(middleBtn);
        bottomNav.add(new JLabel("💬"));
        bottomNav.add(new JLabel("👤"));

        mainPanel.add(topBar, BorderLayout.NORTH);
        mainPanel.add(scrollPane, BorderLayout.CENTER);
        mainPanel.add(bottomNav, BorderLayout.SOUTH);

        add(mainPanel);
        setVisible(true);
    }

    private void styleRoundButton(JButton button, int size) {
        button.setPreferredSize(new Dimension(size, size));
        button.setFont(new Font("SansSerif", Font.BOLD, size / 2));
        button.setForeground(Color.WHITE);
        button.setBackground(new Color(100, 170, 255));
        button.setFocusPainted(false);
        button.setBorder(BorderFactory.createEmptyBorder());
        button.setOpaque(true);
    }

    private JPanel createEventCard(String title, String time) {
        JPanel card = new JPanel(new BorderLayout());
        card.setBackground(new Color(240, 245, 255));
        card.setBorder(new EmptyBorder(10, 15, 10, 15));
        card.setMaximumSize(new Dimension(360, 60));

        JLabel titleLabel = new JLabel(title);
        titleLabel.setFont(new Font("SansSerif", Font.BOLD, 16));

        JLabel timeLabel = new JLabel(time);
        timeLabel.setFont(new Font("SansSerif", Font.PLAIN, 14));

        card.add(titleLabel, BorderLayout.WEST);
        card.add(timeLabel, BorderLayout.EAST);

        return card;
    }

    private JPanel createActivityCard(String time, String title, String[] tags) {
        JPanel card = new JPanel();
        card.setLayout(new BoxLayout(card, BoxLayout.Y_AXIS));
        card.setBackground(new Color(250, 250, 250));
        card.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(220, 220, 220), 1),
                new EmptyBorder(10, 15, 10, 15)
        ));
        card.setMaximumSize(new Dimension(360, 100));

        JLabel timeLabel = new JLabel(time);
        timeLabel.setFont(new Font("SansSerif", Font.PLAIN, 14));
        card.add(timeLabel);

        JLabel titleLabel = new JLabel(title);
        titleLabel.setFont(new Font("SansSerif", Font.BOLD, 16));
        card.add(titleLabel);

        if (tags != null && tags.length > 0) {
            JPanel tagPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 5, 5));
            tagPanel.setOpaque(false);
            for (String tag : tags) {
                JLabel tagLabel = new JLabel(tag);
                tagLabel.setOpaque(true);
                tagLabel.setBackground(new Color(173, 216, 230));
                tagLabel.setForeground(Color.WHITE);
                tagLabel.setFont(new Font("SansSerif", Font.PLAIN, 12));
                tagLabel.setBorder(new EmptyBorder(5, 10, 5, 10));
                tagPanel.add(tagLabel);
            }
            card.add(tagPanel);
        }

        return card;
    }

    private JPanel createDateHeading(int day, String month) {
        JPanel datePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        datePanel.setOpaque(false);

        JLabel dateLabel = new JLabel("📅 " + (month != null ? month + " " : "") + day);
        dateLabel.setFont(new Font("SansSerif", Font.BOLD, 18));
        datePanel.add(dateLabel);

        return datePanel;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(UpcomingVetVisitsApp::new);
    }
}
