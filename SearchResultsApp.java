import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.Locale;

public class SearchResultsApp extends JFrame {

    private JPanel calendarPanel;
    private JButton[] dayButtons;
    private Calendar calendar;
    private JLabel monthLabel;

    public SearchResultsApp() {
        setTitle("Search");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 650);
        setLocationRelativeTo(null);

        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBackground(new Color(240, 248, 255)); // Alice Blue

        // Top Bar
        JPanel topBar = new JPanel(new FlowLayout(FlowLayout.LEFT));
        topBar.setBackground(new Color(47, 79, 79)); // Dark Slate Gray
        topBar.setBorder(new EmptyBorder(10, 15, 10, 15));

        JButton backButton = new JButton("←");
        backButton.setFont(new Font("SansSerif", Font.BOLD, 20));
        backButton.setForeground(Color.WHITE);
        backButton.setBackground(new Color(47, 79, 79));
        backButton.setBorderPainted(false);
        backButton.setFocusPainted(false);

        JLabel resultsLabel = new JLabel("Results");
        resultsLabel.setFont(new Font("SansSerif", Font.BOLD, 18));
        resultsLabel.setForeground(Color.WHITE);
        resultsLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        topBar.add(backButton);
        topBar.add(Box.createHorizontalGlue());
        topBar.add(resultsLabel);
        topBar.add(Box.createHorizontalGlue());

        mainPanel.add(topBar, BorderLayout.NORTH);

