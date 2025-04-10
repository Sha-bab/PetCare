import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class MultimediaGalleryApp extends JFrame {

    private JPanel galleryPanel;

    public MultimediaGalleryApp() {
        setTitle("PetCare - Multimedia Gallery");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(420, 700);
        setLocationRelativeTo(null);

        // Main panel with BorderLayout
        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBackground(new Color(240, 248, 255)); // Alice Blue

        // Top Header
        mainPanel.add(createHeaderPanel(), BorderLayout.NORTH);

        // Center Gallery
        mainPanel.add(createGalleryScrollPane(), BorderLayout.CENTER);

        // Bottom Navigation
        mainPanel.add(createBottomNav(), BorderLayout.SOUTH);

        add(mainPanel);
        setVisible(true);
    }

    private JPanel createHeaderPanel() {
        JPanel headerPanel = new JPanel();
        headerPanel.setLayout(new BoxLayout(headerPanel, BoxLayout.Y_AXIS));
        headerPanel.setBackground(new Color(224, 238, 248)); // Light Cyan
        headerPanel.setBorder(new EmptyBorder(12, 15, 12, 15));

        // Top bar
        JPanel topBar = new JPanel(new BorderLayout());
        topBar.setOpaque(false);

        JLabel titleLabel = new JLabel("🐾 PetCare Gallery");
        titleLabel.setFont(new Font("Segoe UI", Font.BOLD, 18));
        topBar.add(titleLabel, BorderLayout.WEST);

        JLabel adLabel = new JLabel("Ad Space");
        adLabel.setFont(new Font("SansSerif", Font.ITALIC, 12));
        adLabel.setForeground(Color.GRAY);
        topBar.add(adLabel, BorderLayout.EAST);

        headerPanel.add(topBar);
        headerPanel.add(Box.createVerticalStrut(8));

        // Search & Filter Row
        JPanel searchRow = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 5));
        searchRow.setOpaque(false);

        JTextField searchField = new JTextField("Search...", 15);
        searchField.setForeground(Color.GRAY);

        JButton sortButton = createSoftButton("Sort");
        JButton filterButton = createSoftButton("Filter");

        searchRow.add(sortButton);
        searchRow.add(filterButton);
        searchRow.add(searchField);

        headerPanel.add(searchRow);
        return headerPanel;
    }

    private JScrollPane createGalleryScrollPane() {
        galleryPanel = new JPanel();
        galleryPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 15, 15));
        galleryPanel.setBackground(Color.WHITE);
        galleryPanel.setBorder(new EmptyBorder(10, 15, 10, 15));

        // Sample data
        List<MediaItem> mediaItems = List.of(
                new MediaItem("Golden Retriever's Frisbee Day", 24, 8),
                new MediaItem("Lazy Sunday for Tabby", 30, 12),
                new MediaItem("Puppy Nap Time", 42, 15)
        );

        for (MediaItem item : mediaItems) {
            galleryPanel.add(createMediaItemPanel(item));
        }

        JScrollPane scrollPane = new JScrollPane(galleryPanel);
        scrollPane.setBorder(null);
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
        return scrollPane;
    }

    private JPanel createMediaItemPanel(MediaItem item) {
        JPanel itemPanel = new JPanel();
        itemPanel.setLayout(new BoxLayout(itemPanel, BoxLayout.Y_AXIS));
        itemPanel.setPreferredSize(new Dimension(170, 210));
        itemPanel.setBackground(new Color(245, 245, 245));
        itemPanel.setBorder(BorderFactory.createLineBorder(new Color(220, 220, 220)));

        // Image Placeholder
        JPanel imagePlaceholder = new JPanel();
        imagePlaceholder.setBackground(new Color(230, 230, 230));
        imagePlaceholder.setPreferredSize(new Dimension(160, 120));
        JLabel imageLabel = new JLabel("Image");
        imageLabel.setForeground(Color.GRAY);
        imagePlaceholder.add(imageLabel);

        // Title
        JLabel titleLabel = new JLabel("<html><div style='width:150px'>" + item.getTitle() + "</div></html>");
        titleLabel.setFont(new Font("SansSerif", Font.BOLD, 13));
        titleLabel.setBorder(new EmptyBorder(5, 8, 0, 8));

        // Likes & Comments
        JPanel statsPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 0));
        statsPanel.setOpaque(false);
        statsPanel.setBorder(new EmptyBorder(5, 10, 8, 10));
        statsPanel.add(new JLabel("❤️ " + item.getLikes()));
        statsPanel.add(new JLabel("💬 " + item.getComments()));

        itemPanel.add(Box.createVerticalStrut(5));
        itemPanel.add(imagePlaceholder);
        itemPanel.add(titleLabel);
        itemPanel.add(statsPanel);

        return itemPanel;
    }

    private JPanel createBottomNav() {
        JPanel bottomNav = new JPanel(new FlowLayout(FlowLayout.CENTER, 40, 10));
        bottomNav.setBackground(new Color(224, 238, 248)); // Light Cyan
        bottomNav.setBorder(new EmptyBorder(10, 10, 10, 10));

        bottomNav.add(createNavButton("🏠", "Home"));
        bottomNav.add(createNavButton("👤", "Profile"));
        bottomNav.add(createNavButton("🛒", "Store"));
        bottomNav.add(createNavButton("📷", "Upload"));

        return bottomNav;
    }

    private JButton createSoftButton(String text) {
        JButton button = new JButton(text);
        button.setBackground(new Color(230, 240, 255));
        button.setFocusPainted(false);
        button.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        button.setBorder(BorderFactory.createEmptyBorder(6, 15, 6, 15));
        return button;
    }

    private JButton createNavButton(String icon, String label) {
        JButton button = new JButton("<html><center>" + icon + "<br>" + label + "</center></html>");
        button.setFocusPainted(false);
        button.setBackground(new Color(230, 240, 255));
        button.setFont(new Font("SansSerif", Font.PLAIN, 12));
        button.setBorder(BorderFactory.createEmptyBorder(10, 15, 10, 15));
        return button;
    }

    private static class MediaItem {
        private final String title;
        private final int likes;
        private final int comments;

        public MediaItem(String title, int likes, int comments) {
            this.title = title;
            this.likes = likes;
            this.comments = comments;
        }

        public String getTitle() { return title; }
        public int getLikes() { return likes; }
        public int getComments() { return comments; }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(MultimediaGalleryApp::new);
    }
}
