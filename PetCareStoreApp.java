import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class PetCareStoreApp extends JFrame {

    public PetCareStoreApp() {
        setTitle("PetCare Store 🐶");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(420, 720);
        setLocationRelativeTo(null);

        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBackground(new Color(245, 250, 255));

        // Top Bar
        JPanel topBar = new JPanel(new BorderLayout());
        topBar.setBackground(new Color(200, 230, 255));
        topBar.setBorder(new EmptyBorder(15, 20, 15, 20));

        JLabel logoLabel = new JLabel("🐾 PetCare Store");
        logoLabel.setFont(new Font("SansSerif", Font.BOLD, 20));

        JButton searchButton = new JButton("🔍");
        searchButton.setFont(new Font("SansSerif", Font.PLAIN, 18));
        styleFlatButton(searchButton);

        topBar.add(logoLabel, BorderLayout.WEST);
        topBar.add(searchButton, BorderLayout.EAST);

        mainPanel.add(topBar, BorderLayout.NORTH);

        // Categories
        JPanel categoryPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 10));
        categoryPanel.setBackground(new Color(245, 250, 255));
        categoryPanel.setBorder(new EmptyBorder(10, 15, 10, 15));

        String[][] categories = {
                {"🍖", "Food"},
                {"🎾", "Toys"},
                {"🛏️", "Beds"},
                {"🎀", "Accessories"}
        };

        for (String[] cat : categories) {
            JButton catButton = new JButton(cat[0] + " " + cat[1]);
            catButton.setBackground(new Color(173, 216, 230));
            catButton.setForeground(Color.WHITE);
            catButton.setFont(new Font("SansSerif", Font.PLAIN, 14));
            catButton.setFocusPainted(false);
            catButton.setBorder(BorderFactory.createEmptyBorder(8, 12, 8, 12));
            catButton.setBorder(BorderFactory.createLineBorder(new Color(100, 150, 200)));
            catButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
            categoryPanel.add(catButton);
        }

        mainPanel.add(categoryPanel, BorderLayout.BEFORE_FIRST_LINE);

        // Product List
        JPanel productListPanel = new JPanel();
        productListPanel.setLayout(new BoxLayout(productListPanel, BoxLayout.Y_AXIS));
        productListPanel.setBackground(new Color(245, 250, 255));
        productListPanel.setBorder(new EmptyBorder(10, 15, 10, 15));

        productListPanel.add(createProductItem("Chew Toys", "$14.99"));
        productListPanel.add(Box.createVerticalStrut(15));
        productListPanel.add(createProductItem("Cat Food", "$24.99"));
        productListPanel.add(Box.createVerticalStrut(15));
        productListPanel.add(createProductItem("Dog Bed", "$34.99"));
        productListPanel.add(Box.createVerticalStrut(15));
        productListPanel.add(createProductItem("Pet Collar", "$12.49"));

        JScrollPane scrollPane = new JScrollPane(productListPanel);
        scrollPane.setBorder(null);
        scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.getVerticalScrollBar().setUnitIncrement(16);

        mainPanel.add(scrollPane, BorderLayout.CENTER);

        // Bottom Bar
        JPanel bottomPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        bottomPanel.setBackground(new Color(200, 230, 255));
        bottomPanel.setBorder(new EmptyBorder(15, 15, 15, 15));

        JButton cartButton = new JButton("🛒 View Cart");
        cartButton.setBackground(new Color(70, 130, 180));
        cartButton.setForeground(Color.WHITE);
        cartButton.setFont(new Font("SansSerif", Font.BOLD, 16));
        cartButton.setFocusPainted(false);
        cartButton.setBorder(BorderFactory.createEmptyBorder(10, 30, 10, 30));
        cartButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        bottomPanel.add(cartButton);

        mainPanel.add(bottomPanel, BorderLayout.SOUTH);

        add(mainPanel);
        setVisible(true);
    }

    private void styleFlatButton(JButton button) {
        button.setFocusPainted(false);
        button.setBorderPainted(false);
        button.setContentAreaFilled(false);
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }

    private JPanel createProductItem(String name, String price) {
        JPanel itemPanel = new JPanel();
        itemPanel.setLayout(new BoxLayout(itemPanel, BoxLayout.Y_AXIS));
        itemPanel.setBackground(Color.WHITE);
        itemPanel.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(220, 220, 220), 1, true),
                new EmptyBorder(15, 15, 15, 15)
        ));
        itemPanel.setMaximumSize(new Dimension(360, 280));
        itemPanel.setAlignmentX(Component.LEFT_ALIGNMENT);

        // Image placeholder
        JPanel imageBox = new JPanel();
        imageBox.setPreferredSize(new Dimension(330, 150));
        imageBox.setBackground(new Color(230, 230, 230));
        JLabel imageText = new JLabel("📷 Image");
        imageText.setFont(new Font("SansSerif", Font.PLAIN, 14));
        imageText.setForeground(Color.DARK_GRAY);
        imageBox.add(imageText);
        itemPanel.add(imageBox);
        itemPanel.add(Box.createVerticalStrut(10));

        // Product Name
        JLabel nameLabel = new JLabel(name);
        nameLabel.setFont(new Font("SansSerif", Font.BOLD, 16));
        nameLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        itemPanel.add(nameLabel);

        // Price
        JLabel priceLabel = new JLabel(price);
        priceLabel.setFont(new Font("SansSerif", Font.PLAIN, 14));
        priceLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        priceLabel.setForeground(new Color(80, 100, 120));
        itemPanel.add(priceLabel);
        itemPanel.add(Box.createVerticalStrut(10));

        // Add to Cart Button
        JButton addToCartButton = new JButton("Add to Cart");
        addToCartButton.setBackground(new Color(100, 160, 220));
        addToCartButton.setForeground(Color.WHITE);
        addToCartButton.setFont(new Font("SansSerif", Font.PLAIN, 14));
        addToCartButton.setBorder(BorderFactory.createEmptyBorder(8, 20, 8, 20));
        addToCartButton.setFocusPainted(false);
        addToCartButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        addToCartButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        itemPanel.add(addToCartButton);

        return itemPanel;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(PetCareStoreApp::new);
    }
}
