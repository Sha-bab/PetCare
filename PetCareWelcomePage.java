import javax.swing.*;
import java.awt.*;

public class PetCareWelcomePage {

    public static void main(String[] args) {
        // Create frame
        JFrame frame = new JFrame("🐶 PetCare");
        frame.setSize(400, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        frame.getContentPane().setBackground(new Color(230, 245, 255)); // Light sky blue

        // Top bar
        JPanel topPanel = new JPanel(new BorderLayout());
        topPanel.setBackground(new Color(180, 220, 255));
        JLabel homeLabel = new JLabel("🏠 Welcome");
        homeLabel.setFont(new Font("SansSerif", Font.BOLD, 18));
        homeLabel.setForeground(new Color(40, 60, 90));
        topPanel.add(homeLabel, BorderLayout.WEST);
        topPanel.setBorder(BorderFactory.createEmptyBorder(15, 20, 15, 20));
        frame.add(topPanel, BorderLayout.NORTH);

        // Center content
        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));
        centerPanel.setBackground(new Color(230, 245, 255));
        centerPanel.setBorder(BorderFactory.createEmptyBorder(40, 30, 10, 30));

        JLabel dogIcon = new JLabel("🐾");
        dogIcon.setFont(new Font("Arial", Font.PLAIN, 40));
        dogIcon.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel titleLabel = new JLabel("PetCare");
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 32));
        titleLabel.setForeground(new Color(50, 90, 130));

        JLabel imagePlaceholder = new JLabel("🐶 [Dog Illustration]");
        imagePlaceholder.setAlignmentX(Component.CENTER_ALIGNMENT);
        imagePlaceholder.setFont(new Font("Arial", Font.ITALIC, 16));
        imagePlaceholder.setForeground(new Color(100, 120, 150));

        JLabel subtitle1 = new JLabel("Manage your pet's health");
        subtitle1.setAlignmentX(Component.CENTER_ALIGNMENT);
        subtitle1.setFont(new Font("SansSerif", Font.BOLD, 16));
        subtitle1.setForeground(new Color(70, 100, 130));
        subtitle1.setBorder(BorderFactory.createEmptyBorder(30, 0, 5, 0));

        JLabel subtitle2 = new JLabel("Explore services for your furry friend");
        subtitle2.setAlignmentX(Component.CENTER_ALIGNMENT);
        subtitle2.setFont(new Font("SansSerif", Font.PLAIN, 14));
        subtitle2.setForeground(new Color(90, 110, 140));

        centerPanel.add(dogIcon);
        centerPanel.add(Box.createVerticalStrut(10));
        centerPanel.add(titleLabel);
        centerPanel.add(Box.createVerticalStrut(30));
        centerPanel.add(imagePlaceholder);
        centerPanel.add(Box.createVerticalStrut(40));
        centerPanel.add(subtitle1);
        centerPanel.add(subtitle2);

        frame.add(centerPanel, BorderLayout.CENTER);

        // Bottom panel with dog-themed icon
        JPanel bottomPanel = new JPanel();
        bottomPanel.setBackground(new Color(200, 230, 255));
        JLabel pawIcon = new JLabel("🐕‍🦺 Ready to Explore?");
        pawIcon.setFont(new Font("Arial", Font.BOLD, 18));
        pawIcon.setForeground(new Color(40, 70, 120));
        bottomPanel.add(pawIcon);
        bottomPanel.setBorder(BorderFactory.createEmptyBorder(20, 10, 20, 10));
        frame.add(bottomPanel, BorderLayout.SOUTH);

        frame.setVisible(true);
    }
}
