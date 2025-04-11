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
        setTitle("Search - PetCarePro 🐶");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(420, 700);
        setLocationRelativeTo(null);

        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBackground(new Color(230, 245, 255)); // Soft Blue

        // Top Bar
        JPanel topBar = new JPanel(new BorderLayout());
        topBar.setBackground(new Color(100, 149, 237)); // Cornflower Blue
        topBar.setBorder(new EmptyBorder(10, 15, 10, 15));

        JButton backButton = new JButton("←");
        backButton.setFont(new Font("SansSerif", Font.BOLD, 20));
        backButton.setForeground(Color.WHITE);
        backButton.setBackground(new Color(100, 149, 237));
        backButton.setBorderPainted(false);
        backButton.setFocusPainted(false);

        JLabel resultsLabel = new JLabel("🐶 Search Results");
        resultsLabel.setFont(new Font("SansSerif", Font.BOLD, 18));
        resultsLabel.setForeground(Color.WHITE);
        resultsLabel.setHorizontalAlignment(SwingConstants.CENTER);

        topBar.add(backButton, BorderLayout.WEST);
        topBar.add(resultsLabel, BorderLayout.CENTER);

        mainPanel.add(topBar, BorderLayout.NORTH);

        // Content Panel
        JPanel contentPanel = new JPanel();
        contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.Y_AXIS));
        contentPanel.setBorder(new EmptyBorder(20, 20, 20, 20));
        contentPanel.setBackground(new Color(245, 255, 250)); // Mint Cream

        // Type of pet or service needed
        JLabel serviceLabel = new JLabel("🐾 Type of Pet/Service");
        serviceLabel.setFont(new Font("SansSerif", Font.BOLD, 16));
        serviceLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
        contentPanel.add(serviceLabel);
        contentPanel.add(Box.createVerticalStrut(5));
        JTextField serviceTextField = new JTextField("Dog walking");
        serviceTextField.setFont(new Font("SansSerif", Font.PLAIN, 14));
        contentPanel.add(serviceTextField);
        contentPanel.add(Box.createVerticalStrut(15));

        // Frequency
        JLabel frequencyLabel = new JLabel("🗓️ Frequency");
        frequencyLabel.setFont(new Font("SansSerif", Font.BOLD, 16));
        frequencyLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
        contentPanel.add(frequencyLabel);
        contentPanel.add(Box.createVerticalStrut(5));

        JPanel frequencyPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        frequencyPanel.setOpaque(false);
        JButton weeklyButton = new JButton("Weekly");
        weeklyButton.setBackground(new Color(135, 206, 250)); // Light Sky Blue
        weeklyButton.setForeground(Color.WHITE);
        weeklyButton.setFont(new Font("SansSerif", Font.BOLD, 14));
        weeklyButton.setFocusPainted(false);
        weeklyButton.setBorder(BorderFactory.createEmptyBorder(8, 15, 8, 15));

        JButton resetButton = new JButton("Reset");
        resetButton.setFont(new Font("SansSerif", Font.PLAIN, 14));
        resetButton.setForeground(Color.BLACK);
        resetButton.setBackground(new Color(220, 220, 220)); // Light Gray
        resetButton.setFocusPainted(false);
        resetButton.setBorder(BorderFactory.createEmptyBorder(8, 15, 8, 15));

        frequencyPanel.add(weeklyButton);
        frequencyPanel.add(Box.createHorizontalStrut(10));
        frequencyPanel.add(resetButton);
        frequencyPanel.setAlignmentX(Component.LEFT_ALIGNMENT);
        contentPanel.add(frequencyPanel);
        contentPanel.add(Box.createVerticalStrut(15));

        // Calendar
        calendar = Calendar.getInstance();
        calendarPanel = new JPanel(new GridLayout(7, 7));
        calendarPanel.setPreferredSize(new Dimension(300, 200));
        calendarPanel.setMaximumSize(new Dimension(300, 200));
        dayButtons = new JButton[42];

        monthLabel = new JLabel();
        monthLabel.setFont(new Font("SansSerif", Font.BOLD, 16));
        monthLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        updateCalendar();

        contentPanel.add(monthLabel);
        contentPanel.add(Box.createVerticalStrut(5));
        contentPanel.add(calendarPanel);
        contentPanel.add(Box.createVerticalStrut(20));

        // Service Provider
        JLabel providerLabel = new JLabel("🐕 Service Provider");
        providerLabel.setFont(new Font("SansSerif", Font.BOLD, 16));
        providerLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
        contentPanel.add(providerLabel);
        contentPanel.add(Box.createVerticalStrut(5));
        JTextField providerTextField = new JTextField("Groomer");
        providerTextField.setFont(new Font("SansSerif", Font.PLAIN, 14));
        contentPanel.add(providerTextField);
        contentPanel.add(Box.createVerticalStrut(20));

        // Find Button
        JButton findButton = new JButton("🔍 Find Services");
        findButton.setBackground(new Color(65, 105, 225)); // Royal Blue
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
        JPanel bottomNav = new JPanel(new FlowLayout(FlowLayout.CENTER, 40, 10));
        bottomNav.setBackground(new Color(224, 255, 255)); // Light Cyan
        bottomNav.setBorder(new EmptyBorder(10, 30, 10, 30));

        JButton homeButtonBottom = new JButton("🏠 Home");
        JButton notificationsButtonBottom = new JButton("🔔 Alerts");
        JButton pmButtonBottom = new JButton("✉ Messages");

        Font bottomFont = new Font("SansSerif", Font.PLAIN, 13);
        for (JButton btn : new JButton[]{homeButtonBottom, notificationsButtonBottom, pmButtonBottom}) {
            btn.setFont(bottomFont);
            btn.setBackground(new Color(176, 224, 230));
            btn.setFocusPainted(false);
        }

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

        int firstDayOfMonth = calendar.get(Calendar.DAY_OF_WEEK) - 1;
        int daysInMonth = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);

        calendarPanel.removeAll();
        String[] dayNames = {"Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat"};
        for (String day : dayNames) {
            JLabel label = new JLabel(day, SwingConstants.CENTER);
            label.setFont(new Font("SansSerif", Font.BOLD, 12));
            calendarPanel.add(label);
        }

        for (int i = 0; i < 42; i++) {
            if (i < firstDayOfMonth || i >= firstDayOfMonth + daysInMonth) {
                dayButtons[i] = new JButton("");
                dayButtons[i].setEnabled(false);
            } else {
                int day = i - firstDayOfMonth + 1;
                dayButtons[i] = new JButton(String.valueOf(day));
                if (day >= 15 && day <= 18) {
                    dayButtons[i].setBackground(new Color(173, 216, 230));
                } else {
                    dayButtons[i].setBackground(Color.WHITE);
                }
                dayButtons[i].setFocusPainted(false);
                final int selectedDay = day;
                dayButtons[i].addActionListener(e -> System.out.println("Selected date: " + selectedDay + " " +
                        calendar.getDisplayName(Calendar.MONTH, Calendar.SHORT, Locale.getDefault()) + " " +
                        calendar.get(Calendar.YEAR)));
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