package ui.tools;

import com.sun.corba.se.spi.orbutil.threadpool.Work;
import javafx.util.Pair;
import model.Exercise;
import model.WorkoutPlan;
import ui.GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import static java.awt.Desktop.getDesktop;

public class PlanningUI extends JInternalFrame implements ActionListener {
    private WorkoutPlan workoutPlans;

    JLabel jlabel;
    JCheckBox cb1;
    JCheckBox cb2;
    JCheckBox cb3;
    JCheckBox cb4;
    JButton jbutton;

    @Override
    public void actionPerformed(ActionEvent e) {
        //stub
    }

//    public PlanningUI(WorkoutPlan workoutPlan, Component parent) {
//        jlabel = new JLabel("What exercises would you like to add?");
//        jlabel.setBounds(50, 25, 300, 20);
//        cb1 = new JCheckBox("Seated Rows (Back) -- 4s8r");
//        cb1.setBounds(50, 75, 300, 20);
//        cb2 = new JCheckBox("DeadLift (Glutes) -- 3s10r");
//        cb2.setBounds(50, 100, 300, 20);
//        cb3 = new JCheckBox("Barbell Squat (Quads) -- 4s8r");
//        cb3.setBounds(50, 125, 300, 20);
//        cb4 = new JCheckBox("Shoulder Press (Shoulders) -- 4s15r");
//        cb4.setBounds(50, 150, 300, 20);
//        jbutton = new JButton("Add to Plan");
//        jbutton.setBounds(75, 200, 200, 30);
//        jbutton.addActionListener(this);
//        add(jlabel);
//        add(cb1);
//        add(cb2);
//        add(cb3);
//        add(cb4);
//        add(jbutton);
//        setSize(400, 300);
//        setLayout(null);
//        setVisible(true);
//        setDefaultCloseOperation(EXIT_ON_CLOSE);
//    }
//
//    @Override
//    public void actionPerformed(ActionEvent e) {
//        workoutPlans = new WorkoutPlan("My Workout Plan");
//        int amount = 0;
//        String msg = "";
//        if (cb1.isSelected()) {
//            amount += 1;
//            msg = "Seated Rows (Back) -- 4s8r\n";
//            WorkoutPlan.addExerciseSeatedRows(workoutPlans);
//        }
//        if (cb2.isSelected()) {
//            amount += 1;
//            msg += "DeadLift (Glutes) -- 3s10r\n";
//            WorkoutPlan.addExerciseDeadLift(workoutPlans);
//        }
//        if (cb3.isSelected()) {
//            amount += 1;
//            msg += "Barbell Squat (Quads) -- 4s8r\n";
//            WorkoutPlan.addExerciseBarbellSquat(workoutPlans);
//        }
//        if (cb4.isSelected()) {
//            amount += 1;
//            msg += "Shoulder Press (Shoulders) -- 4s15r\n";
//            WorkoutPlan.addExerciseShoulderPress(workoutPlans);
//        }
//        msg += "-----------------\n";
////        JOptionPane.showMessageDialog(this, msg + "Total Exercises: " + amount);
////        workoutPlan = new JTextArea(msg + "Total Exercises: " + amount);
////        desktop.add(new WorkoutPlanUI(workoutPlans, msg, parentT));
//    }
}
