import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class ConnectProvidersApp extends JFrame {

    public ConnectProvidersApp() {
        setTitle("Connect with Pet Service Providers");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 600);
        setLocationRelativeTo(null);

        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBackground(new Color(240, 248, 255)); // Alice Blue

        // Top Bar
        JPanel topBar = new JPanel(new FlowLayout(FlowLayout.LEFT));
        topBar.setBackground(new Color(224, 238, 248)); // Light Cyan
        topBar.setBorder(new EmptyBorder(10, 15, 10, 15));

        JButton backButton = new JButton("Back");
        backButton.setFont(new Font("SansSerif", Font.PLAIN, 16));
        backButton.setForeground(Color.BLACK);
        backButton.setBackground(new Color(173, 216, 230)); // Light Blue
        backButton.setFocusPainted(false);
        backButton.setBorder(BorderFactory.createEmptyBorder(8, 15, 8, 15));

        topBar.add(backButton);

        mainPanel.add(topBar, BorderLayout.NORTH);

        // Search Bar
        JPanel searchPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        searchPanel.setBackground(new Color(240, 248, 255)); // Alice Blue
        searchPanel.setBorder(new EmptyBorder(10, 15, 10, 15));

        JTextField searchTextField = new JTextField("Search services", 25);
        searchTextField.setForeground(Color.GRAY);
        searchPanel.add(searchTextField);

        mainPanel.add(searchPanel, BorderLayout.CENTER);

        // Providers List
        JPanel providersPanel = new JPanel();
        providersPanel.setLayout(new BoxLayout(providersPanel, BoxLayout.Y_AXIS));
        providersPanel.setBackground(Color.WHITE);
        providersPanel.setBorder(new EmptyBorder(15, 15, 15, 15));

        providersPanel.add(createProviderItem("Khulna pet care", "Location: Moylapata, Khulna", "Contact: 88019********"));
        providersPanel.add(Box.createVerticalStrut(15));
        providersPanel.add(createProviderItem("Pet Home", "Location: Shibbari, Khulna", "Contact: 8801636982665"));
        providersPanel.add(Box.createVerticalStrut(15));
        providersPanel.add(createProviderItem("KHULNA VetCare [KVC]", "Location: Nirala, Khulna", "Contact: 8801917426782"));

        JScrollPane scrollPane = new JScrollPane(providersPanel);
        scrollPane.setBorder(null);
        mainPanel.add(scrollPane, BorderLayout.SOUTH);

        add(mainPanel);
        setVisible(true);
    }

    private JPanel createProviderItem(String name, String location, String contact) {
        JPanel itemPanel = new JPanel();
        itemPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        itemPanel.setBackground(new Color(245, 245, 245)); // Light Gray
        itemPanel.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(220, 220, 220)), // Light Light Gray
                new EmptyBorder(15, 15, 15, 15)
        ));
        itemPanel.setAlignmentX(Component.LEFT_ALIGNMENT);

        // Avatar Placeholder
        JPanel avatarPlaceholder = new JPanel();
        avatarPlaceholder.setPreferredSize(new Dimension(50, 50));
        avatarPlaceholder.setMaximumSize(new Dimension(50, 50));
        avatarPlaceholder.setBackground(new Color(230, 230, 230)); // Slightly darker gray
        JLabel avatarLabel = new JLabel("Avatar");
        avatarLabel.setForeground(Color.GRAY);
        avatarPlaceholder.add(avatarLabel);
        itemPanel.add(avatarPlaceholder);
        itemPanel.add(Box.createHorizontalStrut(15));

        JPanel textInfoPanel = new JPanel();
        textInfoPanel.setLayout(new BoxLayout(textInfoPanel, BoxLayout.Y_AXIS));
        textInfoPanel.setOpaque(false);

        JLabel nameLabel = new JLabel(name);
        nameLabel.setFont(new Font("SansSerif", Font.BOLD, 16));
        nameLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
        textInfoPanel.add(nameLabel);
        textInfoPanel.add(Box.createVerticalStrut(3));

        JLabel locationLabel = new JLabel(location);
        locationLabel.setFont(new Font("SansSerif", Font.PLAIN, 14));
        locationLabel.setForeground(Color.GRAY);
        locationLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
        textInfoPanel.add(locationLabel);
        textInfoPanel.add(Box.createVerticalStrut(3));

        JLabel contactLabel = new JLabel(contact);
        contactLabel.setFont(new Font("SansSerif", Font.PLAIN, 14));
        contactLabel.setForeground(Color.GRAY);
        contactLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
        textInfoPanel.add(contactLabel);

        itemPanel.add(textInfoPanel);
        itemPanel.add(Box.createHorizontalGlue());

        JButton saveButton = new JButton("Save");
        saveButton.setBackground(new Color(70, 130, 180)); // Steel Blue
        saveButton.setForeground(Color.WHITE);
        saveButton.setFont(new Font("SansSerif", Font.PLAIN, 14));
        saveButton.setFocusPainted(false);
        saveButton.setBorder(BorderFactory.createEmptyBorder(8, 15, 8, 15));
        itemPanel.add(saveButton);

        return itemPanel;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(ConnectProvidersApp::new);
    }
}