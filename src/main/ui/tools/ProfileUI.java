package ui.tools;

import model.Profile;

import javax.swing.*;
import java.awt.*;

public class ProfileUI extends JInternalFrame {
    private Profile profile;
    private String name;
    private JTextArea profileDisplay;

    private static final int LOC = 100;
    private static final int WIDTH = 300;
    private static final int HEIGHT = 200;

    public ProfileUI(Profile p, Component parent) {
//        profileDisplay = new JTextField("Your Name: " + p.getName());
        profileDisplay = new JTextArea(
                "Your Profile: \n\nName: " + p.getName() + "\n\nAge: " + p.getAge()
        + "\n\nSkill Level: " + p.getSkillLevel() + "\n \n");
        profileDisplay.setEditable(false);
        profileDisplay.setAlignmentX(CENTER_ALIGNMENT);

//        JButton openClose = new JButton(new OpenCloseAction());
//        openClose.setAlignmentX(CENTER_ALIGNMENT);
        Container cp = getContentPane();
        cp.setLayout(new BoxLayout(cp, BoxLayout.Y_AXIS));
        cp.add(profileDisplay);
//        cp.add(openClose);
        setSize(WIDTH, HEIGHT);
        setPosition(parent);
        setVisible(true);
    }

    private void setPosition(Component parent) {
        setLocation(parent.getWidth() - WIDTH - 50, 0);
    }
}
