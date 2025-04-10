import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class LoginPage extends JFrame {

    public LoginPage() {
        setTitle("Login");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(350, 500);
        setLocationRelativeTo(null);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.setBackground(new Color(255, 255, 255)); // White
        mainPanel.setBorder(new EmptyBorder(30, 30, 30, 30));

        // Top Bar (Placeholder for "Login")
        JPanel topBarPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        topBarPanel.setOpaque(false);
        JLabel loginLabelTop = new JLabel("Login");
        loginLabelTop.setFont(new Font("SansSerif", Font.PLAIN, 16));
        loginLabelTop.setForeground(Color.BLACK);
        topBarPanel.add(loginLabelTop);
        topBarPanel.setAlignmentX(Component.LEFT_ALIGNMENT);
        mainPanel.add(topBarPanel);
        mainPanel.add(Box.createVerticalStrut(20));

        // Pet Care Title
        JLabel titleLabel = new JLabel("Pet Care");
        titleLabel.setFont(new Font("SansSerif", Font.BOLD, 32));
        titleLabel.setForeground(new Color(47, 79, 79)); // Dark Slate Gray
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        mainPanel.add(titleLabel);
        mainPanel.add(Box.createVerticalStrut(30));

        // Image Placeholder
        JPanel imagePlaceholderPanel = new JPanel();
        imagePlaceholderPanel.setPreferredSize(new Dimension(150, 150));
        imagePlaceholderPanel.setMaximumSize(new Dimension(150, 150));
        imagePlaceholderPanel.setBackground(new Color(220, 220, 220)); // Light Gray
        imagePlaceholderPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        JLabel imageLabel = new JLabel("Image");
        imageLabel.setForeground(Color.GRAY);
        imagePlaceholderPanel.add(imageLabel);
        mainPanel.add(imagePlaceholderPanel);
        mainPanel.add(Box.createVerticalStrut(40));

        // Email Input
        JLabel emailLabel = new JLabel("Email");
        emailLabel.setFont(new Font("SansSerif", Font.PLAIN, 16));
        emailLabel.setForeground(Color.BLACK);
        emailLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
        mainPanel.add(emailLabel);
        mainPanel.add(Box.createVerticalStrut(5));
        JTextField emailTextField = new JTextField();
        emailTextField.setFont(new Font("SansSerif", Font.PLAIN, 14));
        mainPanel.add(emailTextField);
        mainPanel.add(Box.createVerticalStrut(15));

        // Password Input
        JLabel passwordLabel = new JLabel("Password");
        passwordLabel.setFont(new Font("SansSerif", Font.PLAIN, 16));
        passwordLabel.setForeground(Color.BLACK);
        passwordLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
        mainPanel.add(passwordLabel);
        mainPanel.add(Box.createVerticalStrut(5));
        JPasswordField passwordField = new JPasswordField();
        passwordField.setFont(new Font("SansSerif", Font.PLAIN, 14));
        mainPanel.add(passwordField);
        mainPanel.add(Box.createVerticalStrut(30));

        // Get Started Button
        JButton getStartedButton = new JButton("Get Started");
        getStartedButton.setBackground(new Color(47, 79, 79)); // Dark Slate Gray
        getStartedButton.setForeground(Color.WHITE);
        getStartedButton.setFont(new Font("SansSerif", Font.BOLD, 18));
        getStartedButton.setFocusPainted(false);
        mainPanel.add(getStartedButton);

        add(mainPanel);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(LoginPage::new);
    }
}