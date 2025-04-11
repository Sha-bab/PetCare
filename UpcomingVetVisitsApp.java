import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class UpcomingVetVisitsApp extends JFrame {

    public UpcomingVetVisitsApp() {
        setTitle("🐾 PetCare - Upcoming Vet Visits");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(420, 700);
        setLocationRelativeTo(null);
        setIconImage(new ImageIcon("dog_icon.png").getImage()); // Make sure dog_icon.png is available

        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBackground(new Color(235, 245, 255)); // Soft blue background

        // Top Navigation Bar
        JPanel topBar = new JPanel(new BorderLayout());
        topBar.setBackground(new Color(173, 216, 230)); // Light blue
        topBar.setBorder(new EmptyBorder(12, 18, 12, 18));

        JLabel titleLabel = new JLabel("🐶 Home");
        titleLabel.setFont(new Font("SansSerif", Font.BOLD, 18));
        titleLabel.setForeground(new Color(0, 51, 102));

        JButton addVisitBtn = new JButton("➕");
        styleRoundButton(addVisitBtn, 32);

        topBar.add(titleLabel, BorderLayout.WEST);
        topBar.add(addVisitBtn, BorderLayout.EAST);

        // Content Panel
        JPanel contentPanel = new JPanel();
        contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.Y_AXIS));
        contentPanel.setBackground(Color.WHITE);
        contentPanel.setBorder(new EmptyBorder(20, 25, 20, 25));

        JLabel heading = new JLabel("📅 Upcoming Vet Visits");
        heading.setFont(new Font("SansSerif", Font.BOLD, 22));
        heading.setForeground(new Color(0, 76, 153));
        heading.setAlignmentX(Component.LEFT_ALIGNMENT);
        contentPanel.add(heading);
        contentPanel.add(Box.createVerticalStrut(20));

        contentPanel.add(createEventCard("🩺 Vet Check-up", "9:00 AM"));
        contentPanel.add(Box.createVerticalStrut(25));

        // Add Dates & Activities
        contentPanel.add(createDateHeading(18, "DEC"));
        contentPanel.add(createActivityCard("1:00 - 2:00 PM", "🐕 Pet Fitness", new String[]{"Exercise", "Health"}));
        contentPanel.add(createActivityCard("7:00 - 9:00 PM", "🍖 Feeding Time", new String[]{"Mealtime"}));
        contentPanel.add(Box.createVerticalStrut(20));

        contentPanel.add(createDateHeading(19, "DEC"));
        contentPanel.add(createActivityCard("10:00 - 11:30 AM", "🎾 Playtime with Pets", new String[]{"Fun"}));
        contentPanel.add(createActivityCard("7:00 - 9:00 PM", "🐾 Pet Playdate", new String[]{"Friends"}));
        contentPanel.add(Box.createVerticalStrut(20));

        contentPanel.add(createDateHeading(20, "DEC"));
        contentPanel.add(createActivityCard("Anytime", "🌳 Outdoor Adventures", new String[]{"Nature"}));

        JScrollPane scrollPane = new JScrollPane(contentPanel);
        scrollPane.setBorder(null);
        scrollPane.getVerticalScrollBar().setUnitIncrement(16);

        // Bottom Navigation
        JPanel bottomNav = new JPanel(new GridLayout(1, 5, 10, 0));
        bottomNav.setBackground(new Color(173, 216, 230));
        bottomNav.setBorder(new EmptyBorder(10, 25, 10, 25));

        bottomNav.add(makeNavLabel("🏠", "Home"));
        bottomNav.add(makeNavLabel("🔍", "Search"));
        JButton centerBtn = new JButton("➕");
        styleRoundButton(centerBtn, 40);
        bottomNav.add(centerBtn);
        bottomNav.add(makeNavLabel("💬", "Chat"));
        bottomNav.add(makeNavLabel("🐾", "Profile"));

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
        button.setBackground(new Color(100, 149, 237)); // Cornflower Blue
        button.setFocusPainted(false);
        button.setBorder(BorderFactory.createEmptyBorder());
        button.setOpaque(true);
    }

    private JPanel createEventCard(String title, String time) {
        JPanel card = new JPanel(new BorderLayout());
        card.setBackground(new Color(224, 242, 255));
        card.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(180, 210, 250), 1),
                new EmptyBorder(10, 15, 10, 15)
        ));
        card.setMaximumSize(new Dimension(360, 60));

        JLabel titleLabel = new JLabel(title);
        titleLabel.setFont(new Font("SansSerif", Font.BOLD, 16));
        titleLabel.setForeground(new Color(0, 51, 102));

        JLabel timeLabel = new JLabel(time);
        timeLabel.setFont(new Font("SansSerif", Font.PLAIN, 14));
        timeLabel.setForeground(new Color(0, 76, 153));

        card.add(titleLabel, BorderLayout.WEST);
        card.add(timeLabel, BorderLayout.EAST);

        return card;
    }

    private JPanel createActivityCard(String time, String title, String[] tags) {
        JPanel card = new JPanel();
        card.setLayout(new BoxLayout(card, BoxLayout.Y_AXIS));
        card.setBackground(new Color(250, 250, 255));
        card.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(200, 220, 250), 1),
                new EmptyBorder(10, 15, 10, 15)
        ));
        card.setMaximumSize(new Dimension(360, 100));

        JLabel timeLabel = new JLabel(time);
        timeLabel.setFont(new Font("SansSerif", Font.PLAIN, 14));
        timeLabel.setForeground(new Color(50, 70, 130));
        card.add(timeLabel);

        JLabel titleLabel = new JLabel(title);
        titleLabel.setFont(new Font("SansSerif", Font.BOLD, 16));
        titleLabel.setForeground(new Color(0, 76, 153));
        card.add(titleLabel);

        if (tags != null && tags.length > 0) {
            JPanel tagPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 5, 5));
            tagPanel.setOpaque(false);
            for (String tag : tags) {
                JLabel tagLabel = new JLabel(tag);
                tagLabel.setOpaque(true);
                tagLabel.setBackground(new Color(100, 149, 237));
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

        JLabel dateLabel = new JLabel("📅 " + month + " " + day);
        dateLabel.setFont(new Font("SansSerif", Font.BOLD, 18));
        dateLabel.setForeground(new Color(0, 76, 153));
        datePanel.add(dateLabel);

        return datePanel;
    }

    private JPanel makeNavLabel(String emoji, String text) {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setOpaque(false);
        JLabel iconLabel = new JLabel(emoji, SwingConstants.CENTER);
        iconLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        JLabel textLabel = new JLabel(text, SwingConstants.CENTER);
        textLabel.setFont(new Font("SansSerif", Font.PLAIN, 11));
        textLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(iconLabel);
        panel.add(textLabel);
        return panel;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(UpcomingVetVisitsApp::new);
    }
}
