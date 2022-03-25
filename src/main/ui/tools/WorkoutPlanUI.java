package ui.tools;

import model.WorkoutPlan;

import javax.swing.*;
import java.awt.*;

public class WorkoutPlanUI extends JInternalFrame {
    private JTextArea planDisplay;
    private static final int WIDTH = 300;
    private static final int HEIGHT = 200;

    public WorkoutPlanUI(WorkoutPlan wp, String msg, Component parent) {
        planDisplay = new JTextArea(msg);
        planDisplay.setEditable(false);
        planDisplay.setAlignmentX(CENTER_ALIGNMENT);
        Container cp = getContentPane();
        cp.setLayout(new BoxLayout(cp, BoxLayout.Y_AXIS));
        cp.add(planDisplay);
        setSize(WIDTH, HEIGHT);
        setPosition(parent);
        setVisible(true);
    }

    private void setPosition(Component parent) {
        setLocation(parent.getWidth() - WIDTH - 50, 0);
    }

}
