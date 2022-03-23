package ui.tools;

import model.Exercise;
import ui.GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class PlanningUI extends JInternalFrame implements ActionListener {
    private JInternalFrame planningPanel;
    private JInternalFrame workoutPanel;

    int y = 0;
    JLabel jlabel;
    JCheckBox cb1;
    JCheckBox cb2;
    JCheckBox cb3;
    JCheckBox cb4;
    JCheckBox temp;
    JButton jbutton;

    public PlanningUI(Component parent) {
        jlabel = new JLabel("What exercises would you like to add?");
        jlabel.setBounds(50, 50, 300, 20);
        cb1 = new JCheckBox("Seated Rows (Back) -- 4s8r");
        cb1.setBounds(50, 100, 300, 20);
        cb2 = new JCheckBox("DeadLift (Glutes) -- 3s10r");
        cb2.setBounds(50, 150, 300, 20);
        cb3 = new JCheckBox("Barbell Squat (Quads) -- 4s8r");
        cb3.setBounds(50, 200, 300, 20);
        cb4 = new JCheckBox("Shoulder Press (Shoulders) -- 4s15r");
        cb4.setBounds(50, 250, 300, 20);
        jbutton = new JButton("Add to Plan");
        jbutton.setBounds(75, 300, 200, 30);
        jbutton.addActionListener(this);
        add(jlabel);
        add(cb1);
        add(cb2);
        add(cb3);
        add(cb4);
        add(jbutton);
        setSize(400, 400);
        setLayout(null);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

//    public PlanningUI(ArrayList<Exercise> ec, Component parent) {
//        jlabel = new JLabel("What exercises would you like to add?");
//        jlabel.setBounds(50, 50, 300, 20);
//        for (Exercise e : ec) {
//            y++;
//            temp = new JCheckBox(e.getExerciseName() + "(" + e.getCategoryName() + ")");
//            temp.setBounds(50, 100 * y, 300, 20);
//            add(temp);
//        }
//        jbutton = new JButton("Add to Plan");
//        jbutton.setBounds(100, 300, 80, 30);
//        jbutton.addActionListener(this);
//        add(jlabel);
//        add(cb1);
//        add(cb2);
//        add(cb3);
//        add(cb4);
//        add(jbutton);
//        setSize(400, 400);
//        setLayout(null);
//        setVisible(true);
//        setDefaultCloseOperation(EXIT_ON_CLOSE);
//
//    }

    private void addWorkoutPanel() {
        //stub
    }

//    private void addCheckBox() {
//        l = new JLabel("What exercises would you like to add?");
//        l.setBounds(50, 50, 300, 20);
//        cb1 = new JCheckBox("Seated Rows (Back) -- 4s8r");
//        cb1.setBounds(100, 100, 150, 20);
//        cb2 = new JCheckBox("DeadLift (Glutes) -- 3s10r");
//        cb2.setBounds(100, 150, 150, 20);
//        cb3 = new JCheckBox("Barbell Squat (Quads) -- 4s8r");
//        cb3.setBounds(100, 200, 150, 20);
//        cb4 = new JCheckBox("Shoulder Press (Shoulders) -- 4s15r");
//        cb4.setBounds(100,250,150,20);
//        b = new JButton("Order");
//        b.setBounds(100, 250, 80, 30);
//        b.addActionListener(this);
//        add(l);
//        add(cb1);
//        add(cb2);
//        add(cb3);
//        add(b);
//        setSize(400, 400);
//        setLayout(null);
//        setVisible(true);
//        setDefaultCloseOperation(EXIT_ON_CLOSE);
//    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int amount = 0;
        String msg = "";
        if (cb1.isSelected()) {
            amount += 1;
            msg = "Seated Rows (Back) -- 4s8r\n";
        }
        if (cb2.isSelected()) {
            amount += 1;
            msg += "DeadLift (Glutes) -- 3s10r\n";
        }
        if (cb3.isSelected()) {
            amount += 1;
            msg += "Barbell Squat (Quads) -- 4s8r\n";
        }
        if (cb4.isSelected()) {
            amount += 1;
            msg += "Shoulder Press (Shoulders) -- 4s15r\n";
        }
        msg += "-----------------\n";
        JOptionPane.showMessageDialog(this, msg + "Total Exercises: " + amount);
    }
}
