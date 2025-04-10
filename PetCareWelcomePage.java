import javax.swing.*;
import java.awt.*;

public class PetCareWelcomePage {

    public static void main(String[] args) {
        // Create frame
        JFrame frame = new JFrame("PetCare");
        frame.setSize(400, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        // Top bar
        JPanel topPanel = new JPanel(new BorderLayout());
        JLabel homeLabel = new JLabel("\u2302 Welcome"); // Unicode for house symbol
        homeLabel.setFont(new Font("SansSherif", Font.PLAIN, 16));
        topPanel.add(homeLabel, BorderLayout.WEST);
        topPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        frame.add(topPanel, BorderLayout.NORTH);

        // Center content
        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));
        centerPanel.setBorder(BorderFactory.createEmptyBorder(50, 10, 10, 10));

        JLabel titleLabel = new JLabel("PetCare");
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 28));

        // Placeholder for image (optional text or blank space)
        JLabel imagePlaceholder = new JLabel("[Cat Illustration]");
        imagePlaceholder.setAlignmentX(Component.CENTER_ALIGNMENT);
        imagePlaceholder.setFont(new Font("Arial", Font.ITALIC, 14));
        imagePlaceholder.setForeground(Color.GRAY);

        JLabel subtitle1 = new JLabel("Manage your pet's health.");
        subtitle1.setAlignmentX(Component.CENTER_ALIGNMENT);
        subtitle1.setFont(new Font("Arial", Font.BOLD, 16));
        subtitle1.setBorder(BorderFactory.createEmptyBorder(30, 0, 5, 0));

        JLabel subtitle2 = new JLabel("Explore services for your friend");
        subtitle2.setAlignmentX(Component.CENTER_ALIGNMENT);
        subtitle2.setFont(new Font("Arial", Font.PLAIN, 14));

        centerPanel.add(titleLabel);
        centerPanel.add(Box.createVerticalStrut(30));
        centerPanel.add(imagePlaceholder);
        centerPanel.add(Box.createVerticalStrut(50));
        centerPanel.add(subtitle1);
        centerPanel.add(subtitle2);

        frame.add(centerPanel, BorderLayout.CENTER);

        // Bottom icon (optional)
        JPanel bottomPanel = new JPanel();
        JLabel pawIcon = new JLabel("\uD83D\uDC3E"); // Unicode for paw print
        pawIcon.setFont(new Font("Arial", Font.PLAIN, 24));
        bottomPanel.add(pawIcon);
        frame.add(bottomPanel, BorderLayout.SOUTH);

        frame.setVisible(true);
    }
}