        // Content Panel
        JPanel contentPanel = new JPanel();
        contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.Y_AXIS));
        contentPanel.setBorder(new EmptyBorder(20, 20, 20, 20));
        contentPanel.setBackground(Color.WHITE);

        // Type of pet or service needed
        JLabel serviceLabel = new JLabel("Type of pet or service needed");
        serviceLabel.setFont(new Font("SansSerif", Font.PLAIN, 16));
        serviceLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
        contentPanel.add(serviceLabel);
        contentPanel.add(Box.createVerticalStrut(5));
        JTextField serviceTextField = new JTextField("Dog walking");
        serviceTextField.setFont(new Font("SansSerif", Font.PLAIN, 14));
        contentPanel.add(serviceTextField);
        contentPanel.add(Box.createVerticalStrut(15));

        // Frequency
        JLabel frequencyLabel = new JLabel("Frequency");
        frequencyLabel.setFont(new Font("SansSerif", Font.PLAIN, 16));
        frequencyLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
        contentPanel.add(frequencyLabel);
        contentPanel.add(Box.createVerticalStrut(5));

        JPanel frequencyPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        frequencyPanel.setOpaque(false);
        JButton weeklyButton = new JButton("🐾 Weekly");
        weeklyButton.setBackground(new Color(70, 130, 180)); // Steel Blue
        weeklyButton.setForeground(Color.WHITE);
        weeklyButton.setFont(new Font("SansSerif", Font.PLAIN, 14));
        weeklyButton.setFocusPainted(false);
        weeklyButton.setBorder(BorderFactory.createEmptyBorder(8, 15, 8, 15));
        frequencyPanel.add(weeklyButton);
        frequencyPanel.add(Box.createHorizontalGlue());
        JButton resetButton = new JButton("Reset");
        resetButton.setFont(new Font("SansSerif", Font.PLAIN, 14));
        resetButton.setForeground(Color.BLACK);
        resetButton.setBackground(new Color(220, 220, 220)); // Light Gray
        resetButton.setFocusPainted(false);
        resetButton.setBorder(BorderFactory.createEmptyBorder(8, 15, 8, 15));
        frequencyPanel.add(resetButton);
        frequencyPanel.setAlignmentX(Component.LEFT_ALIGNMENT);
        contentPanel.add(frequencyPanel);
        contentPanel.add(Box.createVerticalStrut(10));

        // Calendar
        calendar = Calendar.getInstance();
        calendarPanel = new JPanel(new GridLayout(7, 7));
        calendarPanel.setPreferredSize(new Dimension(300, 200));
        calendarPanel.setMaximumSize(new Dimension(300, 200));
        dayButtons = new JButton[42]; // Max 6 weeks x 7 days
        monthLabel = new JLabel();
        monthLabel.setFont(new Font("SansSerif", Font.BOLD, 16));
        monthLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        updateCalendar();
        contentPanel.add(monthLabel);
        contentPanel.add(calendarPanel);
        contentPanel.add(Box.createVerticalStrut(15));

        // Service Provider
        JLabel providerLabel = new JLabel("Service Provider");
        providerLabel.setFont(new Font("SansSerif", Font.PLAIN, 16));
        providerLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
        contentPanel.add(providerLabel);
        contentPanel.add(Box.createVerticalStrut(5));
        JTextField providerTextField = new JTextField("Groomer");
        providerTextField.setFont(new Font("SansSerif", Font.PLAIN, 14));
        contentPanel.add(providerTextField);
        contentPanel.add(Box.createVerticalStrut(20));

        // Find Button
        JButton findButton = new JButton("Find");
        findButton.setBackground(new Color(70, 130, 180)); // Steel Blue
        findButton.setForeground(Color.WHITE);
        findButton.setFont(new Font("SansSerif", Font.BOLD, 18));
        findButton.setFocusPainted(false);
        findButton.setBorder(BorderFactory.createEmptyBorder(10, 50, 10, 50));
        findButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        contentPanel.add(findButton);

        JScrollPane scrollPane = new JScrollPane(contentPanel);
        scrollPane.setBorder(null);
        mainPanel.add(scrollPane, BorderLayout.CENTER);

        // Bottom Navigation
        JPanel bottomNav = new JPanel(new FlowLayout(FlowLayout.LEADING));
        bottomNav.setBackground(new Color(224, 238, 248)); // Light Cyan
        bottomNav.setBorder(new EmptyBorder(10, 30, 10, 30));

        JButton homeButtonBottom = new JButton("🏠\nPP");
        JButton notificationsButtonBottom = new JButton("🔔\nNotifications");
        JButton pmButtonBottom = new JButton("✉\nPM");

        Font bottomFont = new Font("SansSerif", Font.PLAIN, 12);

        homeButtonBottom.setFont(bottomFont);
        notificationsButtonBottom.setFont(bottomFont);
        pmButtonBottom.setFont(bottomFont);

        homeButtonBottom.setHorizontalTextPosition(SwingConstants.CENTER);
        homeButtonBottom.setVerticalTextPosition(SwingConstants.BOTTOM);
        notificationsButtonBottom.setHorizontalTextPosition(SwingConstants.CENTER);
        notificationsButtonBottom.setVerticalTextPosition(SwingConstants.BOTTOM);
        pmButtonBottom.setHorizontalTextPosition(SwingConstants.CENTER);
        pmButtonBottom.setVerticalTextPosition(SwingConstants.BOTTOM);

        bottomNav.add(homeButtonBottom);
        bottomNav.add(notificationsButtonBottom);
        bottomNav.add(pmButtonBottom);

        mainPanel.add(bottomNav, BorderLayout.SOUTH);

        add(mainPanel);
        setVisible(true);
    }

    private void updateCalendar() {
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        monthLabel.setText(calendar.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.getDefault()) + " " + calendar.get(Calendar.YEAR));

        int firstDayOfMonth = calendar.get(Calendar.DAY_OF_WEEK) - 1; // Adjust for Sunday being 1
        int daysInMonth = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);

        calendarPanel.removeAll();
        String[] dayNames = {"Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat"};
        for (String day : dayNames) {
            calendarPanel.add(new JLabel(day, SwingConstants.CENTER));
        }

        for (int i = 0; i < 42; i++) {
            if (i < firstDayOfMonth || i >= firstDayOfMonth + daysInMonth) {
                dayButtons[i] = new JButton("");
                dayButtons[i].setEnabled(false);
            } else {
                int day = i - firstDayOfMonth + 1;
                dayButtons[i] = new JButton(String.valueOf(day));
                dayButtons[i].setBackground(Color.WHITE);
                if (day >= 15 && day <= 18) { // Highlighted dates
                    dayButtons[i].setBackground(new Color(173, 216, 230)); // Light Blue
                } else if (day == 15 || day == 16 || day == 18) {
                    dayButtons[i].setForeground(Color.BLACK);
                } else {
                    dayButtons[i].setForeground(Color.GRAY);
                }
                dayButtons[i].setFocusPainted(false);
                final int selectedDay = day;
                dayButtons[i].addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        // Handle date selection
                        System.out.println("Selected date: " + selectedDay + " " +
                                calendar.getDisplayName(Calendar.MONTH, Calendar.SHORT, Locale.getDefault()) + " " +
                                calendar.get(Calendar.YEAR));
                        // You can update the UI or store the selected date here
                    }
                });
            }
            calendarPanel.add(dayButtons[i]);
        }
        calendarPanel.revalidate();
        calendarPanel.repaint();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(SearchResultsApp::new);
    }
}