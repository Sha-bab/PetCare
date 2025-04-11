import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class LoginPage extends JFrame {

    public LoginPage() {
        setTitle("Login - Pet Care");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(380, 540);
        setLocationRelativeTo(null);

        // Main Panel
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.setBackground(new Color(240, 248, 255)); // Alice Blue
        mainPanel.setBorder(new EmptyBorder(30, 30, 30, 30));

        // Top Panel with Title
        JLabel appTitle = new JLabel("🐾 Pet Care");
        appTitle.setFont(new Font("SansSerif", Font.BOLD, 30));
        appTitle.setForeground(new Color(25, 25, 112)); // Midnight Blue
        appTitle.setAlignmentX(Component.CENTER_ALIGNMENT);
        mainPanel.add(appTitle);
        mainPanel.add(Box.createVerticalStrut(10));

        JLabel loginLabel = new JLabel("Welcome back! Please login to continue.");
        loginLabel.setFont(new Font("SansSerif", Font.PLAIN, 14));
        loginLabel.setForeground(new Color(70, 130, 180)); // Steel Blue
        loginLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        mainPanel.add(loginLabel);
        mainPanel.add(Box.createVerticalStrut(20));

        // Image Placeholder (can be replaced with actual image)
        JPanel imagePanel = new JPanel();
        imagePanel.setPreferredSize(new Dimension(120, 120));
        imagePanel.setMaximumSize(new Dimension(120, 120));
        imagePanel.setBackground(new Color(173, 216, 230)); // Light Blue
        imagePanel.setLayout(new GridBagLayout());
        JLabel imageLabel = new JLabel("🐶");
        imageLabel.setFont(new Font("SansSerif", Font.PLAIN, 48));
        imagePanel.add(imageLabel);
        imagePanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        mainPanel.add(imagePanel);
        mainPanel.add(Box.createVerticalStrut(30));

        // Email Field
        JLabel emailLabel = new JLabel("Email Address");
        emailLabel.setFont(new Font("SansSerif", Font.PLAIN, 14));
        emailLabel.setForeground(new Color(25, 25, 112));
        emailLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
        mainPanel.add(emailLabel);
        mainPanel.add(Box.createVerticalStrut(5));

        JTextField emailField = new JTextField();
        emailField.setFont(new Font("SansSerif", Font.PLAIN, 14));
        emailField.setMaximumSize(new Dimension(Integer.MAX_VALUE, 35));
        emailField.setBackground(new Color(224, 255, 255)); // Light Cyan
        emailField.setBorder(BorderFactory.createLineBorder(new Color(100, 149, 237))); // Cornflower Blue
        mainPanel.add(emailField);
        mainPanel.add(Box.createVerticalStrut(15));

        // Password Field
        JLabel passwordLabel = new JLabel("Password");
        passwordLabel.setFont(new Font("SansSerif", Font.PLAIN, 14));
        passwordLabel.setForeground(new Color(25, 25, 112));
        passwordLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
        mainPanel.add(passwordLabel);
        mainPanel.add(Box.createVerticalStrut(5));

        JPasswordField passwordField = new JPasswordField();
        passwordField.setFont(new Font("SansSerif", Font.PLAIN, 14));
        passwordField.setMaximumSize(new Dimension(Integer.MAX_VALUE, 35));
        passwordField.setBackground(new Color(224, 255, 255)); // Light Cyan
        passwordField.setBorder(BorderFactory.createLineBorder(new Color(100, 149, 237)));
        mainPanel.add(passwordField);
        mainPanel.add(Box.createVerticalStrut(25));

        // Login Button
        JButton loginButton = new JButton("Login");
        loginButton.setFont(new Font("SansSerif", Font.BOLD, 16));
        loginButton.setBackground(new Color(65, 105, 225)); // Royal Blue
        loginButton.setForeground(Color.WHITE);
        loginButton.setFocusPainted(false);
        loginButton.setMaximumSize(new Dimension(Integer.MAX_VALUE, 40));
        loginButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        mainPanel.add(loginButton);
        mainPanel.add(Box.createVerticalStrut(20));

        // Footer Message
        JLabel signupLabel = new JLabel("Don't have an account? Sign up");
        signupLabel.setFont(new Font("SansSerif", Font.ITALIC, 12));
        signupLabel.setForeground(new Color(70, 130, 180)); // Steel Blue
        signupLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        mainPanel.add(signupLabel);

        add(mainPanel);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(LoginPage::new);
    }
}
