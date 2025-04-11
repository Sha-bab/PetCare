import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class ConnectProvidersApp extends JFrame {

    public ConnectProvidersApp() {
        setTitle("Connect with Pet Service Providers");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(420, 640);
        setLocationRelativeTo(null);

        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBackground(new Color(230, 245, 255)); // Light blueish background

        // Top Bar
        JPanel topBar = new JPanel(new FlowLayout(FlowLayout.LEFT));
        topBar.setBackground(new Color(100, 149, 237)); // Cornflower Blue
        topBar.setBorder(new EmptyBorder(12, 20, 12, 20));

        JButton backButton = new JButton("← Back");
        backButton.setFont(new Font("SansSerif", Font.PLAIN, 16));
        backButton.setForeground(Color.WHITE);
        backButton.setBackground(new Color(70, 130, 180)); // Steel Blue
        backButton.setFocusPainted(false);
        backButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        backButton.setBorder(BorderFactory.createEmptyBorder(8, 18, 8, 18));

        topBar.add(backButton);
        mainPanel.add(topBar, BorderLayout.NORTH);

        // Center Panel (Search + Providers List)
        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));
        centerPanel.setBackground(new Color(230, 245, 255)); // Same as background
        centerPanel.setBorder(new EmptyBorder(15, 15, 15, 15));

        // Search Bar
        JTextField searchTextField = new JTextField("🔍 Search for services");
        searchTextField.setForeground(Color.DARK_GRAY);
        searchTextField.setFont(new Font("SansSerif", Font.PLAIN, 14));
        searchTextField.setMaximumSize(new Dimension(Integer.MAX_VALUE, 35));
        searchTextField.setBackground(new Color(245, 255, 255)); // Very light blue
        searchTextField.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(135, 206, 250)), // Sky Blue border
                new EmptyBorder(8, 12, 8, 12)
        ));
        centerPanel.add(searchTextField);
        centerPanel.add(Box.createVerticalStrut(20));

        // Scrollable Providers List
        JPanel providersPanel = new JPanel();
        providersPanel.setLayout(new BoxLayout(providersPanel, BoxLayout.Y_AXIS));
        providersPanel.setBackground(new Color(230, 245, 255));

        providersPanel.add(createProviderItem("🐾 Khulna Pet Care", "📍 Moylapata, Khulna", "📞 88019********"));
        providersPanel.add(Box.createVerticalStrut(15));
        providersPanel.add(createProviderItem("🐕 Pet Home", "📍 Shibbari, Khulna", "📞 8801636982665"));
        providersPanel.add(Box.createVerticalStrut(15));
        providersPanel.add(createProviderItem("🐶 KHULNA VetCare [KVC]", "📍 Nirala, Khulna", "📞 8801917426782"));

        JScrollPane scrollPane = new JScrollPane(providersPanel);
        scrollPane.setBorder(null);
        scrollPane.setBackground(new Color(230, 245, 255));
        scrollPane.getVerticalScrollBar().setUnitIncrement(12);
        centerPanel.add(scrollPane);

        mainPanel.add(centerPanel, BorderLayout.CENTER);
        add(mainPanel);
        setVisible(true);
    }

    private JPanel createProviderItem(String name, String location, String contact) {
        JPanel itemPanel = new JPanel();
        itemPanel.setLayout(new BorderLayout(10, 0));
        itemPanel.setBackground(Color.WHITE);
        itemPanel.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(180, 215, 250)), // Light blue border
                new EmptyBorder(15, 15, 15, 15)
        ));
        itemPanel.setMaximumSize(new Dimension(Integer.MAX_VALUE, 100));

        // Left Avatar
        JPanel avatarPanel = new JPanel();
        avatarPanel.setPreferredSize(new Dimension(60, 60));
        avatarPanel.setBackground(new Color(200, 225, 255)); // Light pastel blue
        avatarPanel.setLayout(new GridBagLayout());
        JLabel avatarLabel = new JLabel("🐾");
        avatarLabel.setFont(new Font("SansSerif", Font.PLAIN, 28));
        avatarPanel.add(avatarLabel);
        itemPanel.add(avatarPanel, BorderLayout.WEST);

        // Center Text
        JPanel textPanel = new JPanel();
        textPanel.setLayout(new BoxLayout(textPanel, BoxLayout.Y_AXIS));
        textPanel.setOpaque(false);

        JLabel nameLabel = new JLabel(name);
        nameLabel.setFont(new Font("SansSerif", Font.BOLD, 16));
        nameLabel.setForeground(new Color(25, 25, 112)); // Midnight Blue
        textPanel.add(nameLabel);

        JLabel locationLabel = new JLabel(location);
        locationLabel.setFont(new Font("SansSerif", Font.PLAIN, 14));
        locationLabel.setForeground(new Color(70, 130, 180)); // Steel Blue
        textPanel.add(locationLabel);

        JLabel contactLabel = new JLabel(contact);
        contactLabel.setFont(new Font("SansSerif", Font.PLAIN, 14));
        contactLabel.setForeground(new Color(70, 130, 180));
        textPanel.add(contactLabel);

        itemPanel.add(textPanel, BorderLayout.CENTER);

        // Save Button
        JButton saveButton = new JButton("Save");
        saveButton.setFont(new Font("SansSerif", Font.PLAIN, 13));
        saveButton.setForeground(Color.WHITE);
        saveButton.setBackground(new Color(65, 105, 225)); // Royal Blue
        saveButton.setFocusPainted(false);
        saveButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        saveButton.setBorder(BorderFactory.createEmptyBorder(8, 15, 8, 15));
        itemPanel.add(saveButton, BorderLayout.EAST);

        return itemPanel;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(ConnectProvidersApp::new);
    }
}
